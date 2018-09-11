import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _9CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Consumer<List<Integer>> sortAndPrintList =
                x-> {
                    Collections.sort(x);

                    List<Integer> currentList = new ArrayList<>();

                    currentList.addAll(x.stream()
                            .filter(n->n%2==0).collect(Collectors.toList()));

                    Collections.sort(currentList);

                    x.removeIf(n1->n1%2==0);

                    Collections.sort(x);

                    currentList.addAll(x);

                    currentList.forEach(e-> System.out.printf("%s ",e));
                };

        sortAndPrintList.accept(list);
    }
}
