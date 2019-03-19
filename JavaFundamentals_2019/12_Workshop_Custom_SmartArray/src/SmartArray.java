import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;

    private int[] items;
    private int size;
    private int capacity;

    public SmartArray() {
        this.items = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    "Index out bounds for SmartArray with size of " + this.size);
        }

        return this.items[index];
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            grow();
        }
        this.items[this.size] = element;
        this.size++;
    }

    public int removeAt(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    "Index out bounds for SmartArray with size of " + this.size);
        }

        int element = this.items[index];
        shiftLeft(index);

        return element;
    }

    public boolean contains(int element) {
        return Arrays.stream(this.items).allMatch(x -> x == element);
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
        }
    }

    public void insertAt(int index, int element) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    "Index out bounds for SmartArray with size of " + this.size);
        }

        if (this.size == this.capacity) {
            grow();
        }

        shiftRight(index);

        this.items[index] = element;
    }

    private void shiftRight(int index) {
        for (int i = this.items.length - 1; i > index; i--) {
            this.items[i] = this.items[i - 1];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.items.length - 1; i++) {
            this.items[i] = this.items[i + 1];
        }
        this.items[this.items.length - 1] = 0;
        this.size--;

        if (this.size < this.capacity / 4) {
            shrink();
        }
    }

    private void grow() {
        this.capacity *= 2;
        int[] resizedArray = new int[capacity];
        if (this.size >= 0)
            System.arraycopy(this.items, 0, resizedArray, 0, this.size);
        this.items = resizedArray;

    }

    private void shrink() {
        this.capacity /= 2;
        int[] shrinkArray = new int[this.capacity];
        System.arraycopy(this.items, 0, shrinkArray,
                0, this.items.length);
        this.items = shrinkArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.items[i])
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
