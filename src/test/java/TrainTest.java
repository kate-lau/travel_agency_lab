import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrainTest {
    Train train;
    Customer customer;
    Customer customer2;
    Customer customer3;

    @BeforeEach
    public void setUp(){
        train = new Train("Thomas", 200, 50);
        customer = new Customer("Kate", 300);
        customer2 = new Customer("Kevin", 10);
        customer3 = new Customer("Ken", 500);
    }

    @Test
    public void canGetTrainName(){
        assertThat(train.getTrainName()).isEqualTo("Thomas");
    }
    @Test
    public void canGetPrice(){
        assertThat(train.getPrice()).isEqualTo(200);
    }
    @Test
    public void canGetCapacity(){
        assertThat(train.getCapacity()).isEqualTo(50);
    }
    @Test
    public void canBookTrain(){
        train.book(customer);
        assertThat(train.getCapacity()).isEqualTo(49);
    }
    @Test
    public void cannotBookTrain(){
        train.book(customer);
        train.book(customer2);
        assertThat(train.getCapacity()).isEqualTo(49);
    }

    @Test
    public void canCancelTrain(){
        train.book(customer);
        train.book(customer3);
        train.cancel(customer3);
        assertThat(train.getCapacity()).isEqualTo(49);
    }
}
