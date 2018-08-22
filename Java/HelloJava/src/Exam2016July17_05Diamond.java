import java.util.Scanner;

public class Exam2016July17_05Diamond {
    static String repStr(String strToRep, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += strToRep;
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int a = 1;
        for (int i = 0; i < 3 * n + 2; i++) {
            if (i == 0) {
                System.out.println(repStr(".", n) + repStr("*", 3 * n) + repStr(".", n));
            } else if (i == n) {
                System.out.println(repStr("*", 5 * n));
            } else if (i == 3 * n + 1) {
                System.out.println(repStr(".", n * 2 + 1) + repStr("*", 5 * n - (n * 2 + 1) * 2)
                        + repStr(".", n * 2 + 1));
            } else if (i < n) {
                System.out.println(repStr(".", n - i) + "*" + repStr(".", 3 * n + 2 * i - 2)
                        + "*" + repStr(".", n - i));
            } else {
                System.out.println(repStr(".", a) + "*" + repStr(".", 5 * n - 2 - 2 * a)
                        + "*" + repStr(".", a));
                a += 1;
            }
        }
    }
}
