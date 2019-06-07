import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March19Morning_04TrainersSalary {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(b.readLine()),
                jelevH = 0,
                royalH = 0,
                roliH = 0,
                trofonH = 0,
                sinoH = 0,
                othersH = 0;
        double budget = Double.parseDouble(b.readLine());
        for (int i = 0; i < n; i++) {
            String name = b.readLine().toLowerCase();
            switch (name) {
                case "jelev":
                    jelevH++;
                    break;
                case "royal":
                    royalH++;
                    break;
                case "roli":
                    roliH++;
                    break;
                case "trofon":
                    trofonH++;
                    break;
                case "sino":
                    sinoH++;
                    break;
                default:
                    othersH++;
                    break;
            }
        }

        double hour = budget / n * 1.0;

        System.out.printf("Jelev salary: %.2f lv\nRoYaL salary: %.2f lv\nRoli salary: %.2f lv\n" +
                        "Trofon salary: %.2f lv\nSino salary: %.2f lv\nOthers salary: %.2f lv"
                , jelevH * hour, royalH * hour, roliH * hour, trofonH * hour, sinoH * hour, othersH * hour);

    }
}