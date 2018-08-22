import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2016April24_01TileRepair {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(b.readLine());
        double w = Double.parseDouble(b.readLine());
        double l = Double.parseDouble(b.readLine());
        int m = Integer.parseInt(b.readLine());
        int o = Integer.parseInt(b.readLine());

        double square = Math.pow(n, 2),
                tile = w * l,
                bench = m * o;
        square = square - bench;
        double needTile = square * 1.0 / tile,
                needTime = needTile * 0.2;

        System.out.printf("%.2f\n%.2f", needTile, needTime);
    }
}
