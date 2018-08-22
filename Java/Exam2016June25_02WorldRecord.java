import java.util.Scanner;

public class Exam2016June25_02WorldRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine()),
                distance = Double.parseDouble(scanner.nextLine()),
                timeForM = Double.parseDouble(scanner.nextLine()),
                time = 0.0,
                waterRes = 0.0;

        for (int i = 1; i <= distance; i++) {
            time += timeForM;
         //if (i % 15 == 0) {
         //    waterRes += 12.5;
         //}
        }
        waterRes = Math.floor((distance/15.0)*12.5);
        time += waterRes;
        if (time < record) {
            System.out.printf(" Yes, he succeeded! The new world record is %.2f seconds.", time);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", time - record);
        }
    }
}