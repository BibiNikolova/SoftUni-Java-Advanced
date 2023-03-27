package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = getMatrix(dimensions, scanner);

        String[] input = scanner.nextLine().split(" ");

        while (!"END".equals(input[0])) {
            boolean isValid = isInputValid(input, dimensions);

            if (isValid) {
                swapMatrix(matrix, input);
                printSwappedMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine().split(" ");
        }
    }

    private static void printSwappedMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void swapMatrix(String[][] matrix, String[] input) {

        int fRow = Integer.parseInt(input[1]);
        int fCol = Integer.parseInt(input[2]);
        int sRow = Integer.parseInt(input[3]);
        int sCol = Integer.parseInt(input[4]);

        if (!matrix[fRow][fCol].equals(matrix[sRow][sCol])) {

            String temp = matrix[fRow][fCol];
            matrix[fRow][fCol] = matrix[sRow][sCol];
            matrix[sRow][sCol] = temp;
        }
    }

    private static boolean isInputValid(String[] input, int[] dimensions) {
        return input[0].equals("swap") && input.length == 5 && isValidIndex(dimensions, input);
    }

    private static boolean isValidIndex(int[] dimensions, String[] input) {
        int firstRow = Integer.parseInt(input[1]);
        int firstCol = Integer.parseInt(input[2]);
        int secondRow = Integer.parseInt(input[3]);
        int secondCol = Integer.parseInt(input[4]);

        return firstRow >= 0 && firstRow < dimensions[0] && secondRow >= 0 && secondRow < dimensions[0]
                && firstCol >= 0 && firstCol < dimensions[1] && secondCol >= 0 && secondCol < dimensions[1];
    }

    private static String[][] getMatrix(int[] dimensions, Scanner scanner) {
        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        for (int row = 0; row < dimensions[0]; row++) {
            String[] rowOfMatrix = scanner.nextLine().split("\\s+");
            matrix[row] = rowOfMatrix;
        }
        return matrix;
    }
}
