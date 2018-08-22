import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March19Evening_03TruckDriver {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(
                System.in));

        String season = b.readLine().toLowerCase();
        double km = Double.parseDouble(b.readLine());
        double total = 0.0;


        if (km > 10000 && km <= 20000) {
            total = (km * 1.45) - ((km * 1.45) * 0.1);
            System.out.printf("%.2f", total * 4);
            return;
        } else {
            switch (season) {
                case "spring":
                    if (km <= 5000) {
                        total = (km * 0.75) - ((km * 0.75) * 0.1);
                    } else if (km <= 10000) {
                        total = (km * 0.95) - ((km * 0.95) * 0.1);
                    }
                    break;
                case "autumn":
                    if (km <= 5000) {
                        total = (km * 0.75) - ((km * 0.75) * 0.1);
                    } else if (km <= 10000) {
                        total = (km * 0.95) - ((km * 0.95) * 0.1);
                    }
                    break;
                case "summer":
                    if (km <= 5000) {
                        total = (km * 0.90) - ((km * 0.90) * 0.1);
                    } else if (km <= 10000) {
                        total = (km * 1.10) - ((km * 1.10) * 0.1);
                    }
                    break;
                case "winter":
                    if (km <= 5000) {
                        total = (km * 1.05) - ((km * 1.05) * 0.1);
                    } else if (km <= 10000) {
                        total = (km * 1.25) - ((km * 1.25) * 0.1);
                    }
                    break;
            }
        }
        System.out.printf("%.2f", total * 4);//Забравих месеците, затова умножавам накрая!
    }
}