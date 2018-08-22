import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March18_02WorkHours {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int needH = Integer.parseInt(b.readLine()),
                workers = Integer.parseInt(b.readLine()),
                days = Integer.parseInt(b.readLine());

        int allH = days * workers * 8;
        if (allH >= needH) {
            System.out.printf("%d hours left", allH - needH);
        } else {
            System.out.printf("%d overtime\nPenalties: %d"
                    , needH - allH, (needH - allH) * days);
        }
    }
}