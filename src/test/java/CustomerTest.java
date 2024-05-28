import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerTest {

    Customer customer1;
    Customer customer2;

    @BeforeEach
    public void setUp() {
        customer1 = new Customer("Sunny", 100);
        customer2 = new Customer("Kate", 1000);
    }

    @Test
    public void canGetName() {
        assertThat(customer1.getCustomerName()).isEqualTo("Sunny");
    }

    @Test
    public void cantGetName() {
        assertThat(customer2.getCustomerName()).isNotEqualTo("Sunny");
    }

    @Test
    public void canReturnCorrectWalletAmount() {
        assertThat(customer2.getWallet()).isEqualTo(1000);
    }

    @Test
    public void cantReturnCorrectWalletAmount() {
        assertThat(customer1.getWallet()).isNotEqualTo(1000);
    }

    @Test
    public void canAfford() {
        assertThat(customer1.canAfford(10)).isEqualTo(true);
    }

    @Test
    public void cantAfford() {
        assertThat(customer2.canAfford(100000)).isEqualTo(false);
    }

    @Test
    public void canMakePayment() {
        customer2.payment(10);
        assertThat(customer2.getWallet()).isEqualTo(990);
    }

    @Test
    public void canGetRefund() {
        customer2.payment(10);
        customer2.refund(10);
        assertThat(customer2.getWallet()).isEqualTo(1000);
    }

}
