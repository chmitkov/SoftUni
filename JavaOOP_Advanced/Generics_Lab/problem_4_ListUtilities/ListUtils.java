package problem_4_ListUtilities;

import java.util.Comparator;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMax(List<T> list) throws IllegalArgumentException {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        } else {
            T currentMax = list.get(0);
            for (T t : list) {
                if (currentMax.compareTo(t) < 0) {
                    currentMax = t;
                }
            }
            return currentMax;
        }
    }

    public static <T extends Comparable<T>> T getMin(List<T> list){
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        } else {
            T currentMin = list.get(0);
            for (T t : list) {
                if (currentMin.compareTo(t) < 0) {
                    currentMin = t;
                }
            }
            return currentMin;
        }
    }
}
