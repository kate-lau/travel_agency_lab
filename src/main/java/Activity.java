import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Activity implements IBookable{
    private LocalDate timeSlot;
    private double price;
    private int capacity;
    private ArrayList<Customer> participants;

    public Activity(LocalDate timeSlot, double price, int capacity) {
        this.timeSlot = timeSlot;
        this.price = price;
        this.capacity = capacity;
        participants = new ArrayList<>();
    }

    public void book(Customer customer){
        if (customer.canAfford(price) && hasCapacity()){
            this.capacity = this.capacity - 1;
            customer.payment(price);
            participants.add(customer);
        }
    }

    public void cancel(Customer customer){
        customer.refund(price);
        capacity++;
        participants.remove(customer);
    }

    public double getPrice() {
        return this.price;
    }

    public boolean hasCapacity() {
        return (this.capacity > 0);
    }

    public int getCapacity() {
        return this.capacity;
    }

}


