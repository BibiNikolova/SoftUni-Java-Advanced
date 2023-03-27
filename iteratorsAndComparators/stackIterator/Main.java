package iteratorsAndComparators.stackIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StackIterator stack = null;
        while (!input.equals("END")) {
            if (input.contains("Push")) {
                String[] sub = input.substring(5).split(", ");
                stack = new StackIterator(sub);
//                for (String currentInt : sub) {
//                    stack.push(Integer.parseInt(currentInt));
//                }

            } else if (input.contains("Pop")) {
                if (!stack.hasNext()) {
                    break;
                }
                System.out.println(stack.pop());
            }
            input = scanner.nextLine();
        }
        System.out.println();
    }
}
