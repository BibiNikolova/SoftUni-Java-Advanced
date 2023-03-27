package definingClasses.carInfo;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Supplier<Car> carInfo = () -> {
            String[] specification = scanner.nextLine().split(" ");
            String brand = specification[0];
            String model = specification[1];
            int horsePower = Integer.parseInt(specification[2]);
            return new Car(brand, model, horsePower);
        };

        List<Car> carList = IntStream.range(0, n)
                .mapToObj(ignored -> carInfo.get())
                .collect(Collectors.toList());

        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }
}
