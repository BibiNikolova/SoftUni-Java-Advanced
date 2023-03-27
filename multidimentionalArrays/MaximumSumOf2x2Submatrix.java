package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = tokens[0];
        int cols = tokens[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] maxMatrix = new int[2][2];

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {

                int sum = matrix[i][j] + matrix[i][j + 1]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (sum > maxSum) {
                    maxSum = sum;

                    maxMatrix[0][0] = matrix[i][j];
                    maxMatrix[0][1] = matrix[i][j + 1];
                    maxMatrix[1][0] = matrix[i + 1][j];
                    maxMatrix[1][1] = matrix[i + 1][j + 1];

                }
            }
        }
        for (int[] arr : maxMatrix) {
            for(int n : arr){
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
