package examPreparation.type01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    private static int wreaths;
    private static int neededFlowers = 15;
    private static int storedFlowers;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(liliesStack::push);

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(rosesQueue::offer);

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {

            int currentLily = liliesStack.peek();
            int currentRose = rosesQueue.peek();
            int sum = currentLily + currentRose;

            if (sum <= neededFlowers) {
                if (sum == neededFlowers) {
                    wreaths++;
                } else {
                    storedFlowers += sum;
                }
                liliesStack.pop();
                rosesQueue.poll();
            } else {
                int tempLily = currentLily - 2;
                liliesStack.pop();
                liliesStack.push(tempLily);
            }
        }
        if (storedFlowers > 0) {
            int additionalWreaths = storedFlowers / neededFlowers;
            wreaths += additionalWreaths;
        }

        if (wreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5 - wreaths) + " wreaths more!");
        }

    }
}
