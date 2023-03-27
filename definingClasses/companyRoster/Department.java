package definingClasses.companyRoster;

import java.util.List;

public class Department {
    private String depName;
    private List<Employee> employeeList;
    private double avgSalary;

    public Department(String depName, List<Employee> employeeList) {
        this.depName = depName;
        this.employeeList = employeeList;
        this.avgSalary = employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    public String getDepName() {
        return depName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    @Override
    public String toString() {
        return String.format("Highest Average Salary: %s", this.depName);
    }
}
