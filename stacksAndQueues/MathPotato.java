package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int circles = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, input);
        int prime = 1;

        while (kids.size() != 1) {
            for (int i = 1; i < circles; i++) {
                String current = kids.poll();
                kids.offer(current);
            }
            if (!isPrime(prime)) {
                System.out.println("Removed " + kids.peek());
                kids.pop();
            } else {
                System.out.println("Prime " + kids.peek());
            }
            prime += 1;
        }
        System.out.println("Last is " + kids.peek());
    }

    private static boolean isPrime(int prime) {
        if (prime <= 1) {
            return false;
        }
        for (int i = 2; i < prime; i++) {
            if ((prime % i) == 0)
                return false;
        }
        return true;
    }
}

