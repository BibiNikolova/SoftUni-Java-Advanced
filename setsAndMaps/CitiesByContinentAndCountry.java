package setsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> worldMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            worldMap.putIfAbsent(continent, new LinkedHashMap<>());
            worldMap.get(continent).putIfAbsent(country, new ArrayList<>());
            worldMap.get(continent).get(country).add(city);
        }

        worldMap.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + ":");
            e.getValue().entrySet().stream().forEach(v -> {
                System.out.printf("  %s -> %s%n", v.getKey(), String.join(", ", v.getValue()));
            });
        });
    }
}
