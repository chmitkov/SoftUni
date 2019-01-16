package problem_04_BubbleSort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bubble implements Iterable<Integer> {

    private List<Integer> numbers;

    Bubble() {
        this.numbers = new ArrayList<>();
    }

    Bubble(List<Integer> nums) {
        this.numbers = new ArrayList<>();
        this.numbers.addAll(nums);
    }

     List<Integer> getNumbers() {
        return numbers;
    }

     void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new BubbleIterator();
    }

    void sort() {
        boolean swapAnyElement = true;
        int size = this.numbers.size();
        while (size-- > 0) {
            if (swapAnyElement) {
                swapAnyElement = false;
                for (int i = 0; i < this.numbers.size() - 1; i++) {
                    if (this.numbers.get(i) > this.numbers.get(i + 1)) {

                        Integer temp = this.numbers.get(i);
                        this.numbers.set(i, this.numbers.get(i + 1));
                        this.numbers.set(i + 1, temp);

                        swapAnyElement = true;
                    }
                }
            }
        }
    }

    private final class BubbleIterator implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < numbers.size();
        }

        @Override
        public Integer next() {
            return numbers.get(index++);
        }

    }
}
