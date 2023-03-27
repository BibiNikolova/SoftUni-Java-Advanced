package examPreparation.type01;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootbox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstLootbox::offer);

        ArrayDeque<Integer> secondLootbox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondLootbox::push);

        int claimedItems = 0;

        while (!firstLootbox.isEmpty() && !secondLootbox.isEmpty()) {
            int sum = firstLootbox.peek() + secondLootbox.peek();
            if (sum % 2 == 0) {
                claimedItems += sum;
                firstLootbox.poll();
            } else {
                int shuffle = secondLootbox.peekLast();
                firstLootbox.offer(shuffle);
            }
            secondLootbox.pop();
        }
        if (firstLootbox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (claimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + claimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + claimedItems);
        }
    }

}
