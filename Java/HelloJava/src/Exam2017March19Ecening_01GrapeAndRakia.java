import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March19Ecening_01GrapeAndRakia {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(
                System.in));

        double s = Double.parseDouble(b.readLine()),
                kg = Double.parseDouble(b.readLine()),
                brak = Double.parseDouble(b.readLine());

        double grape = s * kg - brak,
                grapeForSale = (grape * 0.55) * 1.50,
                rakia = grape * 0.45 / 7.5,
                rakiaForSale = rakia * 9.8;
        System.out.printf("%.2f\n%.2f", rakiaForSale, grapeForSale);

    }
}