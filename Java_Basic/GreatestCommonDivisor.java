import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreatestCommonDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        while(b != 0){
            int oldB = b;
            b = a % b;
            a = oldB;
        }
            System.out.println(a);
        }
    }

//   function gcd(a, b)
// while a ≠ b
//         if a > b
//         a := a – b
//         else
//         b := b – a
//         return a