import java.util.Scanner;

public class Exam2018January07_5Butterfly {
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

        int width = (4 * n) - 4,
                spaces = width - 4;


        for (int i = 0; i < n - 2; i++) {
            System.out.println(repStr("*\\", 1 + i)
                    + repStr(" ", spaces)
                    + repStr("/*", 1 + i));
            spaces -= 4;
        }

        String specRow1 = repStr("\\/", width / 2),
                specRow2 = repStr("/\\", width / 2);

        String midRow = repStr("<", (width - 6) / 2) + "*|**|*" + repStr(">", (width - 6) / 2);

        System.out.println(specRow1);
        for (int i = 0; i < n / 2; i++) {
            System.out.println(midRow);
        }
        System.out.println(specRow2);
        int spaces2 = 4;
        for (int i = 0; i < n - 2; i++) {

            System.out.println(repStr("*/", n - 2 - i)
                    + repStr(" ", spaces2)
                    + repStr("\\*", (n - 2 - i)));
            spaces2 += 4;
        }
    }
}