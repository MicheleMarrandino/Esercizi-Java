package Vehicles;

public class Car extends Vehicle{
    protected Integer cc;

    public Car(String name, String brand, Double price, Integer year, Integer cc) {
        super(name, brand, price, year);
        this.cc = cc;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }
}
