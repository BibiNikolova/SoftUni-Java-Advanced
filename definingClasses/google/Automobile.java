package definingClasses.google;

public class Automobile {
    private String model;
    private  int power;

    public Automobile(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return String.format("%s %d", model, power);
    }
}
