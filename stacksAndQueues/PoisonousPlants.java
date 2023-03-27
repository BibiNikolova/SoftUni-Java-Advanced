package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfFlowers = Integer.parseInt(scanner.nextLine());

        List<Integer> flowers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int days = 0;
        ArrayDeque<Integer> indexOfGMOQueue = new ArrayDeque<>();

        while (flowers.size() > 0) {

            for (int i = 0; i < flowers.size() - 1; i++) {
                if (flowers.get(i) < flowers.get(i + 1)) {
                    indexOfGMOQueue.offer(flowers.get(i + 1));
                }
            }
            if (indexOfGMOQueue.isEmpty()) {
                System.out.println(days);
                return;
            } else {
                while (indexOfGMOQueue.size() > 0) {
                    Integer peek = indexOfGMOQueue.peek();
                    flowers.remove(peek);
                    indexOfGMOQueue.poll();
                }
                days++;
            }
        }
    }
}
