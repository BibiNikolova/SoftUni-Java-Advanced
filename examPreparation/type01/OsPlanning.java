package examPreparation.type01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OsPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackTask = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stackTask::push);

        ArrayDeque<Integer> queueThread = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueThread::offer);

        int searchedTask = Integer.parseInt(scanner.nextLine());

        while (searchedTask != stackTask.peek()) {

            if (queueThread.peek() >= stackTask.peek()) {
                stackTask.pop();
            }
            queueThread.poll();
        }
        System.out.println("Thread with value " + queueThread.peek() + " killed task " + searchedTask);

        queueThread.forEach(t-> System.out.print(t + " "));
    }
}
