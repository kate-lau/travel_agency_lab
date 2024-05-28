import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Activity implements IBookable{
    private LocalDate timeSlot;
    private double price;
    private int capacity;
    private ArrayList<Customer> participants;

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

}


