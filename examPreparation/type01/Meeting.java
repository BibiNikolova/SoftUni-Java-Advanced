package examPreparation.type01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(maleStack::push);

        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femaleQueue::offer);


        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int currentFemale = femaleQueue.peek();
            int currentMale = maleStack.peek();

            if (currentMale <= 0) {
                maleStack.pop();
            } else if (currentFemale <= 0) {
                femaleQueue.poll();
            } else if (currentFemale % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
            } else if (currentMale % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
            } else if (currentMale == currentFemale) {
                count++;
                maleStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                int temp = currentMale - 2;
                maleStack.pop();
                maleStack.push(temp);
            }

        }
        System.out.println("Matches: " + count);

        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            printDeque(maleStack);
        }
        if (femaleQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            printDeque(femaleQueue);
        }

    }

    private static void printDeque(ArrayDeque<Integer> deque) {
        List<String> temp = deque.stream()
                .map(String::valueOf).collect(Collectors.toList());
        System.out.print(String.join(", ", temp));
        System.out.println();
    }
}
