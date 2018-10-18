import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _1Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Character> charList = scanner.nextLine()
                .chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());

        String result = "";
        for (int num : list) {
            int currSum = takeSumFromNum(num);

            while (currSum >= charList.size()) {
                currSum -= charList.size();
            }

            result += charList.get(currSum);

            charList.remove(currSum);
        }

        System.out.println(result);
    }

    private static int takeSumFromNum(Integer num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
