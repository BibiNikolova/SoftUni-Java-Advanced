package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class Snake {
    private static int snakeRow;
    private static int snakeCol;
    private static int food;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] territory = getTerritory(scanner, size);


        while (food < 10) {

            String command = scanner.nextLine();

            if ("up".equals(command)) {
                if (isOutOfTerritory(size, snakeRow - 1, snakeCol)) {
                    break;
                } else {
                    if (!getMove(snakeRow, snakeCol, snakeRow - 1, snakeCol, territory)) {
                        snakeRow--;
                    }
                }
            } else if ("down".equals(command)) {

                if (isOutOfTerritory(size, snakeRow + 1, snakeCol)) {
                    break;
                } else {
                    if (!getMove(snakeRow, snakeCol, snakeRow + 1, snakeCol, territory)) {
                        snakeRow++;
                    }
                }
            } else if ("left".equals(command)) {

                if (isOutOfTerritory(size, snakeRow, snakeCol - 1)) {
                    break;
                } else {
                    if (!getMove(snakeRow, snakeCol, snakeRow, snakeCol - 1, territory)) {
                        snakeCol--;
                    }
                }
            } else if ("right".equals(command)) {

                if (isOutOfTerritory(size, snakeRow, snakeCol + 1)) {
                    break;
                } else {
                    if (!getMove(snakeRow, snakeCol, snakeRow, snakeCol + 1, territory)) {
                        snakeCol++;
                    }
                }
            }
        }
        if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            territory[snakeRow][snakeCol] = ".";
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + food);

        printTerritory(territory);

    }

    private static void printTerritory(String[][] territory) {
        for (String[] rows : territory) {
            for (String row : rows) {
                System.out.print(row);
            }
            System.out.println();
        }
    }

    private static boolean getMove(int oldRow, int oldCol
            , int newRow, int newCol, String[][] territory) {
        String snakePoint = territory[newRow][newCol];
        if (snakePoint.equals("-")) {
            territory[newRow][newCol] = "S";
        } else if (snakePoint.equals("*")) {
            territory[newRow][newCol] = "S";
            food++;
        } else if (snakePoint.equals("B")) {
            for (int i = 0; i < territory.length; i++) {
                for (int j = 0; j < territory[i].length; j++) {
                    if (territory[i][j].equals("B")
                            && (i != newRow || j != newCol)) {
                        territory[i][j] = "S";
                        territory[oldRow][oldCol] = ".";
                        territory[newRow][newCol] = ".";
                        snakeRow = i;
                        snakeCol = j;
                        return true;
                    }
                }

            }

        }
        territory[oldRow][oldCol] = ".";
        return false;
    }

    private static boolean isValid(int size, int snakeRow, int snakeCol) {
        return (snakeRow >= 0 && snakeRow < size
                && snakeCol >= 0 && snakeCol < size);
    }

    private static String[][] getTerritory(Scanner scanner, int size) {
        String[][] territory = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("");

            if (Arrays.asList(currentRow).contains("S")) {
                snakeRow = row;
                snakeCol = Arrays.asList(currentRow).indexOf("S");
            }
            territory[row] = currentRow;
        }
        return territory;
    }

    public static boolean isOutOfTerritory(int size, int snakeRow, int snakeCol) {
        return !isValid(size, snakeRow, snakeCol);
    }
}
