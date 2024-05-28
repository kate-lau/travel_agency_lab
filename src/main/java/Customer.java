public class Customer {
    private String customerName;
    private int customerAge;
    private double wallet;

    public Customer(String customerName, double wallet){
        this.customerName = customerName;
        this.wallet = wallet;
    }

    public void setCustomerAge(int age){
        this.customerAge = age;
    }
    public int getCustomerAge(){
        return this.customerAge;
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
        return (this.wallet - amount >= 0);
    }
}
