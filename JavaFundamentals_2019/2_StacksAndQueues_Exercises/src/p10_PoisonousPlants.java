import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p10_PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPlants = Integer.parseInt(br.readLine());

        List<Integer> field = Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int daysCounter = -1;

        boolean plantsStopsDying = false;

        while (!plantsStopsDying) {

            daysCounter++;
            plantsStopsDying = true;
            int counter = field.size();

            for (int i = counter - 2; i >= 0; i--) {
                if (field.get(i) < field.get(i + 1)) {
                    plantsStopsDying = false;
                    field.remove(i + 1);
                }
            }

        }

        System.out.println(daysCounter);

    }
}

