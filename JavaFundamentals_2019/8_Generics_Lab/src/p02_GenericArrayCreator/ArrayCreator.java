package p02_GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {
    public static <T> T[] create(int length, T item) {
        T[] result = (T[]) new Object[length];
        result = (T[]) Arrays.stream(result).map(x -> x = item).toArray();

        return result;
    }

    public static <T> T[] create(Class<?> cl, int length, T item) {
        T[] result = (T[]) Array.newInstance(cl, length);
        result = (T[]) Arrays.stream(result).map(x -> x = item).toArray();

        return result;
    }
}
