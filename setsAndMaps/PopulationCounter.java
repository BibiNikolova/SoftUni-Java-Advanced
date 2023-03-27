package setsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;


public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();

        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");

            getData(data, tokens);

            input = scanner.nextLine();
        }
        printData(data);
    }

    private static void printData(LinkedHashMap<String, LinkedHashMap<String, Long>> data) {
        data.entrySet().stream()
                .sorted((f, s) -> {
                    AtomicLong result1 = new AtomicLong();
                    f.getValue().forEach((key, value) -> result1.addAndGet(value));
                    AtomicLong result2 = new AtomicLong();
                    s.getValue().forEach((key, value) -> result2.addAndGet(value));
                    return Long.compare(result2.get(), result1.get());
                })
                .forEach(entry -> {
                    long sum = entry.getValue().values().stream()
                            .mapToLong(Long::longValue)
                            .sum();
                    System.out.println(entry.getKey() + " (total population: " + sum + ")");
                    entry.getValue().entrySet().stream()
                            .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                            .forEach(e -> {
                                System.out.println("=>" + e.getKey() + ": " + e.getValue());
                            });
                });

    }


    private static void getData(LinkedHashMap<String, LinkedHashMap<String, Long>> data, String[] tokens) {

        String country = tokens[1];
        String city = tokens[0];
        long population = Long.parseLong(tokens[2]);

        data.putIfAbsent(country, new LinkedHashMap<>());
        data.get(country).putIfAbsent(city, population);
    }
}
