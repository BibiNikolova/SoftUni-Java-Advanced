package functionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> collection = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(collection);

        int divisor = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> checkDivisor = e -> e % divisor != 0;

        collection.stream()
                .filter(checkDivisor)
                .forEach(n -> System.out.print(n + " "));
    }
}
