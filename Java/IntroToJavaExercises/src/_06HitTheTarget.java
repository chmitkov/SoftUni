import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == num) {
                    list1.add(String.format("%d + %d = %d", i, j, num));
                }
                if (i - j == num) {
                    list2.add(String.format("%d - %d = %d", i, j, num));
                }
            }
        }
        System.out.println(String.join("\n",list1));
        System.out.println(String.join("\n",list2));
    }
}
