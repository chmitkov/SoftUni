import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p06_HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] names = br.readLine().split("\\s+");

        Collections.addAll(queue, names);
        int number = Integer.parseInt(br.readLine());

        int counter = 0;
        while (queue.size() > 1) {
            counter++;
            if (counter == number) {
                System.out.println(String.format("Removed %s",queue.poll()));
                counter = 0;
            }else {
                queue.add(queue.poll());
            }
        }
        System.out.println(String.format("Last is %s", queue.poll()));
    }
}
