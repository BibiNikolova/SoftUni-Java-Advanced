package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = getRowOfMatrix(dimensions[0], dimensions[1]);

        printMatrix(matrix);
    }

    private static String[][] getRowOfMatrix(int row, int col) {
        String[][] matrix = new String[row][col];

        int current = 97;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                String index = "";
                index += (char) (i + 97);
                index += (char) (j + current);
                index += (char) (i + 97);
                matrix[i][j] = index;
            }
            current ++;
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
