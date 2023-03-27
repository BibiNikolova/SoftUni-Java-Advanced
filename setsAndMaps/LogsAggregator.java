package setsAndMaps;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //      user        ip      durations
        TreeMap<String, TreeMap<String, Integer>> logsData = new TreeMap<>();

//        for (int i = 0; i < n; i++) {
//            String[] input = scanner.nextLine().split("\\s+");
//
//            getLogs(logsData, input);
//        }
//        printLogs(logsData);
//    }
//
//    private static void getLogs(TreeMap<String, TreeMap<String, Integer>> logsData, String[] input) {
//        String user = input[1];
//        String ip = input[0];
//        int duration = Integer.parseInt(input[2]);
//
//        logsData.putIfAbsent(user, new TreeMap<>());
//        if (!logsData.get(user).containsKey(ip)) {
//            logsData.get(user).put(ip, duration);
//        } else {
//            int currentDuration = logsData.get(user).get(ip);
//            logsData.get(user).put(ip, currentDuration + duration);
//        }
//    }
//
//    private static void printLogs(TreeMap<String, TreeMap<String, Integer>> logsData) {
//        logsData.forEach((key, value) -> {
//            int durations = value.values().stream()
//                    .mapToInt(Integer::intValue)
//                    .sum();
//            System.out.print(key + ": " + durations + " [");
//            TreeSet<String> ipSet = new TreeSet<>(value.keySet());
//            System.out.print(String.join(", ", ipSet));
//            System.out.println("]");
//        });
//    }
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String user = input[1];
            String ip = input[0];
            int duration = Integer.parseInt(input[2]);

            logsData.putIfAbsent(user, new TreeMap<>());
            if (!logsData.get(user).containsKey(ip)) {
                logsData.get(user).put(ip, duration);
            } else {
                int currentDuration = logsData.get(user).get(ip);
                logsData.get(user).put(ip, currentDuration + duration);
            }
        }

        logsData.forEach((key, value) -> {
            int durations = value.values().stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.print(key + ": " + durations + " [");
            TreeSet<String> ipSet = new TreeSet<>(value.keySet());
            System.out.print(String.join(", ", ipSet));
            System.out.println("]");
        });
    }
}
