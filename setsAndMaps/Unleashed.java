package setsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> data = new LinkedHashMap<>();

        while (!"End".equals(input)) {
            Matcher matcher = Pattern.compile("^(?<singer>([a-zA-Z]+\\s){1,3})@(?<venue>([a-zA-Z]+\\s){1,3})(?<ticketsPrice>[0-9]+)\\s(?<ticketsCount>[0-9]+)$").matcher(input);
            if (isValidInput(input, matcher)) {

                String artist = matcher.group("singer");
                String city = matcher.group("venue");
                int totalMoney = getMoney(matcher);

                getData(data, artist, city, totalMoney);
            }
            input = scanner.nextLine();
        }
     /*   for (var entry : data.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream()
                    .sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()))
                    .forEach(v -> System.out.println("#  " + v.getKey().trim() + " -> " + v.getValue()));
        }*/

        data.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()))
                    .forEach(v -> System.out.println("#  " + v.getKey().trim() + " -> " + v.getValue()));
        });
    }

    private static int getMoney(Matcher matcher) {
        int totalMoney = 0;
        totalMoney = Integer.parseInt(matcher.group("ticketsPrice"))
                * Integer.parseInt(matcher.group("ticketsCount"));
        return totalMoney;
    }

    private static void getData(LinkedHashMap<String, LinkedHashMap<String, Integer>> data, String artist, String city, int totalMoney) {
        data.putIfAbsent(city, new LinkedHashMap<>());

        if (!data.get(city).containsKey(artist)) {
            data.get(city).put(artist, totalMoney);
        } else {
            int currentSum = data.get(city).get(artist);
            data.get(city).put(artist, currentSum + totalMoney);
        }
    }

    private static boolean isValidInput(String input, Matcher matcher) {
        return matcher.find();
    }
}
