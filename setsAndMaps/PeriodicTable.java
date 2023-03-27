package setsAndMaps;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[]input = scanner.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(input));
            //Collections.addAll(chemicalElements, input);
        }
        chemicalElements.stream()
                .forEach(s -> System.out.print(s + " "));

    }
}
