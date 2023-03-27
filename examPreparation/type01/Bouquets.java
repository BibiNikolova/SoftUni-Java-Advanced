package examPreparation.type01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    private static int bouquets;
    private static int neededFlowers = 15;
    private static int storedFlowers;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tulipsStack::push);

        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(daffodilsQueue::offer);

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {

            int currentTulip = tulipsStack.peek();
            int currentDaffodils = daffodilsQueue.peek();
            int sum = currentTulip + currentDaffodils;

            if (sum <= neededFlowers) {
                if (sum == neededFlowers) {
                    bouquets++;
                } else {
                    storedFlowers += sum;
                }
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else {
                int tempLily = currentTulip - 2;
                tulipsStack.pop();
                tulipsStack.push(tempLily);
            }
        }
        if (storedFlowers > 0) {
            int additionalWreaths = storedFlowers / neededFlowers;
            bouquets += additionalWreaths;
        }

        if (bouquets >= 5) {
            System.out.println("You made it! You go to the competition with " + bouquets + " bouquets!");
        } else {
            System.out.println("You failed... You need more " + (5 - bouquets) + " bouquets.");
        }

    }
}
