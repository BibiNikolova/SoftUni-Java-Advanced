package multidimentionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int cols = 0;

        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            int[] rowOfMatrix = stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowOfMatrix;
            cols = rowOfMatrix.length;
        }
        int[] token = stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numToReplace = matrix[token[0]][token[1]];
        int currentRow = 0;
        int currentCol = 0;
        List<Integer> digitForReplacement = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == numToReplace) {
                    currentRow = row;
                    currentCol = col;
                    int sum = 0;
                    int leftN = addL(matrix, currentRow, currentCol, numToReplace);
                    int upN = addUp(matrix, currentRow, currentCol, numToReplace);
                    int rightN = addR(matrix, currentRow, currentCol, cols, numToReplace);
                    int downN = addDown(matrix, currentRow, currentCol, n, numToReplace);
                    sum = leftN + rightN + upN + downN;
                    digitForReplacement.add(sum);
                }
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == numToReplace) {
                    matrix[row][col] = digitForReplacement.get(0);
                    digitForReplacement.remove(0);
                }
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int addDown(int[][] matrix, int currentRow, int currentCol, int n, int numToReplace) {
        if (currentRow + 1 > n - 1 || matrix[currentRow + 1][currentCol] == numToReplace) {
            return 0;
        }
        return matrix[currentRow + 1][currentCol];
    }

    private static int addR(int[][] matrix, int currentRow, int currentCol, int cols, int numToReplace) {
        if (currentCol + 1 > cols - 1 || matrix[currentRow][currentCol + 1] == numToReplace) {
            return 0;
        }
        return matrix[currentRow][currentCol + 1];
    }

    private static int addUp(int[][] matrix, int currentRow, int currentCol, int numToReplace) {
        if (currentRow - 1 < 0 || matrix[currentRow - 1][currentCol] == numToReplace) {
            return 0;
        }
        return matrix[currentRow - 1][currentCol];
    }

    private static int addL(int[][] matrix, int currentRow, int currentCol, int numToReplace) {
        if (currentCol - 1 < 0 || matrix[currentRow][currentCol - 1] == numToReplace) {
            return 0;
        }
        return matrix[currentRow][currentCol - 1];
    }
}
