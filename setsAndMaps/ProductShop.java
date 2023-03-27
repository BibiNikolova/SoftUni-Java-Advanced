package setsAndMaps;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> specification = new TreeMap<>();

        while (!"Revision".equals(input)) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            specification.putIfAbsent(shop, new LinkedHashMap<>());
            specification.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        specification.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + "->");
                    e.getValue().entrySet()
                            .forEach(v -> System.out.printf("Product: %s, Price: %.1f%n", v.getKey(), v.getValue()));
                });
    }
}
