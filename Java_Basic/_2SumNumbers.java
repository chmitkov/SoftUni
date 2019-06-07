import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.function.Function;

public class _2SumNumbers {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[],Integer> countNums = x->x.length;
        Function<int[],Integer> sumAllNums = x-> {
            int sum = 0;
            for (int i : x) {
                sum+=i;
            }
            return sum;
        };

        System.out.printf("Count = %d%n",countNums.apply(nums));
        System.out.printf("Sum = %d%n", sumAllNums.apply(nums));
    }
}
