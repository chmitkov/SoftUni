import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _8FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallerNumber =
                x -> {
                    int small = Integer.MAX_VALUE;
                    int smallIndex = 0;
                    for (int i = 0; i < x.size(); i++) {
                        if (x.get(i)<=small){
                            small = x.get(i);
                            smallIndex = i;
                        }
                    }
                    return smallIndex;
                };

        int result = findSmallerNumber.apply(nums);
        System.out.println(result);
    }
}
