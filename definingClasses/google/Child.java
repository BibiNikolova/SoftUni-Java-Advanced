package definingClasses.google;

public class Child {
    private String childName;
    private String childBirthday;

    public Child(String id, String parameter) {
        this.childName = id;
        this.childBirthday = parameter;
    }

    public String getChildName() {
        return childName;
    }

    public String getChildBirthday() {
        return childBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n",childName, childBirthday);
    }
}
