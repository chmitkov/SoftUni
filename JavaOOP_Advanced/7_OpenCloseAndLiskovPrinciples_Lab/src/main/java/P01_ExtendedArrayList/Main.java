package P01_ExtendedArrayList;

import P01_ExtendedArrayList.ExtendedArrayList;

public class Main {
    public static void main(String[] args) {
        ExtendedArrayList<Integer> myList = new ExtendedArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        System.out.println(myList.max());
        System.out.println(myList.min());
    }
}
