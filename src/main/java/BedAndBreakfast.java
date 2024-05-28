public abstract class BedAndBreakfast implements IBookable {
    private String bnbName;
    private double price;
    private String leadCustomer;

    public BedAndBreakfast(String bnbName, double price, String leadCustomer){
        this.bnbName = bnbName;
        this.price = price;
        this.leadCustomer = leadCustomer; // Customer(?)
    }

}
