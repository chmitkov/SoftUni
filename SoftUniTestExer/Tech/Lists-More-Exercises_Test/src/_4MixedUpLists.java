import java.util.*;
import java.util.stream.Collectors;

public class _4MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> biggerList = firstList.size() > secondList.size() ? firstList : secondList;

        int num1 = biggerList.get(biggerList.size() - 1);
        int num2 = biggerList.get(biggerList.size() - 2);

        biggerList.remove(biggerList.size() - 1);
        biggerList.remove(biggerList.size() - 1);

        int startRange = Math.min(num1, num2);
        int endRange = Math.max(num1, num2);
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < firstList.size(); i++) {
            if (firstList.get(i) > startRange && firstList.get(i) < endRange) {
                resultList.add(firstList.get(i));
            }
            if (secondList.get(i) > startRange && secondList.get(i) < endRange) {
                resultList.add(secondList.get(i));
            }
        }
        Collections.sort(resultList);
        resultList.forEach(x -> System.out.printf("%d ", x));
    }
}
