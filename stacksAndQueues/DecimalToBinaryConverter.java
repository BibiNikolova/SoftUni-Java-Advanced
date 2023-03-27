package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNum = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryNum = new ArrayDeque<>();

        if (decimalNum == 0) {
            System.out.println(0);
        } else {
            while (decimalNum != 0) {
                binaryNum.push(decimalNum % 2);
                decimalNum = decimalNum/2;
            }
        }
        for (Integer integer : binaryNum) {
            System.out.print(integer);
        }
    }
}
