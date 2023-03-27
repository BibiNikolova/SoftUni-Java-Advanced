package setsAndMaps;

import com.sun.source.doctree.SeeTree;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> parkingLot = new LinkedHashSet<>();

        while (!"END".equals(input)) {
            String action = input.split(", ")[0];
            String DKN = input.split(", ")[1];
            if ("IN".equals(action)) {
                parkingLot.add(DKN);
            } else {
                parkingLot.remove(DKN);
            }
            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String s : parkingLot) {
                System.out.println(s);
            }
        }
    }
}
