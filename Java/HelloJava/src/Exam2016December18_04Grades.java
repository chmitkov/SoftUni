import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2016December18_04Grades {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int students = Integer.parseInt(b.readLine());
        int f = 0, u4 = 0, u5 = 0, top = 0;
        double average = 0.0;

        for (int i = 0; i < students; i++) {
            double grade = Double.parseDouble(b.readLine());
            average += grade;
            if (grade < 3) {
                f++;
            } else if (grade < 4) {
                u4++;
            } else if (grade < 5) {
                u5++;
            } else {
                top++;
            }
        }
        average /= students;
        double topP = top * 1.0 / students * 100,
                u5P = u5 * 1.0 / students * 100,
                u4P = u4 * 1.0 / students * 100,
                fP = f * 1.0 / students * 100;
        System.out.printf("Top students: %.2f%%\nBetween 4.00 and 4.99: %.2f%%\n" +
                "Between 3.00 and 3.99: %.2f%%\nFail: %.2f%%\nAverage: %.2f", topP, u5P, u4P, fP, average);

    }
}