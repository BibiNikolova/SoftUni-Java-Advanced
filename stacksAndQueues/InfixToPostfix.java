package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        ArrayDeque<String> operationsQueue = new ArrayDeque<>();

        Pattern operators = Pattern.compile("[^\\w\\d]");

        for (String token : tokens) {

            Matcher operatorsMatcher = operators.matcher(token);
            if (operatorsMatcher.find()) {

                if (operatorsStack.isEmpty() || token.equals("(")) {
                    operatorsStack.push(token);

                } else {
                    String topOperator = operatorsStack.peek();
                    String compareResult = getPrecedenceCompare(topOperator, token);

                    if(compareResult.equals("Equal")){
                        equalOrSmaller(operatorsStack, operationsQueue, token, topOperator);
                    } else if(compareResult.equals("Greater")){
                        greaterOrLeftParenthesis(operatorsStack, token);
                    } else if(compareResult.equals("Right")){
                        rightParenthesis(operatorsStack, operationsQueue, token, topOperator);
                    }
                }
            } else {
                operationsQueue.offer(token);
            }
        }
        if(!operatorsStack.isEmpty()){
            for (String top : operatorsStack) {
                operationsQueue.offer(top);
            }
        }
        for (String q : operationsQueue) {
            System.out.print(q + " ");
        }
    }

    private static String getPrecedenceCompare(String topOperator, String token) {
        String compare = "";

        Matcher sumOrSubtract = Pattern.compile("(?<sumOrSubtract>[+|-])").matcher(token);
        Matcher sumOrSubOperator = Pattern.compile("(?<sumOrSubtract>[+|-])").matcher(topOperator);
        Matcher multiplyOrDivision = Pattern.compile("(?<multiply0rDivision>[*|\\/])").matcher(token);
        Matcher multiplyOrDivOperator = Pattern.compile("(?<multiply0rDivision>[*|\\/])").matcher(topOperator);
        Matcher rightParenthesis = Pattern.compile("(?<rightParenthesis>[)])").matcher(token);

        if (sumOrSubtract.find()) {

            if (sumOrSubOperator.find() || multiplyOrDivOperator.find()) {
                compare = "Equal";
            } else if (topOperator.equals("(")) {
                compare = "Greater";
            }
        } else if (multiplyOrDivision.find()) {

            if (sumOrSubOperator.find() || topOperator.equals("(")) {
                compare = "Greater";
            } else if(multiplyOrDivOperator.find()) {
                compare = "Equal";
            }
        } else if (rightParenthesis.find()) {
            compare = "Right";
        }
        return compare;
    }

    private static void rightParenthesis(ArrayDeque<String> operatorsStack, ArrayDeque<String> operationsQueue, String token, String topOperator) {
        while (!topOperator.equals("(")){
            operationsQueue.offer(topOperator);
            operatorsStack.pop();
            topOperator = operatorsStack.peek();
        }
        operatorsStack.pop();
    }

    private static void greaterOrLeftParenthesis(ArrayDeque<String> operatorsStack, String token) {
        operatorsStack.push(token);
    }

    private static void equalOrSmaller(ArrayDeque<String> operatorsStack, ArrayDeque<String> operationsQueue, String token, String topOperator) {
        operationsQueue.offer(topOperator);
        operatorsStack.pop();
        operatorsStack.push(token);
    }
}


