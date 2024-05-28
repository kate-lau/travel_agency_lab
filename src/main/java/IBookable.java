public interface IBookable {
    void book(Customer customer);
    void cancel(Customer customer);
    double getPrice();
    boolean hasCapacity();
}
