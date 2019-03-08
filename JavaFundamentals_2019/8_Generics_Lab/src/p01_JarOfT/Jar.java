package p01_JarOfT;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {
    private List<T> store;

    public Jar() {
        this.store = new ArrayList<>();
    }

    public void add(T element) {
        this.store.add(element);
    }

    public T remove() {
        return this.store.get(store.size() - 1);
    }
}
