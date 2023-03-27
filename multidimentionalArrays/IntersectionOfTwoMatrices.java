package multidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] rowOfMatrix = scanner.nextLine().split(" ");
            firstMatrix[row] = rowOfMatrix;
        }
        for (int row = 0; row < rows; row++) {
            String[] rowOfMatrix = scanner.nextLine().split(" ");
            secondMatrix[row] = rowOfMatrix;
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(firstMatrix[row][col].equals(secondMatrix[row][col])){
                    System.out.print(firstMatrix[row][col].charAt(0) + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
