package setsAndMaps;

import java.util.*;


public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfDragons = Integer.parseInt(scanner.nextLine());

        //         type        name    damage/health/armor
        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < numOfDragons; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            String damage = input[2];
            String health = input[3];
            String armor = input[4];

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).putIfAbsent(name, new ArrayList<>());
            if (dragons.get(type).get(name).isEmpty()) {
                dragons.get(type).get(name).add(getDamage(damage));

                dragons.get(type).get(name).add(getHealth(health));

                dragons.get(type).get(name).add(getArmor(armor));
            } else {
                dragons.get(type).get(name).set(0, getDamage(damage));

                dragons.get(type).get(name).set(1, getHealth(health));

                dragons.get(type).get(name).set(2, getArmor(armor));
            }
        }
        for (var e : dragons.entrySet()) {
           /* dragons.entrySet().stream()
                    .forEach(d -> {
                        System.out.print(d.getKey() + "::");
                        d.getValue().entrySet().stream()
                                .forEach(n -> {
                                    double damage = 0;
                                    double health = 0;
                                    double armor = 0;
                                    damage += n.getValue().get(0);
                                    health += n.getValue().get(1);
                                    armor += n.getValue().get(2);
                                    System.out.printf("(%.2f/%.2f/%.2f)%n",
                                            damage / d.getValue().size(), health / d.getValue().size(), armor / d.getValue().size());
                                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                                            ,n.getKey(), n.getValue().get(0), n.getValue().get(1), n.getValue().get(2));
                                });
                    });*/

            System.out.print(e.getKey() + "::");
            TreeMap<String, List<Integer>> names = e.getValue();
            double damage = 0;
            double health = 0;
            double armor = 0;
            for (var name : names.entrySet()) {
                damage += name.getValue().get(0);
                health += name.getValue().get(1);
                armor += name.getValue().get(2);
            }
            System.out.printf("(%.2f/%.2f/%.2f)%n", damage / names.size(), health / names.size(), armor / names.size());

           for (var name : names.entrySet()) {
               System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                       , name.getKey(), name.getValue().get(0), name.getValue().get(1), name.getValue().get(2));
           }
        }
    }

    private static Integer getArmor(String armor) {
        return Objects.equals(armor, "null")
                ? 10
                : Integer.parseInt(armor);
    }

    private static Integer getHealth(String health) {
        return Objects.equals(health, "null")
                ? 250
                : Integer.parseInt(health);
    }

    private static Integer getDamage(String damage) {
        if (Objects.equals(damage, "null")) {
            return 45;
        }
        return Integer.parseInt(damage);
    }

}
