import java.util.Scanner;

public class Exam2017November05_4ExternalEvaluation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        double poor = 0.0,
                satisfactory = 0.0,
                good = 0.0,
                veryGood = 0.0,
                excellent = 0.0;

        for (int i = 0; i < students; i++) {
            double mark = Double.parseDouble(scanner.nextLine());
            if (mark < 22.5) {
                poor += 1;
            } else if (mark < 40.5) {
                satisfactory += 1;
            } else if (mark < 58.5) {
                good += 1;
            } else if (mark < 76.5) {
                veryGood += 1;
            } else {
                excellent += 1;
            }
        }

        poor = (poor / students * 1.0) * 100;
        satisfactory = (satisfactory / students * 1.0) * 100;
        good = (good / students * 1.0) * 100;
        veryGood = (veryGood / students * 1.0) * 100;
        excellent = (excellent / students * 1.0) * 100;

        System.out.printf("%.2f%% poor marks\n%.2f%% satisfactory marks\n%.2f%% good marks\n%.2f%% very good marks\n%.2f%% excellent marks", poor, satisfactory, good, veryGood, excellent);
    }
}