package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese {
    private static int mouseRow;
    private static int mouseCol;
    private static int cheese;
    private static boolean lostMouse = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = getMatrix(scanner, size);

        String command = scanner.nextLine();



        while (!"end".equals(command)) {

            if ("up".equals(command)) {
                // row--;
                moveMouse(matrix, -1, 0);
            } else if ("down".equals(command)) {
                // row++;
                moveMouse(matrix, 1, 0);
            } else if ("left".equals(command)) {
                // coll--;
                moveMouse(matrix, 0, -1);
            } else if ("right".equals(command)) {
                // coll++;
                moveMouse(matrix, 0, 1);
            }

            if (lostMouse) {
                break;
            }

            command = scanner.nextLine();

        }

        if (lostMouse) {
            System.out.println("Where is the mouse?");
        }

        if (cheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        }

        printMatrix(matrix);
    }

    private static void moveMouse(String[][] matrix, int rowMutator, int colMutator) {

        matrix[mouseRow][mouseCol] = "-";

        int newRow = mouseRow + rowMutator;
        int newCol = mouseCol + colMutator;

        if (isOutOfMatrix(matrix.length, newRow, newCol)) {
            lostMouse = true;
            matrix[mouseRow][mouseCol] = "-";
            return;
        }

        String currentPoint = matrix[newRow][newCol];

        if (currentPoint.equals("c")) {
            cheese++;

        } else if (currentPoint.equals("B")) {
            mouseRow = newRow;
            mouseCol = newCol;
            moveMouse(matrix, rowMutator, colMutator);
            return;
        }

        matrix[mouseRow][mouseCol] = "-";
        matrix[newRow][newCol] = "M";
        mouseRow = newRow;
        mouseCol = newCol;
    }

    private static String[][] getMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("");

            // find start Point
            if (Arrays.asList(currentRow).contains("M")) {
                mouseRow = row;
                mouseCol = Arrays.asList(currentRow).indexOf("M");
            }
            matrix[row] = currentRow;
        }
        return matrix;
    }

    private static boolean isOutOfMatrix(int size, int row, int col) {
        return row < 0 || row >= size || col < 0 || col >= size;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String row : rows) {
                System.out.print(row);
            }
            System.out.println();
        }
    }
}
