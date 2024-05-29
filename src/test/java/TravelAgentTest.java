import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TravelAgentTest {

    TravelAgent travelAgent;

    Customer customer;
    Customer customer2;
    Customer customer3;
    Customer customer4;

    Train train;
    BedAndBreakfast bnb;

    Activity bungee;
    Activity basketball;

    @BeforeEach
    public void setUp(){
        travelAgent = new TravelAgent("Jet2");

        customer = new Customer("Kate", 500);
        customer2 = new Customer("Sunny", 100);
        customer3 = new Customer("Pete", 10);
        customer4 = new Customer("Steve", 5);

        customer.setCustomerAge(18);
        customer2.setCustomerAge(18);
        customer3.setCustomerAge(18);
        customer4.setCustomerAge(18);

        train = new Train ("Amsterdam", 10, 2);
        bnb = new BedAndBreakfast("Hotel", 50, 1);

        bungee = new Bungee(LocalDate.of(2024, 7, 2), 10, 2);
        basketball = new Basketball(LocalDate.of(2024, 6, 3), 10, 2);
    }

    @Test
    public void canMakeTrainBooking(){
        travelAgent.makeBooking(customer, train);
        assertThat(train.getTrainCustomerSize()).isEqualTo(1);
    }

    @Test
    public void canCancelTrainBooking(){
        travelAgent.makeBooking(customer, train);
        travelAgent.cancelBooking(customer, train);
        assertThat(train.getCapacity()).isEqualTo(2);
    }

    @Test
    public void canMakeBnbBooking(){
        travelAgent.makeBooking(customer, bnb);
        assertThat(bnb.getLeadCustomer()).isEqualTo(customer.getCustomerName());
    }

    @Test
    public void canCancelBnbBooking(){
        travelAgent.makeBooking(customer, bnb);
        travelAgent.cancelBooking(customer, bnb);
        assertThat(bnb.getLeadCustomer()).isEqualTo("");
    }

    @Test
    public void cannotBookTrainAtMaxCap() {
        travelAgent.makeBooking(customer, train);
        travelAgent.makeBooking(customer2, train);
        travelAgent.makeBooking(customer3, train);
        assertThat(train.getTrainCustomerSize()).isEqualTo(2);
    }

    @Test
    public void cannotBookBnbAtMaxCap() {
        travelAgent.makeBooking(customer, bnb);
        travelAgent.makeBooking(customer2, bnb);
        assertThat(bnb.hasCapacity()).isEqualTo(false);
    }

    @Test
    public void cannotBookTrainWithNoMoney() {
        travelAgent.makeBooking(customer, train);
        travelAgent.makeBooking(customer4, train);
        assertThat(train.getTrainCustomerSize()).isEqualTo(1);
    }

    @Test
    public void cannotBookBnbWithNoMoney() {
        travelAgent.makeBooking(customer4, bnb);
        assertThat(bnb.hasCapacity()).isEqualTo(true);
    }

    @Test
    public void canBookBasketball() {
        travelAgent.makeBooking(customer, basketball);
        travelAgent.makeBooking(customer2, basketball);
        assertThat(basketball.getCapacity()).isEqualTo(0);
    }

    @Test
    public void cannotBookBasketballNoMoney() {
        travelAgent.makeBooking(customer, basketball);
        travelAgent.makeBooking(customer4, basketball);
        assertThat(basketball.getCapacity()).isEqualTo(1);
    }

    @Test
    public void canCancelBasketball() {
        travelAgent.makeBooking(customer, basketball);
        travelAgent.makeBooking(customer2, basketball);
        travelAgent.cancelBooking(customer2, basketball);
        assertThat(basketball.getCapacity()).isEqualTo(1);
    }

    @Test
    public void canBookBungee() {
        travelAgent.makeBooking(customer, bungee);
        travelAgent.makeBooking(customer2, bungee);
        assertThat(bungee.getCapacity()).isEqualTo(0);
    }

    @Test
    public void cannotBookBungeeNoMoney() {
        travelAgent.makeBooking(customer, bungee);
        travelAgent.makeBooking(customer4, bungee);
        assertThat(bungee.getCapacity()).isEqualTo(1);
    }

    @Test
    public void canCancelBungee() {
        travelAgent.makeBooking(customer, bungee);
        travelAgent.makeBooking(customer2, bungee);
        travelAgent.cancelBooking(customer2, bungee);
        assertThat(bungee.getCapacity()).isEqualTo(1);
    }

    @Test
    public void canChargeBooking(){
        travelAgent.makeBooking(customer, train);
        assertThat(customer.getWallet()).isEqualTo(490);
    }

    @Test
    public void canChargeBnb(){
        travelAgent.makeBooking(customer, bnb);
        assertThat(customer.getWallet()).isEqualTo(450);
    }

    @Test
    public void canChargeBungee(){
        travelAgent.makeBooking(customer, bungee);
        assertThat(customer.getWallet()).isEqualTo(490);
    }

    @Test
    public void canChargeBasketball(){
        travelAgent.makeBooking(customer, basketball);
        assertThat(customer.getWallet()).isEqualTo(490);
    }

    @Test
    public void canRefundTrain(){
        travelAgent.makeBooking(customer, train);
        travelAgent.cancelBooking(customer, train);
        assertThat(customer.getWallet()).isEqualTo(500);
    }

    @Test
    public void canRefundBnb(){
        travelAgent.makeBooking(customer, bnb);
        travelAgent.cancelBooking(customer, bnb);
        assertThat(customer.getWallet()).isEqualTo(500);
    }

    @Test
    public void canRefundBungee(){
        travelAgent.makeBooking(customer, bungee);
        travelAgent.cancelBooking(customer, bungee);
        assertThat(customer.getWallet()).isEqualTo(500);
    }

    @Test
    public void canRefundBasketball(){
        travelAgent.makeBooking(customer, basketball);
        travelAgent.cancelBooking(customer, basketball);
        assertThat(customer.getWallet()).isEqualTo(500);
    }
}
