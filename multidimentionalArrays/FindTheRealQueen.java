package multidimentionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chesBoard = new String[8][8];
        List<String> rows = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String[] row = scanner.nextLine().split(" ");
            chesBoard[i] = row;
            rows.add(String.join("", row));
        }
        int currentRow = 0;
        int currentCol = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                String currentSymbol = chesBoard[row][col];
                if (currentSymbol.equals("q")) {
                    currentRow = row;
                    currentCol = col;
                    if (!isValidByRow(currentRow, currentCol, rows)) {
                        break;
                    } else {
                        if (!isValidByCol(chesBoard, currentRow, currentCol)) {
                            break;
                        }
                        if (!isValidByLeftDiagonal(chesBoard, currentRow, currentCol)) {
                            break;
                        }
                        if (!isValidByRightDiagonal(chesBoard, currentRow, currentCol)) {
                            break;
                        }
                    }
                    System.out.println(currentRow + " " + currentCol);
                    return;
                }
            }
        }
    }

    private static boolean isValidByRightDiagonal(String[][] chesBoard, int currentRow, int currentCol) {
        if (prevRowRightDiagonal(chesBoard, currentRow, currentCol)
                && nextRowRightDiagonal(chesBoard, currentRow, currentCol)) {
            return true;
        }
        return false;
    }

    private static boolean nextRowRightDiagonal(String[][] chesBoard, int currentRow, int currentCol) {
        int sum = currentCol + currentRow;
        boolean isQueen = true;
        if (currentRow == 7) {
            return true;
        } else if (currentCol == 0) {
            return true;
        } else if (sum <= 7) {
            for (int row = sum; row > currentRow; row--) {
                if (chesBoard[row][sum - row].equals("q")) {
                    isQueen = false;
                }
            }
        } else {
            for (int row = 7; row > currentRow; row--) {
                if (chesBoard[row][sum - row].equals("q")) {
                    isQueen = false;
                }
            }
        }
        return isQueen;
    }

    private static boolean prevRowRightDiagonal(String[][] chesBoard, int currentRow, int currentCol) {
        int sum = currentCol + currentRow;
        if (currentRow == 0) {
            return true;
        } else if (currentCol == 7) {
            return true;
        }
        for (int i = currentRow - 1; i >= 0; i--) {
            if (sum - i > 7) {
                if (chesBoard[i][sum - i].equals("q")) {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

    private static boolean isValidByLeftDiagonal(String[][] chesBoard, int currentRow, int currentCol) {
        if (beforeRowLeftDiagonal(chesBoard, currentRow, currentCol) && afterRowLeftDiagonal(chesBoard, currentRow, currentCol)) {
            return true;
        }
        return false;
    }

    private static boolean afterRowLeftDiagonal(String[][] chesBoard, int currentRow, int currentCol) {
        int subtract = currentCol - currentRow;
        if (currentRow == 7) {
            return true;
        } else if (currentCol == 7) {
            return true;
        }
        for (int row = currentRow + 1; row < 7; row++) {
            if (row + subtract < 8) {
                if (chesBoard[row][row + subtract].equals("q")) {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

    private static boolean beforeRowLeftDiagonal(String[][] chesBoard, int currentRow, int currentCol) {
        int subtract = currentCol - currentRow;
        if (currentRow == 0) {
            return true;
        } else if (currentCol == 0) {
            return true;
        }
        for (int i = currentRow - 1; i >= 0; i--) {
            if (i - Math.abs(subtract) >= 0) {
                if (chesBoard[i][i + subtract].equals("q")) {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

    private static boolean isValidByCol(String[][] chesBoard, int currentRow, int currentCol) {
        for (int i = currentRow; i < 8; i++) {
            String currentChar = chesBoard[i][currentCol];
            if (currentChar.equals("q") && i != currentRow) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidByRow(int currentRow, int currentCol, List<String> rows) {
        String exactRow = rows.get(currentRow);
        int startIndex = currentCol + 1;
        String sub = exactRow.substring(startIndex);
        if (sub.contains("q")) {
            return false;
        }
        return true;
    }
}


