import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String type = scanner.nextLine().toLowerCase();
        int r = Integer.parseInt(scanner.nextLine()),
                c = Integer.parseInt(scanner.nextLine()),
                all = r*c;
        double
                result = 0;

        switch (type){
            case "premiere":
                 result = all*12.00;
                 break;
            case"normal":
                result = all*7.50;
                break;
            case"discount":
                result = all*5;
                break;
            default:
                System.out.println("Error");
        }
        System.out.printf("%.02f leva",result);
    }
}
