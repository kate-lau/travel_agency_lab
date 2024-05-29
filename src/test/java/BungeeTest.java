import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BungeeTest {
    Activity bungee;
    Customer customer;
    Customer customer2;
    Customer customer3;

    @BeforeEach
    public void setUp() {
        bungee = new Bungee(LocalDate.of(2024, 7, 2), 10, 2);
        customer = new Customer("Kate", 100);
        customer2 = new Customer("Sunny", 10);
        customer3 = new Customer("Steve", 5);

        customer.setCustomerAge(18);
        customer2.setCustomerAge(18);
        customer3.setCustomerAge(18);
    }

    @Test
    public void canBookBungee() {
        bungee.book(customer);
        bungee.book(customer2);
        assertThat(bungee.getParticipantsSize()).isEqualTo(2);
    }

    @Test
    public void cannotBookBungeeNoMoney() {
        bungee.book(customer);
        bungee.book(customer3);
        assertThat(bungee.getParticipantsSize()).isEqualTo(1);
    }

    @Test
    public void canCancelBungee() {
        bungee.book(customer);
        bungee.book(customer2);
        bungee.cancel(customer2);
        assertThat(bungee.getParticipantsSize()).isEqualTo(1);
    }

    @Test
    public void canBookIfUnderEighteen() {
        bungee.book(customer);
        assertThat(bungee.getParticipantsSize()).isEqualTo(1);
    }

    @Test
    public void cannotBookIfUnderEighteen() {
        customer.setCustomerAge(17);
        bungee.book(customer);
        assertThat(bungee.getParticipantsSize()).isEqualTo(0);
    }
}
