import java.util.Scanner;

public class Exam2016December18_05CristmasHat {
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
        String lastRow = repStr("*", 4 * n + 1),
                firstRow = repStr(".", n * 2 - 1) + "/|\\" + repStr(".", n * 2 - 1),
                afterFirst = repStr(".", n * 2 - 1) + "\\|/" + repStr(".", n * 2 - 1),
                beforeLast = repStr("*.", 2 * n) + "*";
        System.out.println(firstRow);
        System.out.println(afterFirst);
        for (int i = 0; i < 2 * n; i++) {
            System.out.println(repStr(".", n * 2 - 1 - i) + "*" + repStr("-", i)
                    + "*" + repStr("-", i)
                    + "*" + repStr(".", n * 2 - 1 - i));
        }
        System.out.println(lastRow);
        System.out.println(beforeLast);
        System.out.println(lastRow);
    }
}