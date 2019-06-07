import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _1EncryptSortPrintArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Character> vowels = new ArrayList<>(
                Arrays.asList('a', 'i', 'u', 'o', 'e', 'A', 'I', 'U', 'E', 'O')
        );

        while (n-- > 0) {
            String currentName = scanner.nextLine();
            int currNameInInt = 0;
            for (int i = 0; i < currentName.length(); i++) {
                if (vowels.contains(currentName.charAt(i))) {
                    currNameInInt+=((int)currentName.charAt(i)*currentName.length());
                } else {
                    currNameInInt+=((int)currentName.charAt(i)/currentName.length());
                }
            }
            array.add(currNameInInt);
        }
        Collections.sort(array,(a,b)->a.compareTo(b));
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}
