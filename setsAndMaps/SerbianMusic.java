package setsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianMusic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> data = new LinkedHashMap<>();

        while (!"End".equals(input)) {

            if (isValidInput(input)) {
                String[] tokens = input.split("@");

                String artist = tokens[0].trim();
                String city = getCity(tokens);
                int totalMoney = getMoney(tokens);

                getData(data, artist, city, totalMoney);
            }
            input = scanner.nextLine();
        }

        for (var entry : data.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream()
                    .sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()))
                    .forEach(v -> System.out.println("#  " + v.getKey().trim() + " -> " + v.getValue()));
        }
     /*   data.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()))
                    .forEach(v -> System.out.println("#  " + v.getKey().trim() + " -> " + v.getValue()));
        });*/
    }

    private static int getMoney(String[] tokens) {
        int totalMoney = 0;
        String[] cityTokens = tokens[1].split("\\s+");
        totalMoney = Integer.parseInt(cityTokens[cityTokens.length - 1])
                * Integer.parseInt(cityTokens[cityTokens.length - 2]);

        return totalMoney;
    }

    private static void getData(LinkedHashMap<String, LinkedHashMap<String, Integer>> data, String
            artist, String city, int totalMoney) {

        data.putIfAbsent(city, new LinkedHashMap<>());

        if (!data.get(city).containsKey(artist)) {
            data.get(city).put(artist, totalMoney);
        } else {
            int currentSum = data.get(city).get(artist);
            data.get(city).put(artist, currentSum + totalMoney);
        }
    }

    private static String getCity(String[] tokens) {
        String[] cityTokens = tokens[1].split("\\s+");
        StringBuilder city = new StringBuilder();
        for (int i = 0; i < cityTokens.length - 2; i++) {
            city.append(cityTokens[i]);
            city.append(" ");
        }
        return city.toString().trim();
    }

    private static boolean isValidInput(String input) {
        Matcher matcher = Pattern.compile("^(?<singer>([a-zA-Z]+\\s){1,3})@(?<venue>([a-zA-Z]+\\s){1,3})(?<ticketsPrice>[0-9]+)\\s(?<ticketsCount>[0-9]+)$").matcher(input);
        return matcher.find();
    }
}
