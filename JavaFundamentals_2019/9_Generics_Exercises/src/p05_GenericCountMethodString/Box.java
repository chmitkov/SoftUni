package p05_GenericCountMethodString;

import java.util.List;
import java.util.stream.Collectors;

public class Box<T extends Comparable<T>> implements Comparable<T> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    public static <T> List<T> swap(List<T> list, int firstIndex, int secondIndex) {
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);

        return list;
    }


    public static <T extends Comparable<T>>
    int countOfBiggerElements(List<Box> list, T element) {
        return list.stream()
                .filter(x -> x.compareTo(element) > 0)
                .collect(Collectors.toList())
                .size();
    }

    @Override

    public String toString() {
        return String.format("%s: %s", item.getClass().getName(),
                this.item);
    }

    @Override
    public int compareTo(T o) {
        return this.item.compareTo(o);
    }
}
