package definingClasses.google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Man> men = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String id = tokens[2];
            String parameter = tokens[3];
            men.putIfAbsent(name, new Man(name, null, null, null, null, null));

            switch (tokens[1]) {
                case "company":
                    Company company = getCompany(tokens);
                    men.get(name).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = getPokemon(id, parameter);
                    men.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    Parent parent = getParent(id, parameter);
                    men.get(name).getParents().add(parent);
                    break;
                case "children":
                    Child child = getChild(id, parameter);
                    men.get(name).getChildren().add(child);
                    break;
                case "car":
                    Automobile auto = getAutomobile(tokens);
                    men.get(name).setAuto(auto);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid characteristic" + tokens[0]);
            }
            input = scanner.nextLine();
        }

        String person = scanner.nextLine();
        print(men, person);

    }

    private static void print(LinkedHashMap<String, Man> men, String person) {

        System.out.println(person);
        System.out.println("Company:");
        if (men.get(person).getCompany() != null) {
            System.out.println(men.get(person).getCompany());
        }
        System.out.println("Car:");
        if (men.get(person).getAuto() != null) {
            System.out.println(men.get(person).getAuto().toString());
        }
        System.out.println("Pokemon:");
        if (!men.get(person).getPokemons().isEmpty()) {
            men.get(person).getPokemons().forEach(System.out::print);
        }
        System.out.println("Parents:");
        if (!men.get(person).getParents().isEmpty()) {
            men.get(person).getParents().forEach(System.out::print);
        }
        System.out.println("Children:");
        if (!men.get(person).getChildren().isEmpty()) {
            men.get(person).getChildren().forEach(System.out::print);
        }
    }

    private static Automobile getAutomobile(String[] tokens) {
        String model = tokens[2];
        int power = Integer.parseInt(tokens[3]);
        Automobile auto = new Automobile(model, power);
        return auto;
    }

    private static Pokemon getPokemon(String id, String parameter) {
        Pokemon pokemon = new Pokemon(id, parameter);
        return pokemon;
    }

    private static Child getChild(String id, String parameter) {
        Child child = new Child(id, parameter);
        return child;
    }

    private static Parent getParent(String id, String parameter) {
        Parent parent = new Parent(id, parameter);
        return parent;
    }

    private static Company getCompany(String[] tokens) {
        String companyName = tokens[2];
        String department = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        Company company = new Company(companyName, department, salary);
        return company;
    }
}
