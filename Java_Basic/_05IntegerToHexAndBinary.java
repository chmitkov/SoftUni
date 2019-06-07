import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _05IntegerToHexAndBinary {
    public static void main (String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(Integer.toHexString(num).toUpperCase());
        System.out.println(Integer.toBinaryString(num));
    }
}
