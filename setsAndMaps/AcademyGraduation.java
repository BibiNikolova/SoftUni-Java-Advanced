package setsAndMaps;

import java.util.*;

import static java.util.Arrays.stream;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            double sum = 0;
            double[] current = stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();;
            for (Double d : current) {
                sum += d;
            }
            //дава грешка във втори и пети тест; вероятно е от precision и затова го замених с обикновен for
          /*  double avg = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).average().getAsDouble();*/

            students.putIfAbsent(name, sum/current.length);
        }
        students.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " is graduated with " + e.getValue());
        });
    }
}

