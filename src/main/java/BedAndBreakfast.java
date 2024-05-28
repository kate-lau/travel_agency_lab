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

    public String getBnbName() {
        return bnbName;
    }

    public double getPrice() {
        return price;
    }

    public String getLeadCustomer() {
        return leadCustomer;
    }

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
    }

    public boolean hasCapacity() {
        if(capacity > 0) {
            return true;
        }
        return false;
    }
}
