package definingClasses.carInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    protected Car(String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP."
                , this.brand, this.model, this.horsePower);
    }
}
