package multidimentionalArrays;

        import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int dimensions = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[dimensions][dimensions];

        switch (pattern) {
            case "A":
                matrix = getMatrixA(dimensions);
                break;
            case "B":
                matrix = getMatrixB(dimensions);
                break;
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getMatrixA(int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];
        int currentNum = 1;

        for (int col = 0; col < dimensions; col++) {
            for (int row = 0; row < dimensions; row++) {
                matrix[row][col] = currentNum;
                currentNum++;
            }
        }
        return matrix;
    }

    private static int[][] getMatrixB(int dimensions) {
        int[][] matrix = new int[dimensions][dimensions];
        int currentNum = 0;

        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                if (col == 0) {
                    currentNum = row + 1;
                } else if (col % 2 == 0) {
                    currentNum = dimensions * col + row + 1;
                } else {
                    currentNum = dimensions * (col + 1) - row;
                }
                matrix[row][col] = currentNum;
            }
            currentNum = 0;
        }
        return matrix;
    }
}
