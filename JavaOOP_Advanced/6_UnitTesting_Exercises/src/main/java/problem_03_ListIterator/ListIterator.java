package problem_03_ListIterator;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterable<String> {
    private List<String> stringList;
    private int index;


    ListIterator() {
        this.stringList = new ArrayList<>();
    }

    ListIterator(String[] varargs) throws OperationNotSupportedException {
        if (varargs.length < 2) {
            throw new OperationNotSupportedException();
        }

        this.stringList = new ArrayList<>();

        for (int i = 1; i < varargs.length; i++) {
            if (varargs[i] == null) {
                throw new OperationNotSupportedException();
            }
            this.stringList.add(varargs[i]);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIteratorIterator();
    }

    boolean move() {
        if (index > this.stringList.size()) {
            return false;
        }
        this.index++;
        return true;
    }


    void print() throws OperationNotSupportedException {
        if (this.stringList.size() == 0) {
            throw new OperationNotSupportedException("Invalid Operation!");
        }
        System.out.println(this.stringList.get(index));
    }

    private final class ListIteratorIterator implements Iterator<String> {

        @Override
        public boolean hasNext() {
            return index < stringList.size() - 1;
        }

        @Override
        public String next() {
            return stringList.get(index++);
        }
    }
}
