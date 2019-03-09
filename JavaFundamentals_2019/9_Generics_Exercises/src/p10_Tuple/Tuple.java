package p10_Tuple;

public class Tuple<F, S> {
    private F firstElement;
    private S secondElement;

    public Tuple(F firstElement, S secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public F getFirstElement() {
        return firstElement;
    }

    public S getSecondElement() {
        return secondElement;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.firstElement, this.secondElement);
    }
}
