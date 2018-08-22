import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class _8HotPotato {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] names = br.readLine().split(" ");
        int num = Integer.valueOf(br.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, names);
        int counter = 1;
        while (queue.size() > 1) {

            for (int i = 1; i < num; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(counter))
            {
                System.out.printf("Removed %s%n", queue.peek());
            }else {
                System.out.printf("Prime %s%n", queue.poll());
            }
            counter++;

        }
        System.out.printf("Last is %s%n", queue.poll());
    }

    private static boolean isPrime(int num) {
        if (num==1){
            return true;
        }else if (num==2)
        {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
