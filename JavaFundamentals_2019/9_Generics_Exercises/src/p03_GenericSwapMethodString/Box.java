package p03_GenericSwapMethodString;

import java.util.List;

public class Box<T> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    public static <T>List<T> swap(List<T> list, int firstIndex, int secondIndex){
        T temp =  list.get(firstIndex);
        list.set(firstIndex,list.get(secondIndex));
        list.set(secondIndex,temp);

        return list;
    }
    @Override

    public String toString() {
        return String.format("%s: %s", item.getClass().getName(),
                this.item);
    }
}
