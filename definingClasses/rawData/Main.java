package definingClasses.rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<RawData.Car> carList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String model = input.split("\\s+")[0];
            int enginePower = Integer.parseInt(input.split("\\s+")[2]);
            String cargoType = input.split("\\s+")[4];

            double tyrePressure = 0;

            if (Double.parseDouble(input.split("\\s+")[5]) < 1 ||
                    Double.parseDouble(input.split("\\s+")[7]) < 1 ||
                    Double.parseDouble(input.split("\\s+")[9]) < 1 ||
                    Double.parseDouble(input.split("\\s+")[11]) < 1) {
                tyrePressure = 0.5;
            } else {
                tyrePressure = 1;
            }

            RawData.Car car = new RawData.Car(model, enginePower, cargoType,
                    tyrePressure);
            carList.add(car);
        }
        String command = scanner.nextLine();
        if ("fragile".equals(command)) {
            List<RawData.Car> fragile = carList.stream()
                    .filter(car -> car.getCargoType().equals("fragile"))
                    .toList();
            fragile.stream()
                    .filter(car -> (car.getTyrePressure() < 1))
                    .forEach(System.out::println);
        } else if ("flammable".equals(command)) {
            List<RawData.Car> flammable = carList.stream()
                    .filter(car -> car.getCargoType().equals("flammable"))
                    .toList();
            flammable.stream()
                    .filter(car -> car.getEnginePower() > 250)
                    .forEach(System.out::println);
        }
    }
}
