package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = getMatrix(scanner, n);

        int primarySum = getPrimaryDiagonalSum(n, matrix);
        int secondarySum = getSecondDiagonalSum(n, matrix);

        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static int[][] getMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowOfMatrix;
        }
        return matrix;
    }

    private static int getSecondDiagonalSum(int n, int[][] matrix) {
        int sum = 0;
        for (int row = n; row > 0; row--) {
            for (int col = 0; col < n; col++) {
                if (row + col == n) {
                    sum += matrix[row - 1][col];
                }
            }
        }
        return sum;
    }

    private static int getPrimaryDiagonalSum(int n, int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col) {
                    sum += matrix[row][col] ;
                }
            }
        }
        return sum;
    }
}
