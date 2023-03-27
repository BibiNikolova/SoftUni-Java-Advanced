package examPreparation.type03.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.capacity > data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
//        for (int i = 0; i < this.data.size(); i++) {
//            Present present = this.data.get(i);
//            if (present.getName().equals(name)) {
//                this.data.remove(i);
//                return true;
//            }
//        }
//        return false;
        return this.data.removeIf(present -> present.getName().equals(name));
    }

    public Present heaviestPresent() {
        return data.stream().max(Comparator.comparingDouble(Present::getWeight)).get();
    }

    public Present getPresent(String name) {
        return data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {

        StringBuilder sb = new StringBuilder();

        sb.append(color).append(" bag contains:").append(System.lineSeparator());
        this.data.forEach(present -> sb.append(present.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
