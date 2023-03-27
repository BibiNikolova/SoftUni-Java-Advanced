package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class ReVolt_AdvancedTechnics_81_100 {
    private static int playerRow;
    private static int playerCol;
    private static boolean finished = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = getMatrix(scanner, size);

        while (n-- > 0 && !finished) {

            String command = scanner.nextLine();

            if (command.equals("up")) {
                //row--;
                moveMatrix(matrix, -1, 0);
            } else if (command.equals("down")) {
                //row++;
                moveMatrix(matrix, 1, 0);
            } else if (command.equals("left")) {
                //col--
                moveMatrix(matrix, 0, -1);
            } else if (command.equals("right")) {
                //col++
                moveMatrix(matrix, 0, 1);
            }
        }
        System.out.println(finished ? "Player won!" : "Player lost!");

        printMatrix(matrix);

    }

    private static void moveMatrix(String[][] matrix, int rowMutator, int colMutator) {
        int newRow = playerRow + rowMutator;
        int newCol = playerCol + colMutator;

        if (newRow < 0 || newRow >= matrix.length) {
            newRow = newRow < 0 ? matrix.length - 1 : 0;
        } else if (newCol < 0 || newCol >= matrix.length) {
            newCol = newCol < 0 ? matrix.length - 1 : 0;
        }

        String currentPosition = matrix[newRow][newCol];

        if (currentPosition.equals("B")) {
            matrix[playerRow][playerCol] = "-";
            playerRow = newRow;
            playerCol = newCol;
            moveMatrix(matrix, rowMutator, colMutator);
        } else if (currentPosition.equals("T")) {
            return;
        } else if (currentPosition.equals("F")) {
            finished = true;
        }

        if (!(matrix[playerRow][playerCol].equals("B"))) {
            matrix[playerRow][playerCol] = "-";
        }
        matrix[newRow][newCol] = "f";
        playerRow = newRow;
        playerCol = newCol;
    }

    private static String[][] getMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];
        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("");
            if (Arrays.asList(currentRow).contains("f")) {
                playerRow = row;
                playerCol = Arrays.asList(currentRow).indexOf("f");
            }
            matrix[row] = currentRow;
        }
        return matrix;
    }


    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String num : arr) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
