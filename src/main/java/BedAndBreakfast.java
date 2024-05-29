import java.util.ArrayList;

public class BedAndBreakfast implements IBookable {
    private String bnbName;
    private double price;
    private int capacity;
    private String leadCustomer;

    public BedAndBreakfast(String bnbName, double price, int capacity){
        this.bnbName = bnbName;
        this.price = price;
        this.capacity = capacity;
    }

    // INTERFACE METHODS

    public void book(Customer customer) {
        if(customer.canAfford(price) && hasCapacity()) {
            customer.payment(price);
            this.leadCustomer = customer.getCustomerName();
            capacity--;
        }
    }

    public void cancel(Customer customer) {
        customer.refund(price);
        capacity++;
        setLeadCustomer("");
    }

    public boolean hasCapacity() {
        return (capacity > 0);
    }

    // EXTRA METHODS

    public String getBnbName() {
        return bnbName;
    }

    public double getPrice() {
        return price;
    }

    public void setLeadCustomer(String leadCustomer) {
        this.leadCustomer = leadCustomer;
    }

    public String getLeadCustomer() {
        return leadCustomer;
    }

}
