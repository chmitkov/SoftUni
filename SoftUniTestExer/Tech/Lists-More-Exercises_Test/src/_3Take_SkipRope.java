import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _3Take_SkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> numList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                numList.add(Integer.parseInt(input.charAt(i) + ""));
            } else {
                charList.add(input.charAt(i));
            }
        }
        int counter = 0;
        String str = charList.toString();
        List<Integer> toTake = new ArrayList<>();
        List<Integer> toSkip = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            if (i % 2 == 0) {
                toTake.add(numList.get(i));
            } else {
                toSkip.add(numList.get(i));
            }
        }
        String result = "";

        for (int index = 0; index < toSkip.size(); index++) {
            int skipCount = toSkip.get(index);
            int takeCount = toTake.get(index);

            result += charList.stream()
                    .skip(counter)
                    .limit(takeCount)
                    .map(x -> x + "")
                    .collect(Collectors.joining());

            counter += skipCount + takeCount;
        }
        System.out.println(result);
    }

}
