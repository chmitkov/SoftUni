import java.util.Scanner;

public class RectanglePandS {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner (System.in);
        double x1 = Double.parseDouble(scanner.nextLine()),
                y1 = Double.parseDouble(scanner.nextLine()),
                x2 = Double.parseDouble(scanner.nextLine()),
                y2 = Double.parseDouble(scanner.nextLine()),
                side1 = Math.abs(x1 - x2),
                side2 = Math.abs(y1 - y2),
                s = side1*side2,
                p = 2*(side1+side2);
        System.out.printf("%f"+"%n"+"%f",s,p);
    }
}
