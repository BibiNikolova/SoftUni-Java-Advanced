package functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, Integer> count = e -> e.split(", ").length;

        Function<String, Integer> sum = str -> Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("Count = " + count.apply(input));
        System.out.println("Sum = " + sum.apply(input));


    }
}
