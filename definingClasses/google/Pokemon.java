package definingClasses.google;

public class Pokemon {
    private String pokemonName;
    private String type;

    public Pokemon(String id, String parameter) {
        this.pokemonName = id;
        this.type = parameter;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", pokemonName, type);
    }
}
