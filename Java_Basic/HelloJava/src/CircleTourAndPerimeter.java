import java.util.Scanner;

public class CircleTourAndPerimeter {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner (System.in);

        double r = Double.parseDouble(scanner.nextLine()),
                tour = Math.PI*(2*r),
                s = Math.PI*(r*r);
        System.out.print("Tour is : "+Math.round(tour)+"\n"+"S is : "+Math.round(s));
    }

}
