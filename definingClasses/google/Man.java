package definingClasses.google;

import java.util.ArrayList;
import java.util.List;

public class Man {

    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Automobile auto;

    public Man(String name, Company company, List<Pokemon> pokemons, List<Parent> parents, List<Child> children, Automobile auto) {
        this.name = name;
        this.company = company;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Automobile getAuto() {
        return auto;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setAuto(Automobile auto) {
        this.auto = auto;
    }

}
