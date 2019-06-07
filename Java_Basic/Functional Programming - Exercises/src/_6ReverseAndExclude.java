import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _6ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int num = Integer.parseInt(br.readLine());

        BiFunction<Integer, List<Integer>, List<Integer>> sortListByNum =
                (number, inputList) -> {
                    List<Integer> currentList = new ArrayList<>();
                    for (int i = inputList.size() - 1; i >= 0; i--) {
                            if (inputList.get(i)%number!=0){
                                currentList.add(inputList.get(i));
                            }
                    }
                    return currentList;
                };

         list = sortListByNum.apply(num,list);

         list.forEach(x-> System.out.printf("%s ",x));

    }
}
