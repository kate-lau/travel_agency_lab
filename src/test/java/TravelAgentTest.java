import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TravelAgentTest {

    TravelAgent travelAgent;
    Customer customer;
    Train train;
    BedAndBreakfast bnb;

    @BeforeEach
    public void setUp(){
        travelAgent = new TravelAgent("Jet2");
        customer = new Customer("Kate", 500);
        train = new Train ("Amsterdam", 10, 100);
        bnb = new BedAndBreakfast("Hotel", 50, 10);
    }

    @Test
    public void canMakeBooking(){
        travelAgent.makeBooking(customer, train);
        assertThat(train.getCapacity()).isEqualTo(99);
    }

    @Test
    public void canCancelBooking(){
        travelAgent.makeBooking(customer, train);
        travelAgent.cancelBooking(customer, train);
        assertThat(train.getCapacity()).isEqualTo(100);
    }

}
