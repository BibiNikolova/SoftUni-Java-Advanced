package setsAndMaps.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        Employee employee = employees.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
        return employee;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(this.name).append(":").append(System.lineSeparator());
        this.employees.forEach(c -> sb.append(c.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
