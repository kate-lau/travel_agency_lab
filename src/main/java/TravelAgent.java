import java.util.ArrayList;

public class TravelAgent {
    private String agencyName;

    public TravelAgent(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public void makeBooking(Customer customer, IBookable bookable){
        bookable.book(customer);
    }

    public void cancelBooking(Customer customer, IBookable bookable) {
        bookable.cancel(customer);
    }

}
