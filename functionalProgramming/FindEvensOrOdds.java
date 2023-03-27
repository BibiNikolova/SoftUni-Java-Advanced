package functionalProgramming;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String condition = scanner.nextLine();

        printNumIn(range[0], range[1],
                condition.equals("even")
                        ? n -> n % 2 == 0
                        : n -> n % 2 != 0);
    }

    private static void printNumIn(int start, int end, Predicate<Integer> predicate) {
        System.out.println(IntStream.rangeClosed(start, end)
                .boxed()
                .filter(predicate)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
