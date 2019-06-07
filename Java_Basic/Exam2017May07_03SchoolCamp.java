import java.util.Scanner;

public class Exam2017May07_03SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine().toLowerCase(),
                type = scanner.nextLine().toLowerCase();
        int studentsNum = Integer.parseInt(scanner.nextLine()),
                nightsNum = Integer.parseInt(scanner.nextLine());
        String sport = "";
        double total = 0.0;

        switch (season) {
            case ("winter"):
                if ("girls".equals(type)) {
                    total = (nightsNum * studentsNum) * 9.60;
                    sport = "Gymnastics";
                } else if ("boys".equals(type)){
                total = (nightsNum * studentsNum) * 9.60;
                sport = "Judo";
            }else{
                total = (nightsNum * studentsNum) * 10.0;
                sport = "Ski";
            }
            break;
            case ("spring"):
                if ("girls".equals(type)) {
                    total = (nightsNum * studentsNum) * 7.20;
                    sport = "Athletics";
                } else if ("boys".equals(type)){
                total = (nightsNum * studentsNum) * 7.20;
                sport = "Tennis";
            }else{
                total = (nightsNum * studentsNum) * 9.5;
                sport = "Cycling";
            }
            break;
            case ("summer"):
                if ("girls".equals(type)) {
                    total = (nightsNum * studentsNum) * 15;
                    sport = "Volleyball";
                } else if ("boys".equals(type)){
                total = (nightsNum * studentsNum) * 15;
                sport = "Football";
            }else{
                total = (nightsNum * studentsNum) * 20;
                sport = "Swimming";
            }
            break;
        }
        if (studentsNum >= 50) {
            total -= total * 0.5;
        } else if (studentsNum >= 20) {
            total -= total * 0.15;
        } else if (studentsNum >= 10) {
            total -= total * 0.05;
        } else {
            total -= total * 0.00;
        }
        System.out.printf("%s %.2f", sport, total);
    }
}