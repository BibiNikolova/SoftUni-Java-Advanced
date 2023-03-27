package examPreparation.type03.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Car> getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
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
        sb.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        this.data.forEach(c -> sb.append(c.toString()).append(System.lineSeparator()));

        return sb.toString().trim();

    }
}
