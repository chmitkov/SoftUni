import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder(br.readLine());
        String pattern = br.readLine();

        while (text.toString().contains(pattern)){
            int firstIndex = text.indexOf(pattern);
            String current = text.substring(firstIndex+1);
            int secondIndex = current.contains(pattern)?
                    text.lastIndexOf(pattern):
                    -1;
            if (secondIndex!=-1){
                text = text.delete(secondIndex,secondIndex+pattern.length());
                text = text.delete(firstIndex,firstIndex+pattern.length());
                int patternMidIndex = pattern.length()/2;
                StringBuilder sb = new StringBuilder(pattern);
                pattern = sb.deleteCharAt(patternMidIndex).toString();
                System.out.println("Shaked it.");
            }else{
                break;
            }

        }
        System.out.println("No shake.");
        System.out.println(text);

    }
}
