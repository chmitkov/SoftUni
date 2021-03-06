package problem_6_GenericCountMethodDouble;

public class Container<T extends Comparable> {

    private T value;

    public Container(T value){
        this.value = value;
    }


    public int compareTo(Container<T> other) {
        return this.value.compareTo(other.value);
    }
}
