package problem_03_StackIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T> {

    private List<T> items;

    public Stack() {
        this.items = new ArrayList<>();
    }

    public void push(T element) {
        this.items.add(element);
    }

    public void pop() {
        if (this.items.isEmpty()) {
            System.out.println("No elements");
        } else {
            this.items.remove(this.items.size() - 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Collections.reverse(this.items);
        this.items.forEach(x -> result.append(String.format("%s%n", x)));
        return result.toString();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.items.forEach(System.out::println);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {
        int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter > items.size() - 1;
        }

        @Override
        public T next() {
            return items.get(counter++);
        }
    }
}
