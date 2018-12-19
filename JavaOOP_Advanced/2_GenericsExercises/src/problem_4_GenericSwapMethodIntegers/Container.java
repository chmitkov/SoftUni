package problem_4_GenericSwapMethodIntegers;

public class Container<T> {
    private T value;

    public Container(T value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }
}
