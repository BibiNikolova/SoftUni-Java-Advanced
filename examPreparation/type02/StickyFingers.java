package examPreparation.type02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {

    private static int robberRow;
    private static int robberCol;
    private static int totalRobbedMoney;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");

        char[][] matrix = new char[fieldSize][fieldSize];

        int counter = 0;

        for (int row = 0; row < fieldSize; row++) {
            List<Character> currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(e -> e.charAt(0))
                    .collect(Collectors.toList());

            for (int col = 0; col < currentRow.size(); col++) {
                if (currentRow.get(col) == 'D') {
                    robberRow = row;
                    robberCol = col;
                }
                matrix[row][col] = currentRow.get(col);
            }
        }

        for (int i = 0; i < directions.length; i++) {
            String command = directions[i];
            int nextRow = 0;
            int nextCol = 0;
            switch (command) {
                case "up":
                    nextRow = robberRow - 1;
                    nextCol = robberCol;
                    break;
                case "down":
                    nextRow = robberRow + 1;
                    nextCol = robberCol;
                    break;
                case "left":
                    nextRow = robberRow;
                    nextCol = robberCol - 1;
                    break;
                case "right":
                    nextRow = robberRow;
                    nextCol = robberCol + 1;
                    break;
            }

            if (!isValidIndex(matrix, nextRow, nextCol)) {
                System.out.println("You cannot leave the town, there is police outside!");
                counter++;
                continue;
            }

            if (matrix[nextRow][nextCol] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalRobbedMoney);
                matrix[nextRow][nextCol] = '#';
                matrix[robberRow][robberCol] = '+';
                break;
            } else if (matrix[nextRow][nextCol] == '$') {
                matrix[robberRow][robberCol] = '+';
                matrix[nextRow][nextCol] = 'D';
                robberRow = nextRow;
                robberCol = nextCol;
                totalRobbedMoney += nextRow * nextCol;
                System.out.printf("You successfully stole %d$.%n", nextRow * nextCol);
            } else if (matrix[nextRow][nextCol] == '+') {
                matrix[robberRow][robberCol] = '+';
                matrix[nextRow][nextCol] = 'D';
                robberRow = nextRow;
                robberCol = nextCol;
            }
            counter++;
        }
        if (counter == directions.length) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalRobbedMoney);
        }
        printMatrix(matrix);
    }

    private static boolean isValidIndex(char[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[nextRow].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.printf("%c ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
