package examPreparation.type01;

import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materialsStack::push);

        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(magicLevelQueue::offer);

        Map<Integer, String> craftCombinations = getCombination();

        Map<String, Integer> craftedPresents = new TreeMap<>();

        while (!magicLevelQueue.isEmpty() && !materialsStack.isEmpty()) {
            int currentMaterial = materialsStack.peek();
            int currentMagic = magicLevelQueue.peek();

            int craftMixture = getCraftMixture(currentMaterial, currentMagic);

            if (!craftCombinations.containsKey(craftMixture)) {
                if (craftMixture > 0) {
                    increaseMaterial(materialsStack, magicLevelQueue, currentMaterial, 15);
                } else if (craftMixture < 0) {
                    increaseMaterial(materialsStack, magicLevelQueue, currentMaterial, currentMagic);
                } else {
                    zeroCheck(materialsStack, magicLevelQueue, currentMaterial, currentMagic);
                }
            } else {
                craftPresent(materialsStack, magicLevelQueue, craftCombinations, craftedPresents, craftMixture);
            }
        }

        if (((craftedPresents.containsKey("Doll") && craftedPresents.containsKey("Wooden train"))
                || (craftedPresents.containsKey("Teddy bear") && craftedPresents.containsKey("Bicycle")))) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            printLeft(materialsStack);
        }
        if (!magicLevelQueue.isEmpty()) {
            System.out.print("Magic left: ");
            printLeft(magicLevelQueue);
        }
        craftedPresents.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void printLeft(ArrayDeque<Integer> deque) {
        List<String> temp = deque.stream()
                .map(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(", ", temp));
    }

    private static void craftPresent(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicLevelQueue, Map<Integer, String> neededCombination, Map<String, Integer> craftedPresents, int craftMixture) {
        String present = neededCombination.get(craftMixture);
        craftedPresents.putIfAbsent(present, 0);
        int currentPresentCount = craftedPresents.get(present);
        craftedPresents.put(present, currentPresentCount + 1);
        materialsStack.pop();
        magicLevelQueue.poll();
    }

    private static void zeroCheck(ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicLevelQueue, int currentMaterial, int currentMagic) {
        if (currentMagic == 0 || currentMaterial == 0) {
            if (currentMaterial == 0) {
                materialsStack.pop();
            }
            if (currentMagic == 0) {
                magicLevelQueue.poll();
            }
        }
    }

    private static void increaseMaterial
            (ArrayDeque<Integer> materialsStack, ArrayDeque<Integer> magicLevelQueue, int currentMaterial, int x) {
        int result = currentMaterial + x;
        materialsStack.pop();
        magicLevelQueue.poll();
        materialsStack.push(result);

    }

    private static int getCraftMixture(int currentMaterial, int currentMagic) {
        return currentMaterial * currentMagic;
    }

    private static Map<Integer, String> getCombination() {
        Map<Integer, String> neededCombination = new HashMap<>();
        neededCombination.put(150, "Doll");
        neededCombination.put(250, "Wooden train");
        neededCombination.put(300, "Teddy bear");
        neededCombination.put(400, "Bicycle");
        return neededCombination;
    }

}
