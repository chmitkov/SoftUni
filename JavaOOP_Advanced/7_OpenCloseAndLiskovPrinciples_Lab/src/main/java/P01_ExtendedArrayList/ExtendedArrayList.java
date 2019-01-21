package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {

    public T min() {
        Iterator<T> iterator = super.iterator();
        T min = iterator.next();

        while (iterator.hasNext()) {
            T currentElement = iterator.next();
            if (currentElement.compareTo(min) < 0) {
                min = currentElement;
            }
        }
        return min;
    }

    public T max() {
        Iterator<T> iterator = super.iterator();
        T max = iterator.next();

        while (iterator.hasNext()) {
            T currentElement = iterator.next();
            if (currentElement.compareTo(max) > 0) {
                max = currentElement;
            }
        }
        return max;
    }

}
