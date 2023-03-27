package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char parentheses = input.charAt(i);
            if (parentheses == '(' || parentheses == '[' || parentheses == '{') {
                openingBrackets.push(input.charAt(i));
            } else {
                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpeningBracket = openingBrackets.pop();
                if (parentheses == '}' && lastOpeningBracket != '{') {
                    isBalanced = false;
                    break;
                } else if (parentheses == ')' && lastOpeningBracket != '(') {
                    isBalanced = false;
                    break;
                } else if (parentheses == ']' && lastOpeningBracket != '[') {
                    isBalanced = false;
                    break;
                }
            }
        }

/*        if(isBalanced && openingBrackets.isEmpty()){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }*/

        String output = isBalanced && openingBrackets.isEmpty()
                ? "YES"
                : "NO";
        System.out.println(output);
    }
}

