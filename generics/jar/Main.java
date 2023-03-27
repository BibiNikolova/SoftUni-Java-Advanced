package generics.jar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jar<Integer> numJar = new Jar<>();

        numJar.add(12);
        numJar.add(13);
        numJar.add(14);
        numJar.add(15);

        System.out.println();
        numJar.remove();
        System.out.println();

    }
}
