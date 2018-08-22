import java.util.Scanner;

public class Exam2017September03_05SnowFlake {
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

        for (int i = 0; i < n - 1; i++) {
            System.out.println(repStr(".", i) + "*" + repStr(".", n - i) + "*"
                    + repStr(".", n - i) + "*" + repStr(".", i));
        }
        String specialRow = repStr(".", n - 1) + "*****" + repStr(".", n - 1),
                midRow = repStr("*", 2 * n + 3);
        System.out.println(specialRow);
        System.out.println(midRow);
        System.out.println(specialRow);

        for (int i = 0; i < n - 1; i++) {
            System.out.println(repStr(".", n - 2 - i) + "*" + repStr(".", 2 + i) + "*"
                    + repStr(".", 2 + i) + "*" + repStr(".", n - 2 - i));
        }
    }
}