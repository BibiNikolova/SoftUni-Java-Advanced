package iteratorsAndComparators.stackIterator;

import java.util.Iterator;
import java.util.List;

public class StackIterator implements Iterable<String> {
    private List<String> elements;
    private String topElement;

    public StackIterator(String... elements) {
        this.elements = List.of(elements);
        topElement = this.elements.get(elements.length - 1);
    }

    public boolean hasNext() {
        return this.elements.size() > 0;
    }

    public void push(String current) {
        this.elements.add(current);
    }

    public boolean pop() {
       return this.elements.remove(topElement);
    }

    public void print() {
        if (elements.isEmpty()) {
            System.out.println("No elements");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int internalIndex;

            @Override
            public boolean hasNext() {
                return internalIndex < elements.size();
            }

            @Override
            public String next() {
                String element = elements.get(internalIndex);
                internalIndex++;
                return element;
            }
        };
    }

}

