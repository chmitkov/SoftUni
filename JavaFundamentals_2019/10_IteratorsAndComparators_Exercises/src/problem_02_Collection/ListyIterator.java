package problem_02_Collection;

import java.util.*;
import java.util.stream.Collectors;

public class ListyIterator<T> implements Iterable<T> {
    private List<T> list;
    private int counter = 0;

    public ListyIterator(T... values) {
        this.setList(Arrays.asList(values));
    }

    public List<T> getList() {
        return Collections.unmodifiableList(list);
    }

    public void setList(List<T> list1) {
        this.list = list1.size() == 0 ? new ArrayList<>() : list1;
    }

    public boolean move() {
        if (counter < list.size() - 1) {
            counter++;
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println(this.list.isEmpty() ? "Invalid Operation!" : this.list.get(counter));
    }

    public void printAll(){
        for (T t : list) {
            System.out.printf("%s ", t);
        }
        System.out.println();
    }
    @Override
    public String toString() {
        return list.stream().map(T::toString).collect(Collectors.joining());
    }

    @Override
    public Iterator<T> iterator() {
        return new ListyIteratorIterator();
    }

    private final class ListyIteratorIterator implements Iterator<T> {


        @Override
        public boolean hasNext() {
            return counter < list.size() - 1;
        }

        @Override
        public T next() {
            return list.get(counter++);
        }
    }
}
