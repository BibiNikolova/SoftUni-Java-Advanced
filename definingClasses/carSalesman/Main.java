package objectsAndClasses.carSalesman;

import objectsAndClasses.carSalesman.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<CarSalesman.Engine> engineList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String engineModel = input[0];
            int power = Integer.parseInt(input[1]);
            String displacement = "n/a";
            String efficiency = "n/a";
            if (input.length == 3) {
                if(!Character.isDigit(input[2].charAt(0))){
                    efficiency = input[2];
                } else {
                    displacement = input[2];
                }
            } else if (input.length > 3) {
                displacement = input[2];
                efficiency = input[3];
            }

            CarSalesman.Engine engine = new CarSalesman.Engine(engineModel, power, displacement, efficiency);
            engineList.add(engine);
        }
        List<CarSalesman.Car> carList = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String engineModel = input[1];
            String weight = "n/a";
            String colour = "n/a";

            if (input.length == 3) {
                if(!Character.isDigit(input[2].charAt(0))){
                    colour = input[2];
                } else {
                    weight = input[2];
                }
            } else if (input.length > 3) {
                weight = input[2];
                colour = input[3];
            }

            CarSalesman.Car car = new CarSalesman.Car(model, engineModel, weight, colour);
            carList.add(car);
        }
        for (int i = 0; i < carList.size(); i++) {
            String check = carList.get(i).getEngineModel();
            System.out.println(carList.get(i).getModel() + ":");
            engineList.stream()
                    .filter(engine -> engine.getEngineModel().equals(check))
                    .forEach(engine -> System.out.println(engine.toString()));
            System.out.println(carList.get(i).toString());
        }
    }
}

