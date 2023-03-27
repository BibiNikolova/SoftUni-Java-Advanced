package examPreparation.type03.aquarium;

import java.util.*;


public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private Set<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        int fins = fishInPool.stream().mapToInt(Fish::getFins).sum();

        if (!fishInPool.contains(fish) && this.capacity > fishInPool.size()) {
            fishInPool.add(fish);
        }
    }
//    this.size > fins + fish.getFins()

    public boolean remove(String name) {
        return fishInPool.removeIf(f -> f.getName().equals(name));

    }

    public Fish findFish(String name) {
        return fishInPool.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);

    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append("Aquarium: ").append(name).append(" ^ ").append("Size: ")
                .append(size).append(System.lineSeparator());
        this.fishInPool.forEach(f -> sb.append(f.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}


