package setsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {

            double sum = 0;
            List<Double> current = entry.getValue();
            for (Double d : current) {
                sum += d;
            }
            //дава грешка в 7 тест; вероятно е от precision и затова го замених с обикновен for
            /*double avg = entry.getValue().stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .getAsDouble();*/

            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(v -> System.out.printf("%.2f ", v));
            System.out.printf("(avg: %.2f)%n", sum/ current.size());
        }
    }
}
