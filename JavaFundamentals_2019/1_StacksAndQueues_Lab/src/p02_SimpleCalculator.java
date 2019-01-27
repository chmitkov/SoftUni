import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class p02_SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersAndOperators = br.readLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, numbersAndOperators);

        int sum = 0;

        String operator = "+";

        for (String s : stack) {
            if ("+".equals(s)) {
                operator = "+";
            } else if ("-".equals(s)) {
                operator = "-";
            } else {
                int currentNumber = Integer.parseInt(s);
                if ("+".equals(operator)) {
                    sum += currentNumber;
                } else {
                    sum -= currentNumber;
                }
            }
        }
        System.out.println(sum);
    }
}
