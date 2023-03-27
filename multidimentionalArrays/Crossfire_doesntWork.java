package multidimentionalArrays;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Crossfire_doesntWork {
    private static int upRow;
    private static int downRow;
    private static int leftCol;
    private static int rightCol;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = getMatrix(dimensions);

        String input = scanner.nextLine();

        while (!"Nuke it from orbit".equals(input)) {
            int row = Integer.parseInt(input.split("\\s+")[0]);
            int col = Integer.parseInt(input.split("\\s+")[1]);
            int radius = Integer.parseInt(input.split("\\s+")[2]);

            cutMatrix(matrix, row, col, radius);

            input = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void cutMatrix(String[][] matrix, int row, int col, int radius) {

        upRow = row - radius;
        downRow = row + radius;
        leftCol = col - radius;
        rightCol = col + radius;

        for (int r = upRow; r < downRow; r++) {

           List<String> currentRow = stream(matrix[r]).collect(Collectors.toList());

            if (r == row) {
                currentRow.removeIf(n -> currentRow.indexOf(n) >= 0 && currentRow.indexOf(n) < matrix.length);
                for (int i = currentRow.size(); i < matrix.length; i++) {
                    currentRow.add(" ");
                }
            } else {
                if(isValid(matrix, col)){
                    currentRow.remove(col);
                    currentRow.add(" ");
                }
            }
            matrix[r] = currentRow.toArray(new String[matrix.length]);
        }
    }

    private static boolean isValid(String[][] matrix, int col) {
       return (col >= 0 && col < matrix.length);
    }

    private static String[][] getMatrix(int[] dimensions) {
        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        int count = 1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = String.valueOf(count);
                count++;
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String num : arr) {
                if (num == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
    }
}

