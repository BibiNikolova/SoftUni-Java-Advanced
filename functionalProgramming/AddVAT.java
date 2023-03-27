package functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> input = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        UnaryOperator<Double> VAT = p -> p * 1.2;

        System.out.println("Prices with VAT:");

        input.stream()
                .forEach(v -> {
                    double addedVat = VAT.apply(v);
                    System.out.println(String.format("%.2f", addedVat));
                });
    }
}
