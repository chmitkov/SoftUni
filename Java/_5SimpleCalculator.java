import java.util.ArrayDeque;
import java.util.Scanner;

public class _5SimpleCalculator {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        String [] nums = scanner.nextLine().split(" ");
        ArrayDeque<String> calc =  new ArrayDeque<>();
        for (String num : nums) {
            calc.add(num);
        }
        int sum=0;
        while (!calc.isEmpty()){
            String current = calc.pop();
            if ("-".equals(current)){
                sum-=Integer.parseInt(calc.pop());
            }else if ( "+".equals(current)){
                sum+=Integer.parseInt(calc.pop());
            }
            else{
                sum+=Integer.parseInt(current);
            }
        }
        System.out.println(sum);
    }
}
