package examPreparation.type03.vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparingInt(Pet::getAge)).orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        this.data.forEach(p -> sb.append(p.getName()).append(" ")
                .append(p.getOwner()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
