package setsAndMaps;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> junk = new TreeMap<>();
        Map<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        int[] collectedValue = new int[3];
        boolean itemObtained = false;
        while (!itemObtained) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String key = tokens[i + 1].toLowerCase();
                if (materials.containsKey(key)) {
                    int value = materials.get(key) + quantity;
                    materials.put(key, value);

                    if (key.equals("shards")) {
                        collectedValue[0] += quantity;
                        itemObtained = collectedValue[0] >= 250;
                    } else if (key.equals("fragments")) {
                        collectedValue[1] += quantity;
                        itemObtained = collectedValue[1] >= 250;
                    } else if (key.equals("motes")) {
                        collectedValue[2] += quantity;
                        itemObtained = collectedValue[2] >= 250;
                    }
                    if (itemObtained) {
                        break;
                    }
                } else {
                    if (!junk.containsKey(key)) {
                        junk.put(key, 0);
                    }
                    junk.put(key, junk.get(key) + quantity);
                }
            }
        }

        String itemName = "";

        if (collectedValue[0] >= 250) {
            materials.put("shards", materials.get("shards") - 250);
            itemName = "Shadowmourne";
        } else if (collectedValue[1] >= 250) {
            materials.put("fragments", materials.get("fragments") - 250);
            itemName = "Valanyr";
        } else {
            materials.put("motes", materials.get("motes") - 250);
            itemName = "Dragonwrath";
        }

        System.out.printf("%s obtained!%n", itemName);

        materials.entrySet().stream()
                .sorted((f, s) -> {
                    int result = s.getValue() - f.getValue();
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));


        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

