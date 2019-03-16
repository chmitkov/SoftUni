import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(num1);
        System.out.println(linkedList);
        System.out.println("==========================");

        linkedList.addLast(num2);
        System.out.println(linkedList);
        System.out.println("==========================");

        int[] array = linkedList.toArray();
        System.out.println(array);
        System.out.println("==========================");

        linkedList.forEach(System.out::println);
        System.out.println("==========================");

        linkedList.addLast(num3);
        linkedList.addLast(num4);
        linkedList.addLast(num5);

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);
        System.out.println("==========================");

        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);
        System.out.println("==========================");

        linkedList.addFirst(num1);
        linkedList.addFirst(num5);
        linkedList.addAfter(num1,num5);
        System.out.println(linkedList);
        System.out.println("==========================");

        System.out.println(linkedList.removeAfter(num1));
        System.out.println(linkedList);
        System.out.println("==========================");

    }
}
