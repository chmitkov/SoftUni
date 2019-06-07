import java.util.Scanner;

public class Exam2017June25_05Triangle {
    static String repStr(String srtToRep, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += srtToRep;
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(repStr("#", 4 * n + 1));

        for (int i = 0; i < n; i++) {
            if (i == n / 2) {
                System.out.println(repStr(".", i + 1) + repStr("#", (2 * n - 1) - 2 * i)
                        + repStr(" ", (2 * i) / 2-1) + "(@)" + repStr(" ", (2 * i) / 2-1)
                        + repStr("#", (2 * n - 1) - 2 * i)
                        + repStr(".", i + 1));
            } else {
                System.out.println(repStr(".", i + 1) + repStr("#", (2 * n - 1) - 2 * i)
                        + repStr(" ", (2 * i + 1)) + repStr("#", (2 * n - 1) - 2 * i)
                        + repStr(".", i + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(repStr(".", n + 1 + i) + repStr("#", n * 2 - 1 - 2 * i)
                    + repStr(".", n + 1 + i));
        }
    }
}