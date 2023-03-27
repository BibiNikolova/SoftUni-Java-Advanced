package definingClasses.familyTree;

import java.util.LinkedHashSet;
import java.util.List;

public class Person extends Parent {
    private LinkedHashSet<Parent> parents;
    private LinkedHashSet<Child> children;

    public Person(String firstName, String lastName, String birthday, List<Parent> parents, List<Child> children) {
        super(firstName, lastName, birthday);
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
    }

    public LinkedHashSet<Parent> getParents() {
        return parents;
    }

    public void setParents(LinkedHashSet<Parent> parents) {
        this.parents = parents;
    }

    public LinkedHashSet<Child> getChildren() {
        return children;
    }

    public void setChildren(LinkedHashSet<Child> children) {
        this.children = children;
    }
}
