package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> reversedNumbers = new ArrayDeque<>();
        Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .forEach(reversedNumbers::push);
        for (Integer number : reversedNumbers) {
            System.out.print(number + " ");
        }
    }
}
