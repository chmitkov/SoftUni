import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March18_01DogHouse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        double a = Double.parseDouble(br.readLine()),
                b = Double.parseDouble(br.readLine());

        double frontAndBack = ((a / 2) * (a / 2) + ((a / 2) * (b - a / 2)) / 2) * 2 - (a / 5) * (a / 5),
                sides = (a * (a / 2)) * 2,
                roof = sides,
                green = (frontAndBack + sides) / 3,
                red = roof / 5;

        System.out.printf("%.2f\n%.2f", green, red);

    }
}