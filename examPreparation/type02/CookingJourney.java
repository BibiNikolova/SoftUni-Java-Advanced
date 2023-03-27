package examPreparation.type02;

import java.util.Scanner;

public class CookingJourney {
    private static int rowToSell;
    private static int colToSell;
    private static int sum;
    private static boolean isOutOfBound = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = getMatrix(scanner, size);

        String command = scanner.nextLine();
        //while условие
        while (sum < 50) {

            matrix[rowToSell][colToSell] = '-';

            if ("up".equals(command)) {
                rowToSell--;
            } else if ("down".equals(command)) {
                rowToSell++;
            } else if ("left".equals(command)) {
                colToSell--;
            } else if ("right".equals(command)) {
                colToSell++;
            }
            getMove(rowToSell, colToSell, matrix);

            if (sum >= 50 || isOutOfBound) {
                break;
            }

            command = scanner.nextLine();
        }
        if (sum >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.println("Money: " + sum);

        printMatrix(matrix);

    }

    private static void getMove(int newRow, int newCol, char[][] field) {
        if (isOutOfBounds(field.length, newRow, newCol)) {
            isOutOfBound = true;
            return;
        }

        char sellingPoint = field[newRow][newCol];

        field[newRow][newCol] = 'S';

        if (Character.isDigit(sellingPoint)) {
            int digit = Character.getNumericValue(sellingPoint);
            sum += digit;
        } else if (sellingPoint == 'P') {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == 'P' && (i != newRow || j != newCol)) {
                        field[newRow][newCol] = '-';//set searched point
                        rowToSell = i;
                        colToSell = j;
                        return;
                    }
                }
            }
        }
    }

    private static char[][] getMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();

            // find start Point
            for (int col = 0; col < currentRow.length; col++) {
                if (currentRow[col] == 'S') {
                    rowToSell = row;
                    colToSell = col;
                }
                matrix[row] = currentRow;
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] rows : matrix) {
            for (char row : rows) {
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

}
