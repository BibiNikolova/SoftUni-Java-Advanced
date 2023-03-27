package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class Bomb {
    private static int sapperRow;
    private static int sapperCol;
    private static int bombs;
    private static boolean ended = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        String[][] matrix = getMatrix(scanner, size);

        for (int i = 0; i < commands.length; i++) {

            if (commands[i].equals("up") && isValid(size, sapperRow - 1, sapperCol)) {
                sapperRow--;
                getMove(sapperRow, sapperCol, matrix);

            } else if (commands[i].equals("down") && isValid(size, sapperRow + 1, sapperCol)) {
                sapperRow++;
                getMove(sapperRow, sapperCol, matrix);

            } else if (commands[i].equals("left") && isValid(size, sapperRow, sapperCol - 1)) {
                sapperCol--;
                getMove(sapperRow, sapperCol, matrix);

            } else if (commands[i].equals("right") && isValid(size, sapperRow, sapperCol + 1)) {
                sapperCol++;
                getMove(sapperRow, sapperCol, matrix);
            }
            if (ended) {
                break;
            } else if (bombs == 0) {
                break;
            }
        }
        if (bombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if(ended) {
            System.out.println("END! " + bombs + " bombs left on the field");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)"
                    , bombs, sapperRow, sapperCol);
        }

    }
    //       printMatrix(matrix);


    private static String[][] getMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {

            String[] currentRow = scanner.nextLine().split("\\s+");

            if (Arrays.asList(currentRow).contains("B")) {
                bombs += Arrays.stream(currentRow).filter(c -> c.equals("B")).count();
            }
            // find start Point
            if (Arrays.asList(currentRow).contains("s")) {
                sapperRow = row;
                sapperCol = Arrays.asList(currentRow).indexOf("s");
            }
            matrix[row] = currentRow;
        }
        return matrix;
    }

    private static void getMove(int newRow, int newCol, String[][] matrix) {

        String sapperPoint = matrix[newRow][newCol];

        if (sapperPoint.equals("B")) {
            System.out.println("You found a bomb!");
            bombs--;
        } else if (sapperPoint.equals("e")) {
            ended = true;
        }
    }

    private static boolean isValid(int size, int row, int col) {
        return (row >= 0 && row < size
                && col >= 0 && col < size);
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

