package functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = num -> num.stream().map(n -> n + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = num -> num.stream().map(n -> n - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = num -> num.stream().map(n -> n * 2).collect(Collectors.toList());
        Consumer<List<Integer>> printer = num -> num.forEach(n -> System.out.print(n + " "));

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
//                  numbers = getAdded(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
//                  numbers = getMultiplied(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
//                  numbers = getSubtracted(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
//                  print(numbers);
                    break;
                default:
                    throw new IllegalArgumentException("unknown command" + command);
            }

            command = scanner.nextLine();
        }
    }

    private static void print(List<Integer> numbers) {
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static List<Integer> getSubtracted(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n -= 1)
                .collect(Collectors.toList());
    }

    private static List<Integer> getMultiplied(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

    }

    private static List<Integer> getAdded(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n += 1)
                .collect(Collectors.toList());
    }
}
