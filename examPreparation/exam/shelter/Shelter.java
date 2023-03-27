package examPreparation.exam.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.capacity > this.data.size()) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(a -> a.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker)  {
        return data.stream().filter(a -> a.getName().equals(name)
                && a.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }

    public Animal getOldestAnimal()  {
        return data.stream().max(Comparator.comparingInt(Animal::getAge)).orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The examPreparation.exam.shelter has the following animals:").append(System.lineSeparator());
        this.data.forEach(a -> sb.append(a.getName()).append(" ").append(a.getCaretaker()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

}
