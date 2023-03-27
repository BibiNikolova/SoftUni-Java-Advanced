package examPreparation.type01;

import java.util.*;

public class FoodFinder {

    private static boolean hasVowel;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(vowels::offer);

        ArrayDeque<String> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(consonants::push);

        Map<String, String> words = getCombination();


        while (!consonants.isEmpty()) {
            String currentV = vowels.peek();
            count(words, currentV);
            String currentC = consonants.peek();
            count(words, currentC);
            vowels.poll();
            vowels.offer(currentV);
            consonants.pop();
        }

        List<String> found = getFound(words);
        System.out.println("Words found: " + found.size());
        for (String input : found) {
            System.out.println(input);
        }
    }

    private static List<String> getFound(Map<String, String> words) {
        List<String> found = new ArrayList<>();
        for (var entry : words.entrySet()) {
            if (entry.getValue().equals("")) {
                found.add(entry.getKey());
            }

        }
        return found;
    }


    private static void count(Map<String, String> words, String current) {
        for (var entry : words.entrySet()) {
            if (entry.getKey().contains(current)) {
                String cut = entry.getValue().replace(current, "");
                words.put(entry.getKey(), cut);
            }
        }

    }

    private static Map<String, String> getCombination() {
        Map<String, String> neededCombination = new LinkedHashMap<>();
        neededCombination.put("pear", "pear");
        neededCombination.put("flour", "flour");
        neededCombination.put("pork", "pork");
        neededCombination.put("olive", "olive");
        return neededCombination;
    }

}
