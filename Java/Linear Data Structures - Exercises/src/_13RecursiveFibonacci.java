import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13RecursiveFibonacci {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int result = fib(num+1);
        System.out.println(result);
    }

    public static int fib(int n) {

        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
