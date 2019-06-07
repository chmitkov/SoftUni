import java.util.Scanner;
public class Exam2017July23_02Choreography{
    public static void main(String [] args){
        Scanner scanner = new Scanner (System.in);

        int steps = Integer.parseInt(scanner.nextLine());
        int dancers = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        double stepsForDay = Math.ceil((steps*1.0/days)*1.0/steps),
                stepsPercent = (stepsForDay/steps)/100;
        double stepsForOne = stepsPercent*1.0/dancers;

        if (stepsForDay<=13){
            System.out.printf("Yes, they will succeed in that goal! %.2f%%.",stepsForOne);
        }else {
            System.out.printf("No, They will not succeed in that goal! Required %.2f%% steps to be learned per day.",stepsForOne );
        }

    }
}