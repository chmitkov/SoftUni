package problem_1_Jar_of_T;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {

    private Deque<T> content;


    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public Deque<T> getContent() {
        return content;
    }

    public void add(T element) {
        this.content.push(element);
    }

    public T remove() {
        return this.content.pop();
    }

}
