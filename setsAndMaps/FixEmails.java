package setsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> emailBook = new LinkedHashMap<>();

        while (!"stop".equals(input)) {
            String name = input;
            emailBook.put(name, null);
            input = scanner.nextLine();
            if (!input.endsWith(".uk")
                    && !input.endsWith(".us")
                    && !input.endsWith(".com")) {
                emailBook.put(name, input);
            }
            input = scanner.nextLine();
        }
        emailBook.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

    }
}
