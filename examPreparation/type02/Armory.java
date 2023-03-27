package examPreparation.type02;

import java.util.Scanner;

public class Armory {
    private static int officerRow;
    private static int officerCol;
    private static int sum;

    private static boolean isOutOfBound = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = getCharMatrix(scanner, size);

        String command = scanner.nextLine();

        while (sum < 65) {

            matrix[officerRow][officerCol] = '-';

            if ("up".equals(command)) {
                officerRow--;
            } else if ("down".equals(command)) {
                officerRow++;
            } else if ("left".equals(command)) {
                officerCol--;
            } else if ("right".equals(command)) {
                officerCol++;
            }

            move(matrix, officerRow, officerCol);

            if (isOutOfBound || sum >= 65) {
                break;
            }

            command = scanner.nextLine();
        }

        if (isOutOfBound) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", sum);

        printMatrix(matrix);
    }

    private static void move(char[][] matrix, int newRow, int newCol) {

        if (isOutOfBounds(matrix.length, newRow, newCol)) {
            isOutOfBound = true;
            return;
        }

        char currentPoint = matrix[newRow][newCol];

        matrix[newRow][newCol] = 'A';

        if (Character.isDigit(currentPoint)) {
            int digit = Character.getNumericValue(currentPoint);
            sum += digit;
        } else if (currentPoint == 'M') {
            matrix[newRow][newCol] = '-';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 'M' && (i != newRow || j != newCol)) {
                        matrix[i][j] = '-';//set searched point
                        officerRow = i;
                        officerCol = j;
                        return;
                    }
                }
            }
        }
    }


    //Char Matrix
    private static char[][] getCharMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();

            // find start Point
            for (int col = 0; col < currentRow.length; col++) {
                if (currentRow[col] == 'A') {
                    officerRow = row;
                    officerCol = col;
                }
                matrix[row] = currentRow;
            }
        }
        return matrix;
    }


    //print Char[][]
    private static void printMatrix(char[][] matrix) {
        for (char[] rows : matrix) {
            for (char row : rows) {
                System.out.print(row);
            }
            System.out.println();
        }
    }

    public static boolean isOutOfBounds(int size, int row, int col) {
        return row < 0 || row >= size || col < 0 || col >= size;
    }

}
