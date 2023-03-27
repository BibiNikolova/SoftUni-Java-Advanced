package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class Bee {
    private static int beeRow;
    private static int beeCol;
    private static int pollinatedFlowers;
    private static boolean gotLost = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] field = getMatrix(scanner, size);

        String command = scanner.nextLine();

        while (!"End".equals(command)) {

            field[beeRow][beeCol] = ".";

            if ("up".equals(command)) {
                beeRow--;
                getMove(beeRow, beeCol, beeRow - 1, beeCol, field);
            } else if ("down".equals(command)) {
                beeRow++;
                getMove(beeRow, beeCol, beeRow + 1, beeCol, field);
            } else if ("left".equals(command)) {
                beeCol--;
                getMove(beeRow, beeCol, beeRow, beeCol - 1, field);
            } else if ("right".equals(command)) {
                beeCol++;
                getMove(beeRow, beeCol, beeRow, beeCol + 1, field);
            }
            if (gotLost) {
                break;
            }
            command = scanner.nextLine();
        }
        if (pollinatedFlowers >= 5) {
            System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");
        } else {
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (5 - pollinatedFlowers) + " flowers more");

        }
        printMatrix(field);

    }

    private static String[][] getMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("");

            // find start Point
            if (Arrays.asList(currentRow).contains("B")) {
                beeRow = row;
                beeCol = Arrays.asList(currentRow).indexOf("B");
            }
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

    private static boolean isValid(int size, int row, int col) {
        return (row >= 0 && row < size
                && col >= 0 && col < size);
    }

    public static boolean isOutOfBounds(int size, int row, int col) {
        return !isValid(size, row, col);
    }

    private static void getMove(int newRow, int newCol, int mutator, int colMutator, String[][] field) {
        if (isOutOfBounds(field.length, newRow, newCol)) {
            System.out.println("The bee got lost!");
            gotLost = true;
            return;
        }
        String beePoint = field[newRow][newCol];// get current String for checking downwards
        field[newRow][newCol] = "B";//set new Point
        if (beePoint.equals("f")) {
            pollinatedFlowers++;
        } else if (beePoint.equals("O")) {
            field[newRow][newCol] = ".";
            newRow = mutator;
            newCol = colMutator;
            getMove(newRow, newCol, mutator, colMutator, field);
            beeRow = newRow;
            beeCol = newCol;
        }
    }

}

