import java.util.ArrayList;

public class TravelAgent {
    private String agencyName;
    private ArrayList<IBookable> bookable;

    public TravelAgent(String agencyName) {
        this.agencyName = agencyName;
    }

    public void makeBooking(Customer customer, IBookable bookable){
        bookable.book(customer);
    }

    public void cancelBooking(Customer customer, IBookable bookable) {
        bookable.cancel(customer);
    }

}
