package generics.arrayCreator;

public class Main {
    public static void main(String[] args) {
        String[] str = ArrayCreator.create(5, "none");
        Integer[] integ = ArrayCreator.create(Integer.class,10,0);
    }
}
