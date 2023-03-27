package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class Python {
    private static int pythonRow;
    private static int pythonCol;
    private static int eatenFood = 1;
    private static int food;
    private static boolean finished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        String[][] matrix = getMatrix(scanner, size);

        for (String command : commands) {
            if ("up".equals(command)) {
                // row--;
                getMove(matrix, pythonRow - 1, pythonCol);
            } else if ("down".equals(command)) {
                // row++;
                getMove(matrix, pythonRow + 1, pythonCol);
            } else if ("left".equals(command)) {
                // coll--;
                getMove(matrix, pythonRow, pythonCol - 1);
            } else if ("right".equals(command)) {
                // coll++;
                getMove(matrix, pythonRow, pythonCol + 1);
            }
            if (finished) {
                break;
            }
            if(food == (eatenFood - 1)){
                break;
            }
        }
        if (finished) {
            System.out.println("You lose! Killed by an enemy!");
            return;
        }
        System.out.println(food == (eatenFood - 1) ? "You win! Final python length is " + eatenFood
                : "You lose! There is still " + (food - (eatenFood - 1)) + " food to be eaten.");
        
    }

    private static void getMove(String[][] matrix, int nextRow, int nextCol) {

        if (nextRow < 0 || nextRow >= matrix.length) {
            nextRow = nextRow < 0 ? matrix.length - 1 : 0;
        } else if (nextCol < 0 || nextCol >= matrix.length) {
            nextCol = nextCol < 0 ? matrix.length - 1 : 0;
        }

        String currentPoint = matrix[nextRow][nextCol];

        if (currentPoint.equals("e")) {
            finished = true;
            return;
        } else if (currentPoint.equals("f")) {
            eatenFood++;
        }

        pythonRow = nextRow;
        pythonCol = nextCol;

    }

    private static String[][] getMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split(" ");

            if (Arrays.asList(currentRow).contains("f")) {
                food += Arrays.stream(currentRow).filter(c -> c.equals("f")).count();
            }
            // find start Point
            if (Arrays.asList(currentRow).contains("s")) {
                pythonRow = row;
                pythonCol = Arrays.asList(currentRow).indexOf("s");
            }
            matrix[row] = currentRow;
        }
        return matrix;
    }

}
