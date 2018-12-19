package problem_3_GenericScale;

public class Scale<T extends Comparable<T>> {

    private T leftElement;
    private T rightElement;

    public Scale(T leftElement, T rightElement) {
        this.leftElement = leftElement;
        this.rightElement = rightElement;
    }

    public T getHeavier() {
        if (leftElement.compareTo(rightElement) == 0) {
            return null;
        }

        return leftElement.compareTo(rightElement) > 0 ? leftElement : rightElement;
    }
}
