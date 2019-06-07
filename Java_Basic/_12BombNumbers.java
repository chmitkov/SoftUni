import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _12BombNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> field = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        //ArrayList<String> cars = new ArrayList<String>(Arrays.asList(scanner.nextLine().split("\\s+")));
        int[] commands = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bomb = commands[0];
        int bombPower = commands[1];

        while (field.contains(bomb)) {
            field = bombFire(field, bomb, bombPower);
        }
        int sum = 0;
        while (field.size()>0){
            sum+=field.get(0);
            field.remove(0);
        }
        System.out.println(sum);
    }

    private static ArrayList<Integer> bombFire(ArrayList<Integer> field, int bomb, int bombPower) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < field.size(); i++) {
            if (field.get(i) == bomb) {
                int startIndexToCut = i - bombPower < 0
                        ? 0
                        : i - bombPower;
                int endIndexToCut = i + bombPower > field.size() - 1
                        ? field.size() - 1
                        : i + bombPower;
                for (int j = 0; j < field.size(); j++) {
                    if (j >= startIndexToCut && j <= endIndexToCut) {

                    }else{
                        result.add(field.get(j));
                    }
                }
                break;
            }
        }
        return  result;
    }
}
