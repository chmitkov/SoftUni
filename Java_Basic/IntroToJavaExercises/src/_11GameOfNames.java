import java.util.Scanner;

public class _11GameOfNames {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int best = Integer.MIN_VALUE;
        String bestName = "";
        while (n-->0){
            String name = scanner.nextLine();
            int point = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < name.length(); i++) {
                int current = (int) name.charAt(i);
               if  (current%2==0){
                   point+=current;
               }else {
                   point-=current;
               }
            }
            if (point>best){
                best = point;
                bestName = name;
            }
        }
        System.out.printf("The winner is %s - %d points",bestName,best);
    }
}
