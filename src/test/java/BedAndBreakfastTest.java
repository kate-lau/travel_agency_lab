import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BedAndBreakfastTest {

    BedAndBreakfast bnb;
    Customer customer;
    Customer customer2;
    Customer customer3;
    Customer customer4;

    @BeforeEach
    public void setUp() {
        customer = new Customer("Steve", 1000);
        customer2 = new Customer("Dave", 5);
        customer3 = new Customer("Pete", 100);
        customer4 = new Customer("Aaron", 100);
        bnb = new BedAndBreakfast("Travelodge", 10, 2);
    }

    @Test
    public void canGetBnbName() {
        assertThat(bnb.getBnbName()).isEqualTo("Travelodge");
    }

    @Test
    public void canGetPrice() {
        assertThat(bnb.getPrice()).isEqualTo(10);
    }

    @Test
    public void canSetLeadCustomer() {
        bnb.setLeadCustomer("Test");
        assertThat(bnb.getLeadCustomer()).isEqualTo("Test");
    }

    @Test
    public void canBook() {
        bnb.book(customer);
        assertThat(bnb.getLeadCustomer()).isEqualTo("Steve");
    }

    @Test
    public void cannotBook() {
        bnb.book(customer2);
        assertThat(bnb.getLeadCustomer()).isNotEqualTo("Dave");
    }

    @Test
    public void customerCharged() {
        bnb.book(customer);
        assertThat(customer.getWallet()).isEqualTo(990);
    }

    @Test
    public void customerNotCharged() {
        bnb.book(customer2);
        assertThat(customer2.getWallet()).isEqualTo(5);
    }

    @Test
    public void cancelBooking() {
        bnb.book(customer);
        bnb.cancel(customer);
        assertThat(customer.getWallet()).isEqualTo(1000);
    }

    @Test
    public void bnbHasCapacity() {
        bnb.book(customer);
        assertThat(bnb.hasCapacity()).isEqualTo(true);
    }

    @Test public void bnbDoesNotHaveCapacity() {
        bnb.book(customer);
        bnb.book(customer3);
        bnb.book(customer4);
        assertThat(customer4.getWallet()).isEqualTo(100);
    }

}
