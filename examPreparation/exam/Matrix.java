package examPreparation.exam;

import java.util.Scanner;

public class Matrix {
    private static int carRow = 0;
    private static int carCol = 0;
    private static int km;

    private static boolean finished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String carNum = scanner.nextLine();

        String[][] matrix = getMatrix(scanner, size);

        String command = scanner.nextLine();

        while (!"End".equals(command)) {

            if ("up".equals(command)) {
                // row--;
                move(matrix, -1, 0);
            } else if ("down".equals(command)) {
                // row++;
                move(matrix, 1, 0);
            } else if ("left".equals(command)) {
                // col--;
                move(matrix, 0, -1);
            } else if ("right".equals(command)) {
                // col++;
                move(matrix, 0, 1);
            }

            if (finished) {
                break;
            }

            command = scanner.nextLine();
        }

        if (finished) {
            System.out.println("Racing car " + carNum + " finished the stage!");
        } else {
            System.out.println("Racing car " + carNum + " DNF.");
        }

        System.out.println("Distance covered " + km + " km.");

        matrix[carRow][carCol] = "C";

        printMatrix(matrix);
    }

    private static void move(String[][] matrix, int rowMutator, int colMutator) {
        int newRow = carRow + rowMutator;
        int newCol = carCol + colMutator;

        if (isOutOfBounds(matrix.length, newRow, newCol)) {
            return;
        }

        String currentPoint = matrix[newRow][newCol];

        if (currentPoint.equals("F")) {
            finished = true;
        } else if (currentPoint.equals("T")) {
            km += 30;
            matrix[newRow][newCol] = ".";
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j].equals("T") && (i != newRow || j != newCol)) {
                        matrix[i][j] = ".";//set searched point
                        carRow = i;
                        carCol = j;
                        return;
                    }
                }
            }
        }
        km += 10;
        carRow = newRow;
        carCol = newCol;

    }

    private static String[][] getMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            matrix[row] = currentRow;
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String row : rows) {
                System.out.print(row);
            }
            System.out.println();
        }
    }

    public static boolean isOutOfBounds(int size, int row, int col) {
        return row < 0 || row >= size || col < 0 || col >= size;
    }

}
