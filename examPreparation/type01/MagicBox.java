package examPreparation.type01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    private static int sum;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueFirst = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(queueFirst::offer);

        ArrayDeque<Integer> stackSecond = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(stackSecond::push);

        while (!queueFirst.isEmpty() && !stackSecond.isEmpty()) {

            int currentSum = queueFirst.peek() + stackSecond.peek();

            if (currentSum % 2 == 0) {
                sum += currentSum;
                queueFirst.poll();
            } else {
                int temp = stackSecond.peek();
                queueFirst.offer(temp);
            }
            stackSecond.pop();
        }

        if (queueFirst.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (sum >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sum);
        } else {
            System.out.println("Poor prey... Value: " + sum);
        }

    }
}
