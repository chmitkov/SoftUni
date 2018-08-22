import java.math.BigInteger;
import java.util.Scanner;

public class _07ProductOfNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();
        BigInteger result = BigInteger.ONE;
        for (int i = startNum; i <=endNum ; i++) {

            result = result.multiply(new BigInteger(""+i));
        }
        System.out.printf("product[%d..%d] = %d",startNum,endNum,result);
    }
}
