package p07_CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> customListItems;

    CustomList() {
        this.customListItems = new ArrayList<>();
    }

    void add(T element) {
        this.customListItems.add(element);
    }

    T remove(int index) {
        return this.customListItems.remove(index);
    }

    boolean contains(T element) {
        return this.customListItems.contains(element);
    }

    void swap(int firstIndex, int secondIndex) {
        T temp = this.customListItems.get(firstIndex);

        this.customListItems.set(firstIndex, this.customListItems.get(secondIndex));
        this.customListItems.set(secondIndex, temp);
    }

    int countGreaterThan(T element) {
        return (int) this.customListItems.stream()
                .filter(el -> el.compareTo(element) > 0)
                .count();
    }

    T getMax() {
        return this.customListItems.stream()
                .max(T::compareTo).orElse(null);
    }

    T getMin() {
        return this.customListItems.stream()
                .min(T::compareTo)
                .orElse(null);

    }

    void sort() {
        Sorter.sort(this.customListItems);
    }


    @Override
    public String toString() {
        return this.customListItems.stream()
                .map(x -> String.format("%s%n", x.toString()))
                .collect(Collectors.joining());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return this.counter < customListItems.size();
            }

            @Override
            public T next() {
                return customListItems.get(counter++);
            }
        };
    }
}

