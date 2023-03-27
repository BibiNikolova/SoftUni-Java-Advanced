package setsAndMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeworkDimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstArr[] = new int[]{3, 12, 18, 34};
        int secondArr[] = new int[]{1, 4, 12, 15, 24, 34, 80};

        List<Integer> equalNums = new ArrayList<>();

        int i = 0, j = 0;

        while (i < firstArr.length && j < secondArr.length) {
            if (firstArr[i] == secondArr[j]) {
                equalNums.add(firstArr[i]);
                i++;
                j++;
            } else if (firstArr[i] < secondArr[j]) {
                i++;
            } else
                j++;
        }
    }
}

