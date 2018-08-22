import java.util.Scanner;

public class Exam2018January07_2Airplane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int flightH= Integer.parseInt(scanner.nextLine()),
                flightM = Integer.parseInt(scanner.nextLine()),
                flightTime = Integer.parseInt(scanner.nextLine());

        int allTime = flightH*60+flightM+flightTime;

        int h = allTime/60,
                m = allTime%60;
        if (h>=24){
            h-=24;
        }
        System.out.printf("%dh %dm",h,m);
    }
}