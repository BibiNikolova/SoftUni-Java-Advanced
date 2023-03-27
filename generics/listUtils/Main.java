package generics.listUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> maxInt = new ArrayList<>();
        Collections.addAll(maxInt, 1, 2, 3, 4);

        Integer max = ListUtils.getMax(maxInt);
        System.out.println(max);

        List<String> minString = new ArrayList<>();
        Collections.addAll(minString, "a", "b", "c");

        String min = ListUtils.getMin(minString);
        System.out.println(min);
    }
}
