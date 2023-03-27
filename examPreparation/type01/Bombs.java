package examPreparation.type01;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {

    private static int sum;
    private static boolean isPouchFilled;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effectQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(effectQueue::offer);

        ArrayDeque<Integer> casingStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(casingStack::push);

        Map<Integer, String> craftCombinations = getCombination();

        TreeMap<String, Integer> bombPouch = getPouch();

        while (!effectQueue.isEmpty() && !casingStack.isEmpty()) {
            sum = effectQueue.peek() + casingStack.peek();
            if (getCombination().containsKey(sum)) {
                String name = getCombination().get(sum);
                int count = bombPouch.get(name);
                bombPouch.put(name, count + 1);
                effectQueue.poll();
                casingStack.pop();
                isPouchFilled = (bombPouch.size() == 3) && (bombPouch.entrySet().stream().allMatch(b -> b.getValue() >= 3));
                if (isPouchFilled) {
                    break;
                }
            } else {
                int currentCasing = casingStack.peek() - 5;
                casingStack.pop();
                casingStack.push(currentCasing);
            }
        }
        if (isPouchFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effectQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            printDeque(effectQueue);
        }
        if (casingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            printDeque(casingStack);
        }
        printPouch(bombPouch);
    }

    private static TreeMap<String, Integer> getPouch() {
        TreeMap<String, Integer> neededCombination = new TreeMap<>();
        neededCombination.put("Datura Bombs", 0);
        neededCombination.put("Cherry Bombs", 0);
        neededCombination.put("Smoke Decoy Bombs", 0);
        return neededCombination;
    }

    private static void printPouch(Map<String, Integer> bombPouch) {
        bombPouch.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    private static Map<Integer, String> getCombination() {
        Map<Integer, String> neededCombination = new HashMap<>();
        neededCombination.put(40, "Datura Bombs");
        neededCombination.put(60, "Cherry Bombs");
        neededCombination.put(120, "Smoke Decoy Bombs");
        return neededCombination;
    }

    private static void printDeque(ArrayDeque<Integer> deque) {
        List<String> temp = deque.stream()
                .map(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(", ", temp));
    }

}
