package definingClasses.pokemonTraine;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private  String name;
    public int badges;
    public List<Pokemon> pokemons;

    public Trainer() {
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges++;
    }


    @Override
    public String toString() {
        return String.format("%s %d %d", name, badges, pokemons.size());
    }
}
