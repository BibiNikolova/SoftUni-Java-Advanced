package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> brackets = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == '(') {
                brackets.push(index);
            } else if (input.charAt(index) == ')') {
                int startIndex = brackets.pop();
                String current = input.substring(startIndex, index + 1);
                System.out.println(current);

            }

        }
    }
}
