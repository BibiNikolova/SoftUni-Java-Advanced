package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operations = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> historyStack = new ArrayDeque<>();

        for (int i = 0; i < operations; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    historyStack.push(text.toString());
                    String argument = command[1];
                    text.append(argument);
                    break;
                case "2":
                    historyStack.push(text.toString());
                    int erase = Integer.parseInt(command[1]);
                    text.delete(text.length() - erase, text.length());
                    break;
                case "3":
                    int charNum = Integer.parseInt(command[1]);
                    char returnedChar = text.toString().charAt(charNum - 1);
                    System.out.println(returnedChar);
                    break;
                case "4":
                    String undo = historyStack.peek();
                    text = new StringBuilder(undo);
                    historyStack.pop();

                    break;
            }
        }
    }
}
