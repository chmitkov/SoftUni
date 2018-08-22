import java.util.Scanner;

public class Exam2018January07_1Sandbox {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double hight = Double.parseDouble(scanner.nextLine()),
                width = Double.parseDouble(scanner.nextLine()),
                sandPrice = Double.parseDouble(scanner.nextLine()),
                boarsPrice = Double.parseDouble(scanner.nextLine());

        double sandboxS = hight*width,
                sandS = (hight-(0.2+0.2))*(width-(0.2+0.2)),
                boardS = sandboxS-sandS,
                sandNeed= Math.ceil(sandS * 20),
                boardNeed = Math.ceil(boardS*1.0/(2.2*0.2)),
                sandCosts = (sandNeed*sandPrice),
                boardCosts =(boardNeed*boarsPrice),
                all = (sandCosts+boardCosts);
        System.out.printf("%.02f",all);
    }
}
