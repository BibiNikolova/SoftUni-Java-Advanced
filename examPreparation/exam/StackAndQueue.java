package examPreparation.exam;

import java.util.*;
import java.util.stream.Collectors;

public class StackAndQueue {

    private static int dose;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(queue::push);

        ArrayDeque<Integer> drinkStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(drinkStack::offer);

        while (!queue.isEmpty() && !drinkStack.isEmpty()) {

            int currentDose = queue.peek() * drinkStack.peek();

            if (dose + currentDose <= 300) {
                dose += currentDose;
                drinkStack.poll();
            } else if (dose + currentDose > 300) {
                dose -= 30;
                int currentDrink = drinkStack.peek();
                drinkStack.poll();
                drinkStack.offer(currentDrink);
            }
            queue.pop();
        }

        if (dose < 0) {
            dose = 0;
        }

        if (!drinkStack.isEmpty()) {
            System.out.print("Drinks left: ");
            printDeque(drinkStack);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", dose);
    }

    private static void printDeque(ArrayDeque<Integer> deque) {
        List<String> temp = deque.stream()
                .map(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(", ", temp));
    }

}
