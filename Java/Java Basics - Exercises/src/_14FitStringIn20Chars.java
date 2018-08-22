import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14FitStringIn20Chars {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if (str.length() < 20){
            padRight( str,'*');
        }else if (str.length()>20){
            str = str.substring(0,20);
            System.out.println(str);
        }else {
            System.out.println(str);
        }
    }

    private static void padRight(String str, char c) {
        for (int i = 0; i < 20; i++) {
            if (i<str.length()){
                System.out.print(str.charAt(i));
            }else{
                System.out.print(c);
            }
        }
    }
}
