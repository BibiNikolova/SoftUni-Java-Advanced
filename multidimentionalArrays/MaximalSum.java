package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = tokens[0];
        int cols = tokens[1];

        int[][] matrix = getMatrix(scanner, rows, cols);

        int[][] maxMatrix = new int[3][3];

        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {

                int sum = matrix[i - 1][j - 1] + matrix[i - 1][j] + matrix[i - 1][j + 1]
                        + matrix[i][j - 1] + matrix[i][j] + matrix[i][j + 1]
                        + matrix[i + 1][j - 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (sum > maxSum) {
                    maxSum = sum;

                    maxMatrix[0][0] = matrix[i - 1][j - 1];
                    maxMatrix[0][1] = matrix[i - 1][j];
                    maxMatrix[0][2] = matrix[i - 1][j + 1];
                    maxMatrix[1][0] = matrix[i][j - 1];
                    maxMatrix[1][1] = matrix[i][j];
                    maxMatrix[1][2] = matrix[i][j + 1];
                    maxMatrix[2][0] = matrix[i + 1][j - 1];
                    maxMatrix[2][1] = matrix[i + 1][j];
                    maxMatrix[2][2] = matrix[i + 1][j + 1];
                }
            }
        }
        printResult(maxMatrix, maxSum);
    }

    private static void printResult(int[][] maxMatrix, int maxSum) {
        System.out.println("Sum = " + maxSum);

        for (int[] arr : maxMatrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}

