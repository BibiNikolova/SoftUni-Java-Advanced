package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split("\\s+");

        String[] input = scanner.nextLine().split("\\s+");

        int numsToOffer = Integer.parseInt(commands[0]);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numsToOffer; i++) {
            queue.offer(Integer.parseInt(input[i]));
        }

        int numsToPoll = Integer.parseInt(commands[1]);
        while (numsToPoll > 0) {
            queue.pop();

            numsToPoll--;
        }

        int isPresent = Integer.parseInt(commands[2]);
        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(isPresent)) {
            System.out.println("true");
        } else {
            int minValue = Collections.min(queue);
            System.out.println(minValue);
        }
    }
}

