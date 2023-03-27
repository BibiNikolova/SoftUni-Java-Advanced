package definingClasses.familyTree;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, Person> familyMembers = new HashMap<>();
        HashMap<String, Person> birthdays = new HashMap<>();

        String[] searched = extracted(input);

        input = scanner.nextLine();

        while (!"End".equals(input)) {
            if (input.contains("-")) {
                String[] data = input.split("-");
                Matcher firstMatcher = Pattern.compile("(?<first>[A-Z][a-z]+) (?<last>[A-Z][a-z]+)").matcher(data[0]);
                Matcher secondMatcher = Pattern.compile("(?<date>\\d+/\\d+/\\d{4})").matcher(data[1]);
                if (firstMatcher.matches()) {
                    String firstName = firstMatcher.group("first");
                    if (!familyMembers.containsKey(firstName)) {
                        Parent parent = getMatcherParent(firstMatcher);
                        if (secondMatcher.matches()) {
                            Child child = getMatcherChild(secondMatcher);
                        } else {
                            Child child = getArrChild(data[1]);
                        }
                    } else {

                    }

                } else {

                }


//            } else {
//                Person person = getPerson(input);
//                familyMembers.putIfAbsent(person.getFirstName(), person);
//                birthdays.putIfAbsent(person.getBirthday(), person);
//
//            }


                input = scanner.nextLine();
            }
        }


    }

    private static Child getMatcherChild(Matcher secondMatcher) {
        String firstName = secondMatcher.group("first");
        String lastName = secondMatcher.group("last");
        return new Child(firstName, lastName, null);
    }

    private static Parent getMatcherParent(Matcher firstMatcher) {
        String firstName = firstMatcher.group("first");
        String lastName = firstMatcher.group("last");
        return new Parent(firstName, lastName, null);
    }

    private static Child getArrChild(String data) {
        String fName = data.split("\\s+")[0];
        String lName = data.split("\\s+")[1];
        return new Child(fName, lName, null);
    }

    private static Person getPerson(String input) {
        String[] data = input.split("\\s+");
        String firstName = data[0];
        String lastName = data[1];
        String birthday = data[2];
        return new Person(firstName, lastName, birthday, null, null);
    }

    private static String[] extracted(String input) {
        return input.contains("-")
                ? input.split("-")
                : input.split("\\s+");
    }
}
