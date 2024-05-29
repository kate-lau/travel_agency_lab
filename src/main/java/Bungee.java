import java.time.LocalDate;

public class Bungee extends Activity{

    public Bungee(LocalDate timeslot, double price, int capacity) {
        super(timeslot, price, capacity);
    }

    public boolean overEighteen(Customer customer){
        return (customer.getCustomerAge() >= 18);
    }

    @Override
    public void book(Customer customer) {
        if(overEighteen(customer))
            super.book(customer);
    }
}
