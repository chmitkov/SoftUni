import java.util.Scanner;

public class ExamMarch2016_2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int km = Integer.parseInt(scanner.nextLine());
        double	taxiD = km*0.79+0.70,
                taxiN = km*0.90+0.70,
                buss = km*0.09,
                train = km*0.06;
        String time = scanner.nextLine();

        if (km < 20) {
            if ("day".equalsIgnoreCase(time)) {
                System.out.println(taxiD);
            }else {
                System.out.println(taxiN);
            }
        }else if (km < 100){
            if ("day".equalsIgnoreCase(time)) {
                System.out.println(Math.min(taxiD, buss));
            }else {
                System.out.println(Math.min(taxiN,buss));
            }
        }else {
            if ("day".equalsIgnoreCase(time)) {
                System.out.println(Math.min((Math.min(taxiD, buss)),train));
            }else {
                System.out.println(Math.min((Math.min(taxiD, buss)),train));
            }

        }
    }


    }


