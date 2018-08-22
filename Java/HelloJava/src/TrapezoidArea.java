import java.util.Scanner;

public class TrapezoidArea {
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        double b1 = Double.parseDouble(scanner.nextLine()),
                b2 = Double.parseDouble(scanner.nextLine()),
                h = Double.parseDouble(scanner.nextLine()),
                S = ((b1+b2)*h)/2;
        System.out.println(S);
    }
}
