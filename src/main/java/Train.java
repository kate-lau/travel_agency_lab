import java.util.ArrayList;

public class Train implements IBookable {
    private String trainName;
    private double price;
    private int capacity;
    private ArrayList<Customer> trainCustomer;

    public Train(String trainName, double price, int capacity){
        this.trainName = trainName;
        this.price = price;
        this.capacity = capacity;
        trainCustomer = new ArrayList<>();
    }

    // INTERFACE METHODS

    public void book(Customer customer){
        if (customer.canAfford(price) && hasCapacity()){
            customer.payment(price);
            trainCustomer.add(customer);
        }
    }

    public void cancel(Customer customer){
        customer.refund(price);
        trainCustomer.remove(customer);
    }

    public boolean hasCapacity(){
        return (getTrainCustomerSize() < getCapacity());
    }

    // GETTERS
    public String getTrainName() {
        return this.trainName;
    }
    public double getPrice() {
        return this.price;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public int getTrainCustomerSize() {
        return trainCustomer.size();
    }

}
