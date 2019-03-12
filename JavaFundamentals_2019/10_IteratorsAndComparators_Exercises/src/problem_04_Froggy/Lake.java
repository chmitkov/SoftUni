package problem_04_Froggy;

import java.util.*;

public class Lake implements Iterable {

    private int[] items;

    public Lake(int[] items) {
        this.setItems(items);
    }

    public int[] getItems() {
        return items;
    }

    private void setItems(int[] items) {
        this.items = items;
    }

    public String printMoves() {
        List<String> resultMoves = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if (i % 2 == 0) {
                resultMoves.add(items[i]+"");
            }
        }

        for (int i = 0; i < items.length; i++) {
            if (i % 2 != 0) {
                resultMoves.add(items[i]+"");
            }
        }

        return String.join(", ", resultMoves);

    }

    @Override
    public Iterator iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator {
        int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter > items.length - 1;
        }

        @Override
        public Object next() {
            return items[this.counter++];
        }
    }
}
