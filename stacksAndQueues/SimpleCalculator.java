package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> calculationStack = new ArrayDeque<>();
        Collections.addAll(calculationStack, input);
        int result = 0;

        while (calculationStack.size() > 1) {
            int firstN = Integer.parseInt(calculationStack.pop());
            String sign = calculationStack.pop();
            int secondN = Integer.parseInt(calculationStack.pop());

            if ("+".equals(sign)){
                result = firstN + secondN;
            } else {
                result = firstN - secondN;
            }
            calculationStack.push(String.valueOf(result));
        }
        System.out.println(result);
    }
}
