import java.text.DecimalFormat;
import java.util.Scanner;

public class Exam2016April24_02SleepyCatTom {
    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        int holidays = Integer.parseInt(br.nextLine());
        int workDays = 365 - holidays,
                game = holidays * 127 + workDays * 63;
        if (game > 30000) {
            double h = (game - 30000) / 60,
                    m = (game - 30000) % 60;
            System.out.printf("Tom will run away\n"
                    + "%.0f hours and %.0f minutes more for play", h, m);
        } else {
            double h = (30000 - game) / 60,
                    m = (30000 - game) % 60;
            System.out.printf("Tom sleeps well\n"
                    + "%.0f hours and %.0f minutes less for play", h, m);
        }
    }
}

