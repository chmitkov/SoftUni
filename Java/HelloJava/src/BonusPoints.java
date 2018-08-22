import java.util.Scanner;

public class BonusPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int points = Integer.parseInt(scanner.nextLine());
        //int bonus = 0;
        if ((1<=points)&&(points<=3)){
            points*=10;
        }else if((4<=points)&&(points<=6)){
            points*=100;
        }else if ((7<=points)&&(points<=9)){
            points*=1000;
        }else{
            System.out.println("Error");
        }
        System.out.println(points);
    }
}
