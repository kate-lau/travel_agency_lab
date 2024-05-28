import java.util.ArrayList;

public class TravelAgent {
    private String agencyName;
    private ArrayList<IBookable> bookable;

    public void makeBooking(Customer customer, IBookable bookable){
        bookable.book();
    }

}
