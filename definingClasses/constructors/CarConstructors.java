package definingClasses.constructors;

public class CarConstructors {
    private String brand;
    private String model;
    private int horsePower;

    public CarConstructors(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public CarConstructors(String brand) {
        this(brand, "unknown", -1);
    }
    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP."
                , this.brand, this.model, this.horsePower);
    }

}
