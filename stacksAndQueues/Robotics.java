package stacksAndQueues;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robots = scanner.nextLine().split(";");

        String[] startingTime = scanner.nextLine().split(":");
        int lineSpeed = 1;
        int h = Integer.parseInt(startingTime[0]);
        int m = Integer.parseInt(startingTime[1]);
        int s = Integer.parseInt(startingTime[2]);

        int start = h * 3600 + m * 60 + s + lineSpeed;

        List<Robot> robotsCapacity = new ArrayList<>();
        for (String r : robots) {
            String name = r.split("-")[0];
            int capacity = Integer.parseInt(r.split("-")[1]);
            Robot robot = new Robot(name, capacity, start);
            robotsCapacity.add(robot);
        }

        String product = scanner.nextLine();

        ArrayDeque<String> productsInQueue = new ArrayDeque<>();

        while (!"End".equals(product)) {
            tryToProduce(start, robotsCapacity, product, productsInQueue);
            product = scanner.nextLine();
            start++;
        }

        while (!productsInQueue.isEmpty()) {
            product = productsInQueue.peek();
            tryToProduce(start, robotsCapacity, product, productsInQueue);
            productsInQueue.poll();
            start++;
        }
    }

    private static void tryToProduce(int start, List<Robot> robotsCapacity, String product, ArrayDeque<String> productsInQueue) {
        for (int i = 0; i < robotsCapacity.size(); i++) {
            Robot currentRobot = robotsCapacity.get(i);
            if (currentRobot.getReadyToStartAgain() <= start) {
                int index = i;
                System.out.println(currentRobot.getName() + " - " + product + " [" + printStart(start) + "]");
                int readyToStartAgain = robotsCapacity.get(index).getCapacity() + start;
                currentRobot.setReadyToStartAgain(readyToStartAgain);//часът, когато ще е готов произвежданият продукт
                return;
            }
        }
        productsInQueue.offer(product);
    }

    private static String printStart(int start) {
        String[] print = new String[3];
        int h = start / 3600;
        int temp = start % 3600;
        int m = temp / 60;
        int s = temp % 60;

        if (h == 24) {
            h = 0;
        }
        print[0] = String.format(("%02d"), h);
        print[1] = String.format(("%02d"), m);
        print[2] = String.format(("%02d"), s);

        return String.join(":", print);
    }

    public static class Robot {
        private final String name;
        private final int capacity;
        private int readyToStartAgain;

        public Robot(String name, int capacity, int readyToStartAgain) {
            this.name = name;
            this.capacity = capacity;
            this.readyToStartAgain = readyToStartAgain;
        }

        public String getName() {
            return this.name;
        }

        public int getCapacity() {
            return this.capacity;
        }

        public int getReadyToStartAgain() {
            return this.readyToStartAgain;
        }

        public void setReadyToStartAgain(int readyToStartAgain) {
            this.readyToStartAgain = readyToStartAgain;
        }
    }

}
