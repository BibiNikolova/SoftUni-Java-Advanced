package stacksAndQueues;

import java.util.*;

public class RoboticsRefact {
    static int clock = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");
        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];  // Времената на всеки робот за обработка
        int[] remainingSeconds = new int[input.length];     // Оставащо време на всеки робот по време на работа

        fillRobots(processTime, robots, input);

        String[] startTime = scanner.nextLine().split(":");

        clock = Integer.parseInt(startTime[0]) * 3600 + Integer.parseInt(startTime[1]) * 60 + Integer.parseInt(startTime[2]);

        ArrayDeque<String> itemsInQueue = new ArrayDeque<>();

        String inputItem = scanner.nextLine();

        while (!inputItem.equals("End")) {
            itemsInQueue.offer(inputItem);
            inputItem = scanner.nextLine();
        }

        while (!itemsInQueue.isEmpty()) {

            String availableRobot = checkForAvailableRobot(remainingSeconds, robots, processTime, itemsInQueue);

            String currentProduct = itemsInQueue.poll();
            printRobotAction(availableRobot, currentProduct, clock);
        }
    }

    private static void fillRobots(int[] processTime, String[] robots, String[] input) {
        for (int i = 0; i < robots.length; i++) {
            robots[i] = input[i].split("-")[0];
        }
        for (int i = 0; i < processTime.length; i++) {
            processTime[i] = Integer.parseInt(input[i].split("-")[1]) - 1;
        }
    }

    private static String checkForAvailableRobot(int[] remainingSeconds, String[] robots, int[] processTime, ArrayDeque<String> itemsInQueue) {
        clock++;
        String availableRobot = null;
        int lastIndex = 0;
        for (int i = robots.length - 1; i >= 0; i--) {

            if (remainingSeconds[i] > 0) {
                remainingSeconds[i]--;
            } else {
                availableRobot = robots[i];
                lastIndex = i;
            }
        }

        if (availableRobot == null) {
            String currentItem = itemsInQueue.poll();
            itemsInQueue.offer(currentItem);
            return checkForAvailableRobot(remainingSeconds, robots, processTime, itemsInQueue);
        } else {
            remainingSeconds[lastIndex] = processTime[lastIndex];
            return availableRobot;
        }
    }

    private static void printRobotAction(String availableRobot, String product, int startTime) {
        long s = startTime % 60;
        long m = (startTime / 60) % 60;
        long h = (startTime / (60 * 60)) % 24;
        System.out.println(availableRobot + " - " + product + String.format(" [%02d:%02d:%02d] ", h, m, s));
    }
}
