import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _5AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = br.readLine();
        while (!"end".equals(line)) {
            if ("print".equals(line)){
                list.forEach(x-> System.out.printf("%s ",x));
                System.out.println();
            }else{
                list = doSomethingWithList(line,list);
            }

            line = br.readLine();
        }

    }
    private static List<Integer> doSomethingWithList(String command, List<Integer> list){
        List<Integer> temp = new ArrayList<>();
        if ("add".equals(command)) {
            for (Integer i : list) {
                temp.add(++i);
            }

        } else if ("multiply".equals(command)) {
            for (Integer i : list) {
                temp.add(i*2);
            }
        } else if ("subtract".equals(command)) {
            for (Integer i : list) {
                temp.add(--i);
            }
        }
        return temp;
    }
}
