package setsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstSet = getSet(tokens[0], scanner);

        Set<Integer> secondSet = getSet(tokens[1], scanner);

        firstSet.retainAll(secondSet);

        //Set<Integer> equalsNum = getEquals(firstSet, secondSet, longerSet);

        printSet(firstSet);
    }

    private static void printSet(Set<Integer> firstSet) {
        for (Integer n : firstSet) {
            System.out.print(n + " ");
        }
    }

    private static Set<Integer> getSet(int token, Scanner scanner) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < token; i++) {
            set.add(Integer.valueOf(scanner.nextLine()));
        }
        return set;
    }

    private static Set<Integer> getEquals(Set<Integer> firstSet, Set<Integer> secondSet, boolean longerSet) {
        Set<Integer> equalsNum = new LinkedHashSet<>();

        for (Integer num : firstSet) {
            if (secondSet.contains(num)) {
                equalsNum.add(num);
            }
        }
        return equalsNum;
    }
}
