import java.util.Scanner;

import static java.lang.Math.*;

public class NumberBiggest {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine()),
                num2 = Double.parseDouble(scanner.nextLine()),
                num3 = Double.parseDouble(scanner.nextLine()),
                num4 = Double.parseDouble(scanner.nextLine()),
                num5 = Double.parseDouble(scanner.nextLine());

        double big;
        big = Math.max(Math.max(Math.max(num1,num2), Math.max(num3,num4)), num5);
        System.out.printf("%.0f",big);
    }
}
