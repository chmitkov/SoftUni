package problem_03_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        String line;

        while (!"END".equals(line = br.readLine())) {
            line = line.replace(","," ");
            String[] commands = line.split("\\s+");

            if ("Push".equals(commands[0])) {
                Arrays.stream(commands)
                        .skip(1)
                        .map(Integer::parseInt)
                        .forEach(stack::push);
            } else {
                stack.pop();
            }
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
