package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class FormulaOne {
    private static int row;
    private static int col;
    private static boolean finished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int numOfCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = getMatrix(scanner, size);

        for (int i = 0; i < numOfCommands; i++) {

            String command = scanner.nextLine();

            if ("up".equals(command)) {
                // row--;
                getMove(matrix, -1, 0);
            } else if ("down".equals(command)) {
                // row++;
                getMove(matrix, 1, 0);
            } else if ("left".equals(command)) {
                // coll--;
                getMove(matrix, 0, -1);
            } else if ("right".equals(command)) {
                // coll++;
                getMove(matrix, 0, 1);
            }

            if (finished) {
                break;
            }
        }
        if (!finished) {
            System.out.println("Oh no, the player got lost on the track!");
        } else {
            System.out.println("Well done, the player won first place!");
        }

        printMatrix(matrix);
    }

    private static void getMove(String[][] matrix, int rowMutator, int colMutator) {

        int newRow = setPoint(matrix, row, rowMutator);
        int newCol = setPoint(matrix, col, colMutator);

        String playerPoint = matrix[newRow][newCol];

        if (!matrix[row][col].equals("B")) {
            matrix[row][col] = ".";
        }

        if (playerPoint.equals("F")) {
            finished = true;

        } else if (playerPoint.equals("B")) {
            row = newRow;
            col = newCol;
            getMove(matrix, rowMutator, colMutator);
            return;
        } else if (playerPoint.equals("T")) {
            return;
        }

        matrix[newRow][newCol] = "P";
        row = newRow;
        col = newCol;
    }

    private static int setPoint(String[][] matrix, int i, int mutator) {
        int parameter = i + mutator;

        if (parameter < 0 || parameter >= matrix.length) {
            parameter = parameter < 0 ? matrix.length - 1 : 0;
        }
        return parameter;
    }

    private static String[][] getMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] currentRow = scanner.nextLine().split("");

            // find start Point
            if (Arrays.asList(currentRow).contains("P")) {
                row = i;
                col = Arrays.asList(currentRow).indexOf("P");
            }
            matrix[i] = currentRow;
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
}
