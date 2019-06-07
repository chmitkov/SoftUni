import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _10ListOfPredicates {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num= Integer.parseInt(br.readLine());

        int [] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        BiPredicate<int[],Integer> isNumberPassCheck =
                (x, curNum)->{
                    for (int el : x) {
                       if(el%curNum!=0)
                           return false;
                    }
                    return true;
                };

        for (int i = 1; i <= num; i++) {
            if (isNumberPassCheck.test(numbers,i)){
                System.out.printf("%s ",i);
            }
        }
    }
}
