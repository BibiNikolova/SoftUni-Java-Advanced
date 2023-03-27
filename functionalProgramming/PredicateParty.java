package functionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String[] commandParts = command.split("\\s+");
            String doubleOrRemove = commandParts[0];
            String filterType = commandParts[1];
            String parameter = commandParts[2];
            Predicate<String> filter = getPredicate(filterType, parameter);

            if (doubleOrRemove.equals("Double")) {

                List<String> addGuest = guests.stream().filter(filter).collect(Collectors.toList());
                guests.addAll(addGuest);

            } else {

                guests.removeIf(filter);
            }

            command = scanner.nextLine();
        }

        if (!guests.isEmpty()) {

            Collections.sort(guests);
            System.out.print(String.join(", ", guests));
            System.out.println(" are going to the party!");

        } else {

            System.out.println("Nobody is going to the party!");

        }
    }

    private static Predicate<String> getPredicate(String filterType, String parameter) {

        switch (filterType) {
            case "StartsWith":
                return s -> s.startsWith(parameter);
            case "EndsWith":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            default:
                throw  new IllegalArgumentException("Invalid command" + filterType);
        }
    }
}

