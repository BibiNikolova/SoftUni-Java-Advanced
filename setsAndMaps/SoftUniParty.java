package setsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();;

        Set<String> guestList = new TreeSet<>();

        while (!"PARTY".equals(input)){
            guestList.add(input);
            input = scanner.nextLine();
        }
        while (!"END".equals(input)){
            guestList.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(guestList.size());
        for (String s : guestList) {
            System.out.println(s);
        }
    }
}
