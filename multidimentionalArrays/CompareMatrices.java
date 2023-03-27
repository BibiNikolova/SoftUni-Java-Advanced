package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class CompareMatrices {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] firstMatrix = getMatrix(dimensions,scanner);

        dimensions = stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] secondMatrix = getMatrix(dimensions,scanner);

        boolean areEqual = areArraysEqual(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static int[][] getMatrix(int[] dimensions, Scanner scanner) {
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        int rows = dimensions[0];
        int cols = dimensions[1];

        for (int row = 0; row < rows; row++) {
            int[] rowOfMatrix = stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowOfMatrix;
        }
        return matrix;
    }

    private static boolean areArraysEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int i = 0; i < firstMatrix.length; i++) {

            int[] firstArr = firstMatrix[i];
            int[] secondArr = secondMatrix[i];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int j = 0; j < firstArr.length; j++) {
                int firstNum = firstArr[j];
                int secondNum = secondArr[j];

                if (firstNum != secondNum) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

