package problem_8_CustomListSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {

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

    public List<T> getCustomListItems() {
        return customListItems;
    }

    public void setCustomListItems(List<T> customListItems) {
        this.customListItems = customListItems;
    }

    @Override
    public String toString() {
        return this.customListItems.stream()
                .map(x -> String.format("%s%n", x.toString()))
                .collect(Collectors.joining());
    }

}
