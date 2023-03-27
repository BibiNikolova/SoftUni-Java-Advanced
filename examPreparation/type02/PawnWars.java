package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class PawnWars {
    private static int whiteRow;
    private static int whiteCol;
    private static int blackRow;
    private static int blackCol;
    private static int finalRow;
    private static int finalCol;

    private static boolean promotedQueen = false;
    private static String queen = "Black";
    private static boolean captured = false;
    private static String winner = "Black";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = getMatrix(scanner, 8);

        while (!promotedQueen) {

            move(matrix, -1, whiteRow, whiteCol, 0);
            if (promotedQueen) {
                queen = "White";
                break;
            }
            if (captured) {
                winner = "White";
                break;
            }
            whiteRow -= 1;
            matrix[whiteRow][whiteCol] = "w";

            move(matrix, 1, blackRow, blackCol, 7);
            if (promotedQueen) {
                break;
            }
            if (captured) {
                break;
            }
            blackRow += 1;
            matrix[blackRow][blackCol] = "b";
        }

        if (promotedQueen) {
            System.out.printf("Game over! %s pawn is promoted to a queen at %s.", queen, getField(matrix, finalRow, finalCol));

        } else {
            System.out.printf("Game over! %s capture on %s.", winner, getField(matrix, finalRow, finalCol));
        }


    }

    private static void move(String[][] matrix, int rowMutator, int row, int col, int queenRow) {
        matrix[row][col] = "-";

        int newRow = row + rowMutator;
        int newLeftCol = col - 1;
        int newRightCol = col + 1;

        if (newLeftCol >= 0) {
            if (!matrix[newRow][newLeftCol].equals("-")) {
                captured = true;
                finalRow = newRow;
                finalCol = newLeftCol;
                return;
            }
        }
        if (newRightCol < 7) {
            if (!matrix[newRow][newRightCol].equals("-")) {
                captured = true;
                finalRow = newRow;
                finalCol = newRightCol;
                return;
            }
        }

        if (newRow == queenRow) {
            promotedQueen = true;
            finalRow = newRow;
            finalCol = col;
        }

    }

    //String Matrix
    private static String[][] getMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("");

            // find start Point
            if (Arrays.asList(currentRow).contains("w")) {
                whiteRow = row;
                whiteCol = Arrays.asList(currentRow).indexOf("w");
            }
            if (Arrays.asList(currentRow).contains("b")) {
                blackRow = row;
                blackCol = Arrays.asList(currentRow).indexOf("b");
            }
            matrix[row] = currentRow;
        }
        return matrix;
    }

    //print String
    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String row : rows) {
                System.out.print(row);
            }
            System.out.println();
        }
    }

    private static String getField(String[][] matrix, int finalRow, int finalCol) {
        String field = "";
        char letter = (char) (97 + finalCol);
        field += letter;
        String num = String.valueOf(8 - finalRow);
        field += num;
        return field;
    }

}
