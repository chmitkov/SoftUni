import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p05_PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> queue = new ArrayDeque<>();

        String line;
        while (!"print".equals(line = br.readLine())) {
            queue.offer(line);
        }
        String tempEl = queue.poll();
        while (queue.size() >= 2) {
            String first = queue.pollFirst();
            if ("cancel".equals(first)) {
                if ("".equals(tempEl)) {
                    System.out.printf("Printer is on standby%n");
                } else {
                    System.out.println(String.format("Canceled %s", tempEl));
                    tempEl = "";
                }
            } else {
                System.out.println(first);
            }
        }

    }
}
