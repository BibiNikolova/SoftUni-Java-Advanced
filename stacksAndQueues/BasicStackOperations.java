package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split("\\s+");

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numsToPush = Integer.parseInt(commands[0]);
        for (int i = 0; i < numsToPush; i++) {
            stack.push(Integer.parseInt(input[i]));
        }

        int numsToPop = Integer.parseInt(commands[1]);
        while (numsToPop > 0) {
            stack.pop();
            numsToPop--;
        }

        int isPresent = Integer.parseInt(commands[2]);

        if(stack.isEmpty()){
            System.out.println("0");
        } else if(stack.contains(isPresent)){
            System.out.println("true");
        } else {
            int minValue = Collections.min(stack);
            System.out.println(minValue);
        }
    }
}
