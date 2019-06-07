import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2016December18_03Fwolers {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int hr = Integer.parseInt(b.readLine()),
                ro = Integer.parseInt(b.readLine()),
                la = Integer.parseInt(b.readLine()),
                laNum = la,
                roNum = ro,
                hrNum = hr;
        String season = b.readLine().toLowerCase(),
                day = b.readLine().toLowerCase();
        double total = 0.0,
                hri = hr,
                roz = ro,
                lal = la;


        if ("spring".equals(season) || "summer".equals(season)) {
            hri *= 2.0;
            roz *= 4.10;
            lal *= 2.50;
            total = hri + roz + lal;
            if ("y".equals(day)) {
                total += total * 0.15;
            }
            if ("spring".equals(season) && laNum > 7) {
                total -= total * 0.05;
            }
            if (hrNum + roNum + laNum > 20) {
                total -= total * 0.2;
            }
        } else {
            hri *= 3.75;
            roz *= 4.50;
            lal *= 4.15;
            total = hri + roz + lal;
            if ("y".equals(day)) {
                total += total * 0.15;
            }
            if ("winter".equals(season) && roNum >= 10) {
                total -= total * 0.1;
            }
            if (hrNum + roNum + laNum > 20) {
                total -= total * 0.2;
            }
        }
        System.out.printf("%.2f", total + 2);
    }
}