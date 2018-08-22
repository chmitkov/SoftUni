import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class _04VowelOrDigit {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         char  ch = br.readLine().charAt(0);
       if (Character.isDigit(ch)){
           System.out.println("digit");
       }else if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'u' || ch == 'i'){
           System.out.println("vowel");
       }else {
           System.out.println("other");
       }
    }
}
