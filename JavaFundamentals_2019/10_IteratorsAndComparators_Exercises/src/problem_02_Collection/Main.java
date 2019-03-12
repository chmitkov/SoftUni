package problem_02_Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator<String> listyIterator = new ListyIterator<>();
        String line = "";

        while (!"END".equals(line = br.readLine())) {
            String[] commands = line.split("\\s+");

            switch (commands[0]) {
                case "Create":
                    if (commands.length > 1) {
                        String str = Arrays.stream(commands).skip(1)
                                .collect(Collectors.joining(" "));
                        listyIterator = new ListyIterator<>(str.split("\\s+"));
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
        }
    }
}
