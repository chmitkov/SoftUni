import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ReverseNumberWhitAStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String[] input = br.readLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Arrays.stream(input).forEach(stack::push);

        stack.forEach(x-> System.out.printf("%s ", stack.pop()));


    }
}
