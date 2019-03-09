package p07_CustomList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {
    public static <T extends Comparable<T>> void sort(List<T>list){
        Collections.sort(list);
    }
}
