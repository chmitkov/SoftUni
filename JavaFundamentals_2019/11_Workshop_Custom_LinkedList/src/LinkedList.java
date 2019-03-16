import java.awt.dnd.InvalidDnDOperationException;
import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null; // This is the default values, but is good practice
        this.tail = null; // This is the default values, but is good practice
        this.size = 0;    // This is the default values, but is good practice
    }

    public void addFirst(int element) {
        Node newHead = new Node(element);
        if (this.size == 0) {
            this.head = newHead;
            this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head.previous = newHead;
            this.head = newHead;
        }

        this.size++;
    }

    public void addLast(int element) {
        Node newTail = new Node(element);
        if (this.size == 0) {
            this.head = newTail;
            this.tail = newTail;
        } else {
            this.tail.next = newTail;
            newTail.previous = this.tail;
            this.tail = newTail;
        }
        this.size++;
    }

    public int removeFirst() {
        if (this.size == 0) {
            throw new InvalidDnDOperationException(
                    "Remove called for collection with size 0");
        }

        int firstElement = this.head.element;
        this.head = this.head.next;
        if (this.head != null) {
            this.head.previous = null;
        } else {
            this.tail = null;
        }

        this.size--;
        return firstElement;
    }

    public int removeLast() {
        if (this.size == 0) {
            throw new InvalidDnDOperationException(
                    "Remove called for collection with size 0");
        }
        int lastElement = this.tail.element;
        this.tail = this.tail.previous;
        if (this.tail != null) {
            this.tail.next = null;
        } else {
            this.head = null;
        }

        this.size--;
        return lastElement;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node temp = this.head;
        while (temp != null) {
            consumer.accept(temp.element);
            temp = temp.next;
        }
    }

    public int[] toArray() {
        int[] resultArray = new int[this.size];
        Node temp = this.head;
        int index = 0;
        while (temp != null) {
            resultArray[index++] = temp.element;
            temp = temp.next;
        }
        return resultArray;
    }

    public void addAfter(int searchedElement, int element) {
        if (this.size == 0) {
            throw new InvalidDnDOperationException(
                    "AddAfter method on empty list");
        }

        Node temp = this.head;

        while (temp != null) {
            if (temp.element == searchedElement) {
                break;
            }
            temp = temp.next;
        }

        Node newNode = new Node(element);
        newNode.previous = temp;
        newNode.next = temp.next;
        newNode.next.previous = newNode;
        temp.next = newNode;
        this.size++;
    }

    public int removeAfter(int searchedElement) {
        if (this.size == 0) {
            throw new InvalidDnDOperationException(
                    "RemoveAfter method on empty list");
        }
        Node temp = this.head;
        while (temp != null) {
            if (temp.element == searchedElement) {
                break;
            }
            temp = temp.next;
        }
        Node nextNode = temp.next.next;
        int removedElement = temp.next.element;
        temp.next = nextNode;
        nextNode.previous = temp;
        this.size--;
        return removedElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = this.head;
        while (temp != null) {
            sb.append(temp.element).append(System.lineSeparator());
            temp = temp.next;
        }
        return sb.toString().trim();
    }
}
