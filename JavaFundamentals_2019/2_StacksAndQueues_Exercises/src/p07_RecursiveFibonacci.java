import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class p07_RecursiveFibonacci {
    private static Map<Long, Long> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long position = Long.parseLong(br.readLine());

        System.out.println(FibNumber(position));
    }

    private static long FibNumber(long position) {
        if (position == 0 || position == 1) {
            return 1;
        }

        if(checkForNumbersInMap(position)!=0){
            return checkForNumbersInMap(position);
        }

        long beforeNumber = checkForNumbersInMap(position - 1);
        long beforeBeforeNumber = checkForNumbersInMap(position - 2);

        if (beforeNumber != 0 && beforeBeforeNumber != 0) {
            return beforeNumber + beforeBeforeNumber;
        } else {
            long currentFib = FibNumber(position - 1) + FibNumber(position - 2);
            map.put(position, currentFib);
            return currentFib;
        }

    }

    private static long checkForNumbersInMap(long position) {

        return map.containsKey(position) ? map.get(position) : 0;
    }
}
