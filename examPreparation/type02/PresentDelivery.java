package examPreparation.type02;

import java.util.Arrays;
import java.util.Scanner;

public class PresentDelivery {
    private static int santaRow;
    private static int santaCol;
    private static int countNiceKids;
    private static int niceKidsGifted;
    private static int givenGifts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presents = Integer.parseInt(scanner.nextLine());
        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[][] neighbourhood = getMatrix(scanner, matrixSize);

        String command = scanner.nextLine();

        while (!"Christmas morning".equals(command)) {

            neighbourhood[santaRow][santaCol] = "-";

            switch (command) {
                case "up":
                    if (santaRow - 1 >= 0) {
                        santaRow--;
                    }
                    break;
                case "down":
                    if (santaRow + 1 < matrixSize) {
                        santaRow++;
                    }
                    break;
                case "left":
                    if (santaCol - 1 >= 0) {
                        santaCol--;
                    }
                    break;
                case "right":
                    if (santaCol + 1 < matrixSize) {
                        santaCol++;
                    }
                    break;
            }

            getMove(neighbourhood, santaRow, santaCol);

            if (presents <= givenGifts) {
                break;
            }
            command = scanner.nextLine();

        }

        neighbourhood[santaRow][santaCol] = "S";

        if (presents <= givenGifts) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(neighbourhood);

        if (niceKidsGifted < countNiceKids) {
            System.out.println("No presents for " + (countNiceKids - niceKidsGifted) + " nice kid/s.");
        } else {
            System.out.println("Good job, Santa! " + countNiceKids + " happy nice kid/s.");
        }
    }

    private static String[][] getMatrix(Scanner scanner, int matrixSize) {
        String[][] neighbourhood = new String[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
//            int[] row = stream(scanner.nextLine().split(" "))
//                    .mapToInt(e -> e.charAt(0)).toArray();
            if (Arrays.asList(currentRow).contains("V")) {
                countNiceKids += Arrays.stream(currentRow).filter(c -> c.equals("V")).count();
            }
            if (Arrays.asList(currentRow).contains("S")) {
                santaRow = row;
                santaCol = Arrays.asList(currentRow).indexOf("S");
            }
            neighbourhood[row] = currentRow;
        }
        return neighbourhood;
    }

    private static void getMove(String[][] neighbourhood, int santaRow, int santaCol) {

        String santaPoint = neighbourhood[santaRow][santaCol];

        if (santaPoint.equals("V")) {
            niceKidsGifted++;
            givenGifts++;
        } else if (santaPoint.equals("C")) {
            if (neighbourhood[santaRow][santaCol - 1].equals("V")) {
                niceKidsGifted++;
                givenGifts++;
            } else if (neighbourhood[santaRow][santaCol - 1].equals("X")) {
                givenGifts++;
            }
            neighbourhood[santaRow][santaCol - 1] = "-";

            if (neighbourhood[santaRow][santaCol + 1].equals("V")) {
                niceKidsGifted++;
                givenGifts++;
            } else if (neighbourhood[santaRow][santaCol + 1].equals("X")) {
                givenGifts++;
            }
            neighbourhood[santaRow][santaCol + 1] = "-";

            if (neighbourhood[santaRow - 1][santaCol].equals("V")) {
                niceKidsGifted++;
                givenGifts++;
            } else if (neighbourhood[santaRow - 1][santaCol].equals("X")) {
                givenGifts++;
            }
            neighbourhood[santaRow - 1][santaCol] = "-";

            if (neighbourhood[santaRow + 1][santaCol].equals("V")) {
                niceKidsGifted++;
                givenGifts++;
            } else if (neighbourhood[santaRow + 1][santaCol].equals("X")) {
                givenGifts++;
            }
            neighbourhood[santaRow + 1][santaCol] = "-";
        }
    }


    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
