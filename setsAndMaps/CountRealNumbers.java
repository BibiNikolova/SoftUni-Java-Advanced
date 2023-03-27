package setsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> occurances = new LinkedHashMap<>();

        for (double v : input) {
            if (occurances.containsKey(v)) {
                occurances.put(v, occurances.get(v) + 1);
            } else {
                occurances.put(v, 1);
            }
        }
        occurances.entrySet().stream()
                .forEach(e -> System.out.printf("%.1f -> %d%n", e.getKey(), e.getValue()));
    }
}
