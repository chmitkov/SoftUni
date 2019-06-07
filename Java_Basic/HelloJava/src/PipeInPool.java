import java.util.Scanner;

public class PipeInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poolV = Integer.parseInt(scanner.nextLine()),
                p1 = Integer.parseInt(scanner.nextLine()),
                p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine()),
                allPipeForT =  p1*h+p2*h,
                poolFullPercent = (allPipeForT*1.0/poolV)*100,
                poolFullLiters = allPipeForT*1.0,
                p1percent = ((p1*h)/allPipeForT)*100,
                p2percent = ((p2*h)/allPipeForT)*100,
                poolOverflows = allPipeForT - poolV;

        if (poolV >= allPipeForT){
            System.out.printf("The pool is %.0f%% full. Pipe 1: %.0f%%. Pipe 2: %.0f%%.", poolFullPercent, p1percent,p2percent);
        }else{
            System.out.printf("For %.1f hours the pool overflows with %.1f liters.",h,poolOverflows);
        }

    }
}
