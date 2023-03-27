package definingClasses.companyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = "n/a";
            int age = -1;
            if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            } else if(input.length > 5) {
                email = input[4];
                age = Integer.parseInt(input[5]);
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            employeeList.add(employee);
        }

        List<String> departmentNames = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        List<Department> departments = departmentNames.stream()
                .map(department -> new Department(department, employeeList.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())))
                .sorted(Comparator.comparingDouble(Department::getAvgSalary).reversed())
                .collect(Collectors.toList());

        Department department = departments.get(0);
        department.getEmployeeList()
                .sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println(department.toString());
        for (Employee employee : department.getEmployeeList()) {
            System.out.println(employee.toString());
        }
    }
}
