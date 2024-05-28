public class Customer {
    private String customerName;
    private double wallet;

    public Customer(String customerName, double wallet){
        this.customerName = customerName;
        this.wallet = wallet;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public double getWallet() {
        return wallet;
    }

    public void payment(double amount){
        this.wallet = wallet - amount;
    }

    public void refund(double amount) {
        this.wallet += amount;
    }

    public boolean canAfford(double amount){
        if (this.wallet - amount >= 0){
            return true;
        }
        else return false;
    }
}
