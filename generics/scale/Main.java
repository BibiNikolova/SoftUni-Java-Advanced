package generics.scale;

public class Main {
    public static void main(String[] args) {

        Scale<String> clothes = new Scale<>("L", "M");
        System.out.println(clothes.getHeavier());

        Scale<Integer> grades = new Scale<>(6, 4);
        System.out.println(grades.getHeavier());
    }
}
