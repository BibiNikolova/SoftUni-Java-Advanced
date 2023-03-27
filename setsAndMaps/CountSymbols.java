package setsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> charOccurances = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            charOccurances.putIfAbsent(input.charAt(i), 0);
            charOccurances.put(input.charAt(i), charOccurances.get(input.charAt(i)) + 1);
        }
        charOccurances.forEach((key, value) -> System.out.println(key + ": " + value + " time/s"));
    }
}
