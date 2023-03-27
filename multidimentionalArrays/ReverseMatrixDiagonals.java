package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();
        int r = Integer.parseInt(size.split(" ")[0]);
        int c = Integer.parseInt(size.split(" ")[1]);

        int currentNum = r + c;
        int[][] matrix = new int[r][c];

        for (int row = 0; row < r; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowOfMatrix;
        }

        while (currentNum > 0) {
            for (int row = r; row > 0; row--) {
                for (int col = c; col > 0; col--) {

                    if (row + col == currentNum) {
                        System.out.print(matrix[row - 1][col - 1] + " ");
                    }
                }
            }
            System.out.println();
            currentNum--;
        }

    }
}
