public interface IBookable {
    void book();
    void cancel();
    double getPrice();
    boolean hasCapacity();
}
