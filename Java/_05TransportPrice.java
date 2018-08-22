import java.util.Scanner;

public class _05TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distance = Double.parseDouble(scanner.nextLine());
        String dayTime = scanner.nextLine();
        double best = 0;

        if (distance<20){
            if (dayTime.equals("day")) {
                best = distance * 0.79 + 0.7;
            } else {
                best = distance * 0.9 + 0.7;
            }
        }else if (distance>=20){
            best = distance*0.09;
        }else if(distance>=100){
            best = distance*0.06;
        }
            System.out.printf("%.2f",best);

    }
}

