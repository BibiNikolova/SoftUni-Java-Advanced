package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class ThroneConquering {
    private static int rowOfParis;
    private static int colOfParis;
    private static int energy;
    private static boolean finished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        energy = power;

        String[][] field = getMatrix(scanner, size);

        field[rowOfParis][colOfParis] = "-";

        while (energy > 0) {

            String[] command = scanner.nextLine().split("\\s+");
            String direction = command[0];
            int spartanRow = Integer.parseInt(command[1]);
            int spartanCol = Integer.parseInt(command[2]);
            field[spartanRow][spartanCol] = "S";

            energy--;

            if ("up".equals(direction)) {
                // row--;
                if (isValid(size, rowOfParis - 1, colOfParis)) {

                    getMove(rowOfParis - 1, colOfParis
                            , field, spartanRow, spartanCol);
                    rowOfParis--;
                }
            } else if ("down".equals(direction)) {
                // row++;
                if (isValid(size, rowOfParis + 1, colOfParis)) {

                    getMove(rowOfParis + 1, colOfParis
                            , field, spartanRow, spartanCol);
                    rowOfParis++;
                }
            } else if ("left".equals(direction)) {
                // coll--;
                if (isValid(size, rowOfParis, colOfParis - 1)) {

                    getMove(rowOfParis, colOfParis - 1
                            , field, spartanRow, spartanCol);
                    colOfParis--;
                }
            } else if ("right".equals(direction)) {
                // coll++
                if (isValid(size, rowOfParis, colOfParis + 1)) {

                    getMove(rowOfParis, colOfParis + 1
                            , field, spartanRow, spartanCol);
                    colOfParis++;
                }
            }
            if (finished){
                break;
            }
        }

        if (energy <= 0) {
            field[rowOfParis][colOfParis] = "X";
            System.out.println("Paris died at " + rowOfParis + ";" + colOfParis + ".");
        } else {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        }
        printField(field);

    }

    private static String[][] getMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("");

            // find start Point
            if (Arrays.asList(currentRow).contains("P")) {
                rowOfParis = row;
                colOfParis = Arrays.asList(currentRow).indexOf("P");
            }
            matrix[row] = currentRow;
        }
        return matrix;
    }

    private static void printField(String[][] matrix) {
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

    private static void getMove(int newRow, int newCol, String[][] field, int spartanRow, int spartanCol) {

        if (field[newRow][newCol].equals("S")) {
            energy -= 2;
        } else if (field[newRow][newCol].equals("H")) {
            finished = true;
        }
        field[newRow][newCol] = "-";

    }
}
