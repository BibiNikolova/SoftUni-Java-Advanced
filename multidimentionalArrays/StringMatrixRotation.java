package multidimentionalArrays;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("[(|)]");

        String input = scanner.nextLine();

        ArrayDeque<String[]> rows = new ArrayDeque<>();

        int maxLength = Integer.MIN_VALUE;
        int countOfInputs = 0;

        while (!"END".equals(input)) {
            String[] words = input.split("");
            rows.offer(words);
            if (words.length > maxLength) {
                maxLength = words.length;
            }
            countOfInputs++;
            input = scanner.nextLine();
        }
        int token = Integer.parseInt(command[1]);
        switch (convertIntoDegrees(token)) {
            case (0):
                String[][] matrix = new String[countOfInputs][maxLength];

                for (int r = 0; r < matrix.length; r++) {
                    String[] currentRow = rows.poll();
                    matrix[r] = currentRow;
                }
                printMatrix(matrix);
                break;
            case (90):
                matrix = new String[maxLength][countOfInputs];

                while (countOfInputs > 0 && !rows.isEmpty()) {
                    String[] currentRow = rows.poll();
                    for (int r = 0; r < currentRow.length; r++) {
                        String curr = currentRow[r];
                        matrix[r][countOfInputs - 1] = curr;
                    }
                    countOfInputs--;
                }
                printMatrix(matrix);
                break;
            case (180):
                matrix = new String[countOfInputs][maxLength];

                while (countOfInputs > 0 && !rows.isEmpty()) {
                    String[] currentRow = rows.poll();
                    for (int r = 0; r < currentRow.length; r++) {
                        String curr = currentRow[r];
                        matrix[countOfInputs - 1][maxLength - 1 - r] = curr;
                    }
                    countOfInputs--;
                }
                printMatrix(matrix);
                break;
            case (270):
                matrix = new String[maxLength][countOfInputs];
                int col = 0;
                while (col < countOfInputs && !rows.isEmpty()) {
                    String[] currentRow = rows.poll();
                    for (int r = 0; r < currentRow.length; r++) {
                        String curr = currentRow[r];
                        matrix[maxLength - 1 - r][col] = curr;
                    }
                    col++;
                }
                printMatrix(matrix);
                break;
        }
    }

    private static int convertIntoDegrees(int token) {
        return token >= 360 ? token % 360 : token;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String num : arr) {
                System.out.print(num == (null) ? " " : num);
            }
            System.out.println();
        }
    }
}
