package functionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> evenNums = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(Objects::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNums));
        List<String> sorted = evenNums.stream()
                .map(Integer::parseInt)
                .sorted()
                .map(o -> o.toString())
                .collect(Collectors.toList());
        System.out.println(String.join(", ", sorted));
    }
}
