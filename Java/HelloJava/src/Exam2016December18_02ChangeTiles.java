import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2016December18_02ChangeTiles {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        double money = Double.parseDouble(b.readLine()),
                width = Double.parseDouble(b.readLine()),
                lenght = Double.parseDouble(b.readLine()),
                triangleSide = Double.parseDouble(b.readLine()),
                triangleH = Double.parseDouble(b.readLine()),
                tilesPrice = Double.parseDouble(b.readLine()),
                moneyForWorker = Double.parseDouble(b.readLine());

        double bathS = width * lenght,
                tileS = (triangleSide * triangleH) / 2,
                needT = Math.ceil(bathS / tileS) + 5,
                needM = needT * tilesPrice + moneyForWorker;

        if (money >= needM) {
            System.out.printf("%.2f lv left", money - needM);
        } else {
            System.out.printf("You'll need %.2f lv more", needM - money);
        }
    }
}