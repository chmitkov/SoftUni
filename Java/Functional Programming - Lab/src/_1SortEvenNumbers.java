import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _1SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(br.readLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        list.removeIf(x -> x % 2 != 0);
        printListWithComas(list);

        list.sort(Comparator.naturalOrder());
        printListWithComas(list);
    }

    private static void printListWithComas(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i==list.size()-1){
                System.out.println(list.get(i));
            }else{
                System.out.printf("%s, ",list.get(i));
            }
        }
    }
}
