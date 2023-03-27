package definingClasses.google;

public class Parent {
    private String parentName;
    private String parentBirthday;

    public Parent(String id, String parameter) {
        this.parentName = id;
        this.parentBirthday = parameter;
    }

    public String getParentName() {
        return parentName;
    }

    public String getBirthday() {
        return parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n",parentName, parentBirthday);
    }
}
