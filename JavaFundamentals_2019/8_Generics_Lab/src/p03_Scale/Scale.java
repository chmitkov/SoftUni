package p03_Scale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T first, T second) {
        this.left = first;
        this.right = second;
    }

    public T getHeavier() {
        int result = this.left.compareTo(this.right);
        if (result == 0) {
            return null;
        } else if (result < 0) {
            return this.right;
        } else {
            return this.left;
        }
    }
}
