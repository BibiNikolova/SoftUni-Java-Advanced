package examPreparation.type01;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    private static int sum;
    private static boolean hasOneOfEach;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(liquids::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(ingredients::push);

        Map<Integer, String> cookCombinations = getCombination();

        TreeMap<String, Integer> baked = getBaked();


        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            sum = liquids.peek() + ingredients.peek();

            if (cookCombinations.containsKey(sum)) {
                String name = getCombination().get(sum);
                int count = baked.get(name);
                baked.put(name, count + 1);
                ingredients.pop();
                hasOneOfEach = baked.entrySet().stream().allMatch(b -> b.getValue() >= 1);

            } else {
                int temp = ingredients.peek() + 3;
                ingredients.pop();
                ingredients.push(temp);
            }
            liquids.poll();
        }
        if (hasOneOfEach) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            printDeque(liquids);
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            printDeque(ingredients);
        }

        printMap(baked);
    }

    private static Map<Integer, String> getCombination() {
        Map<Integer, String> neededCombination = new HashMap<>();
        neededCombination.put(25, "Bread");
        neededCombination.put(50, "Cake");
        neededCombination.put(75, "Pastry");
        neededCombination.put(100, "Fruit Pie");
        return neededCombination;
    }

    //      GET FINAL PRODUCT
    private static TreeMap<String, Integer> getBaked() {
        TreeMap<String, Integer> neededCombination = new TreeMap<>();
        neededCombination.put("Bread", 0);
        neededCombination.put("Cake", 0);
        neededCombination.put("Pastry", 0);
        neededCombination.put("Fruit Pie", 0);
        return neededCombination;
    }

    private static void printDeque(ArrayDeque<Integer> deque) {
        List<String> temp = deque.stream()
                .map(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(", ", temp));
    }

    private static void printMap(Map<String, Integer> done) {
        done.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

}
