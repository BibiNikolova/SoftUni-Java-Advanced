package setsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];
            phonebook.put(name, phoneNumber);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")){
            System.out.println(phonebook.containsKey(input)
                    ? input +  " -> " + phonebook.get(input)
                    : "Contact " + input + " does not exist.");
            input = scanner.nextLine();
        }

    }
}
