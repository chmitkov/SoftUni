import java.util.Scanner;

public class _3LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int x1 = Integer.parseInt(scanner.nextLine());
       int y1 = Integer.parseInt(scanner.nextLine());
       int x2 = Integer.parseInt(scanner.nextLine());
       int y2 = Integer.parseInt(scanner.nextLine());
       int x3 = Integer.parseInt(scanner.nextLine());
       int y3 = Integer.parseInt(scanner.nextLine());
       int x4 = Integer.parseInt(scanner.nextLine());
       int y4 = Integer.parseInt(scanner.nextLine());


        if (isLineIsLonger(x1, y1, x2, y2, x3, y3, x4, y4)) {
            boolean first = true;
            if (Math.sqrt(x1 * x1 + y1 * y1) > Math.sqrt(x2 * x2 + y2 * y2))
                first = false;
            if (first) {
                System.out.printf("(%d, %d)(%d, %d)",x1,y1,x2,y2);
            } else{
                System.out.printf("(%d, %d)(%d, %d)",x2,y2,x1,y1);
            }
        } else {
            boolean first = true;
            if (Math.sqrt(x3 * x3 + y3 * y3) > Math.sqrt(x4 * x4 + y4 * y4))
                first = false;
            if (first){
                System.out.printf("(%d, %d)(%d, %d)",x3,y3,x4,y4);
            }else{
                System.out.printf("(%d, %d)(%d, %d)",x4,y4,x3,y3);
            }
        }
    }

    private static boolean isLineIsLonger(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double line1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double line2 = Math.sqrt((x3 - x4) * (x3 - x4) + (y3 - y4) * (y3 - y4));

        return line1 > line2;
    }
}

