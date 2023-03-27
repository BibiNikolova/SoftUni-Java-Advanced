package functionalProgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int smallestNum = input.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();

        System.out.println(input.lastIndexOf(smallestNum));

//        Решение с Consumer:
//        Consumer<List<Integer>> minIndex = n -> {
//            int minNum = Integer.MAX_VALUE;
//            for (int number : n) {
//                if (number < minNum) {
//                    minNum = number;
//                }
//            }
//            System.out.println(n.lastIndexOf(minNum));
//        };
//        minIndex.accept(input);
    }
}
