package problem_03_ListIterator;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, OperationNotSupportedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ListIterator listIterator = new ListIterator(br.readLine().split("\\s+"));

        String line;

        while (!"END".equals(line = br.readLine())) {
            switch (line) {
                case "Print":
                    try {
                        listIterator.print();
                    } catch (OperationNotSupportedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listIterator.iterator().hasNext());
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
            }
        }
    }
}
