import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p07_MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] names = br.readLine().split("\\s+");

        Collections.addAll(queue, names);
        int number = Integer.parseInt(br.readLine());

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < number; i++)
                queue.offer(queue.poll());

            if (isPrime(cycle))
                System.out.println("Prime " + queue.peek());
            else
                System.out.println("Removed " + queue.poll());

            cycle++;
        }
        System.out.println("Last is " + queue.poll());

    }

    private static boolean isPrime(int num) {
        double limit = Math.sqrt(num);
        for (long i = 2; i < limit; i++)
            if (num % i == 0)
                return false;
        return true;
    }


}

