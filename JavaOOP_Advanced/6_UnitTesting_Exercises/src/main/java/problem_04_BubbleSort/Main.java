package problem_04_BubbleSort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bubble bubble = new Bubble(new ArrayList<>(){{
            add(4);
            add(3);
            add(2);
            add(6);
        }});

        bubble.sort();

        System.out.println();
    }
}
