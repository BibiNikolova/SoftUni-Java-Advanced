package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class SumOfMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[][]matrix = new int[tokens[0]][tokens[1]];

        for (int row = 0; row < tokens[0]; row++) {
            int[]rowOfMatrix = stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowOfMatrix;
        }
        int sum = 0;
        for (int i = 0; i < tokens[0]; i++) {
            for (int j = 0; j < tokens[1]; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(tokens[0]);
        System.out.println(tokens[1]);
        System.out.println(sum);
    }
}
