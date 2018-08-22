import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Exam2017March19Morning_01HousePainting{
    public static void main(String[] args) throws IOException{
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        double x = Double.parseDouble(b.readLine()),
                y = Double.parseDouble(b.readLine()),
                h = Double.parseDouble(b.readLine());

        double frontAndBack = (x * x) + (x * x) - 2 * 1.2,
                sides = (x * y - 1.5 * 1.5) * 2,
                frontAndBackRoof = ((x * h) / 2) * 2,
                sidesRoof = (x * y) * 2;

        double green = (frontAndBack + sides) / 3.4,
                red = (frontAndBackRoof + sidesRoof) / 4.3;

        System.out.printf("%.2f\n%.2f", green, red);
    }
}