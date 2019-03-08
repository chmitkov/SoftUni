package p02_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        String[] strArr = ArrayCreator.create(5, "str");
        Integer[] numArr = ArrayCreator.create(Integer.class, 3, 8);
    }

}
