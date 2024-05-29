import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasketballTest {

    Activity basketball;
    Customer customer;
    Customer customer2;
    Customer customer3;

    @BeforeEach
    public void setUp() {
        basketball = new Basketball(LocalDate.of(2024, 6, 3), 10, 2);
        customer = new Customer("Kate", 100);
        customer2 = new Customer("Sunny", 10);
        customer3 = new Customer("Steve", 5);
    }

    @Test
    public void canBookBasketball() {
        basketball.book(customer);
        basketball.book(customer2);
        assertThat(basketball.getCapacity()).isEqualTo(0);
    }

    @Test
    public void cannotBookBasketballNoMoney() {
        basketball.book(customer);
        basketball.book(customer3);
        assertThat(basketball.getCapacity()).isEqualTo(1);
    }

    @Test
    public void canCancelBasketball() {
        basketball.book(customer);
        basketball.book(customer2);
        basketball.cancel(customer2);
        assertThat(basketball.getCapacity()).isEqualTo(1);
    }
}
