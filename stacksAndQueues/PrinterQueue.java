package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!"print".equals(input)){
            if("cancel".equals(input)){
                if(printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.peek());
                    printerQueue.poll();
                }
            } else {
                printerQueue.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String s : printerQueue) {
            System.out.println(s);
        }
    }
}
