package definingClasses.constructors;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Supplier<CarConstructors> carInfo = () -> {
            String[] specification = scanner.nextLine().split("\\s+");
            String brand = specification[0];
            if (specification.length == 1) {
                return new CarConstructors(brand);
            } else {
                String model = specification[1];
                int horsePower = Integer.parseInt(specification[2]);
                return new CarConstructors(brand, model, horsePower);
            }
        };

        List<CarConstructors> carList = IntStream.range(0, n)
                .mapToObj(ignored -> carInfo.get())
                .collect(Collectors.toList());

        for (CarConstructors carConstructors : carList) {
            System.out.println(carConstructors.toString());
        }
    }
}

