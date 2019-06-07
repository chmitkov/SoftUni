import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class _2SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        Set<Integer> result = new LinkedHashSet<>();
        int[] setSize = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < setSize[0]; i++) {
            set1.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < setSize[1]; i++) {
            set2.add(Integer.parseInt(br.readLine()));
        }
        for (int num : set1) {
            if (set2.contains(num)) {
                result.add(num);
                //System.out.printf("%d ",num);
            }
        }
        result.forEach(x-> System.out.printf("%d ",x));
    }
}
