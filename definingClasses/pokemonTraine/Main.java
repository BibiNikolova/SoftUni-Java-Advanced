package definingClasses.pokemonTraine;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String data = scanner.nextLine();

        while (!data.equals("Tournament")) {

            String trainerName = data.split("\\s+")[0];
            String pokemonName = data.split("\\s+")[1];
            String pokemonElement = data.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(data.split("\\s+")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);

            data = scanner.nextLine();
        }

        String fireWaterElectricity = scanner.nextLine();


        while (!fireWaterElectricity.equals("End")) {

            for (Trainer trainer : trainers.values()) {
                String element = fireWaterElectricity;
                List<Pokemon> currentTrainerList = trainer.getPokemons();
                boolean hasPokemon = currentTrainerList.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
                if(!hasPokemon) {
                    for (Pokemon pokemon : currentTrainerList) {
                        pokemon.setHealth(pokemon.getHealth());
                    }
                    currentTrainerList.removeIf(p -> p.getHealth() <= 0);
                } else {
                    trainer.setBadges(trainer.getBadges());
                }
            }

            fireWaterElectricity = scanner.nextLine();
        }

      trainers.values().stream()
              .sorted((f, s) -> Integer.compare(s.getBadges(), f.getBadges()))
              .forEach(System.out::println);
    }

}