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

    // MORE METHODS

    public boolean hasCapacity(){
        if (this.getCapacity() > 0){
            return true;
        }
       return false;
    }

    public void book(Customer customer){
        if (customer.canAfford(price) && hasCapacity()){
            this.capacity = this.capacity - 1;
            customer.payment(price);
            trainCustomer.add(customer);
        }
    }

    public void cancel(Customer customer){
        customer.refund(price);
        capacity++;
        trainCustomer.remove(customer);
    }
}
