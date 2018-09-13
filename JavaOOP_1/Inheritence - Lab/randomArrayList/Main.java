package randomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList myList = new RandomArrayList();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        System.out.println(myList.getRandomElement());


    }
}
