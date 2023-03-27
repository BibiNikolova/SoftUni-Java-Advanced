package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class ReVolt_MyWay {
    private static int playerRow;
    private static int playerCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        boolean finished = false;

        String[][] matrix = new String[size][size];
        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("");
            if (Arrays.asList(currentRow).contains("f")) {
                playerRow = row;
                playerCol = Arrays.asList(currentRow).indexOf("f");
            }
            matrix[row] = currentRow;
        }

        matrix[playerRow][playerCol] = "-";
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            int currentRow = playerRow;
            int currentCol = playerCol;
            getMove(size, command);
            String currentPosition = matrix[playerRow][playerCol];

            if (currentPosition.equals("B")) {
                getMove(size, command);
                if (matrix[playerRow][playerCol].equals("F")) {
                    finished = true;
                    break;
                }
            } else if (currentPosition.equals("T")) {
                playerRow = currentRow;
                playerCol = currentCol;
            } else if (currentPosition.equals("F")) {
                finished = true;
                break;
            }
        }
        matrix[playerRow][playerCol] = "f";
        if (finished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);

    }

    private static void getMove(int size, String command) {
        switch (command) {
            case "up":
                playerRow--;
                if (isValid(size, playerRow, playerCol)) {
                    playerRow = size - 1;
                }
                break;
            case "down":
                playerRow++;
                if (isValid(size, playerRow, playerCol)) {
                    playerRow = 0;
                }
                break;
            case "left":
                playerCol--;
                if (isValid(size, playerRow, playerCol)) {
                    playerCol = size - 1;
                }
                break;
            case "right":
                playerCol++;
                if (isValid(size, playerRow, playerCol)) {
                    playerCol = 0;
                }
                break;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String num : arr) {
                System.out.print(num);
            }
            System.out.println();
        }
    }

    private static boolean isValid(int size, int playerRow, int playerCol) {
        return (playerCol < 0 || playerCol >= size) || (playerRow < 0 || playerRow >= size);
    }
}

