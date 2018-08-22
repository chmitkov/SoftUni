import java.util.Scanner;

public class Exam2017December17_4Workout {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double firstDayKm = Double.parseDouble(scanner.nextLine()),
               km= firstDayKm;
        for (int i = 0; i < days; i++){
            int percent = Integer.parseInt(scanner.nextLine());
            firstDayKm = firstDayKm + (firstDayKm*(percent*0.01));
            km+=firstDayKm;
        }
        if (km>=1000){
            System.out.printf("You've done a great job running %.0f more kilometers! ", Math.ceil(km-1000));
        }else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(1000-km));
        }
    }
}