import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _2CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double leftCar = 0;
        double rightCar = 0;
        int counter = list.size() / 2;
        for (int i = 0; i < counter; i++) {
            if (list.get(i) == 0) {
                leftCar *= 0.8;
            } else {
                leftCar += list.get(i);
            }
            if (list.get(list.size() - 1 - i) == 0) {
                rightCar *= 0.8;
            } else {
                rightCar += list.get(list.size() - 1 - i);
            }
        }

        System.out.printf("The winner is %s with total time: %f",
                leftCar < rightCar ? "left" : "right",
                leftCar < rightCar ? leftCar : rightCar);
    }
}
