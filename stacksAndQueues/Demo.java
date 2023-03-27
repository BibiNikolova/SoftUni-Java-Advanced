package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (!"Home".equals(input)) {
            if ("back".equals(input)) {
                if (browserHistory.size() > 1) {
                    forward.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if ("forward".equals(input)) {
                if (forward.size() > 0) {
                    System.out.println(forward.peek());
                    browserHistory.push(forward.pop());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                browserHistory.push(input);
                forward.clear();
                System.out.println(input);
            }
            input = scanner.nextLine();
        }
    }
}

