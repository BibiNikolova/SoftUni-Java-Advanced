package functionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(nums);

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isOdd = n -> n % 2 != 0;

        nums.stream()
                .filter(isEven)
                .forEach(n -> System.out.print(n + " "));
        nums.stream()
                .filter(isOdd)
                .forEach(n -> System.out.print(n + " "));

//        Comparator<Integer> comparator =  (first, second) -> {
//            if(first % 2 == 0 && second % 2 != 0){
//                return -1;
//                //първото е четно
//                //второто е нечетно
//            } else if(first %2 != 0 && second % 2 == 0){
//                return 1;
//                //първото е нечетно
//                //второто е четно
//            }
//            //и двете са четни
//            //и двете са нечетни
//
//            return first.compareTo(second);
//        };
//
//        nums.sort(comparator);
//
//        nums.forEach(e -> System.out.print(e + " "));
    }
}
