package functionalProgramming;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Supplier<Person> creator = () -> {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            return new Person(name, age);
        };

        List<Person> people = IntStream.range(0, n)
                .mapToObj(ignored -> creator.get())
                .collect(Collectors.toList());

        String olderOrYounger = scanner.nextLine();
        int comparableAge = Integer.parseInt(scanner.nextLine());
        String[] whatToBePrinted = scanner.nextLine().split(" ");

        Predicate<Person> ageFilter = getFilter(olderOrYounger, comparableAge);
        Consumer<Person> printer = getPrinter(whatToBePrinted);

        people.stream()
                .filter(ageFilter)
                .forEach(printer);

    }

    private static Consumer<Person> getPrinter(String[] whatToBePrinted) {
        if (whatToBePrinted.length == 2) {
            return p -> System.out.println(p.name + " - " + p.age);
        } else if (whatToBePrinted[0].equals("name")) {
            return p -> System.out.println(p.name);
        }
        return p -> System.out.println(p.age);
    }

    public static Predicate<Person> getFilter(String olderOrYounger, int comparableAge) {
        return olderOrYounger.equals("older")
                ? p -> p.age >= comparableAge
                : p -> p.age <= comparableAge;
    }
}
