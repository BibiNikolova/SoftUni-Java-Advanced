package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int circles = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, input);

        while (kids.size() != 1) {
            for (int i = 1; i < circles; i++) {
                String current = kids.poll();
                kids.offer(current);
            }
            System.out.println("Removed " + kids.peek());
            kids.pop();
        }
        System.out.println("Last is " + kids.peek());
    }
}

