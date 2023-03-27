package examPreparation.type03.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String type, int capacity) {
        this.name = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }

    public Car getLatestCar() {
        Car car = data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        Car car = data.stream().filter(c -> c.getManufacturer().equals(manufacturer)
                && c.getModel().equals(model)).findFirst().orElse(null);
        return car;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car examPreparation.type03.dealership ").append(this.name).append(":").append(System.lineSeparator());
        this.data.forEach(c -> sb.append(c.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
