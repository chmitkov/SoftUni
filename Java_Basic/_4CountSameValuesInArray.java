import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _4CountSameValuesInArray {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Integer> dict = new HashMap<>();
        String [] nums = br.readLine().split(" ");
        for(String num : nums){
            if (!dict.containsKey(num)){
                dict.put(num,1);
            }else {
                dict.put(num,dict.get(num)+1);
            }
        }
        dict.entrySet()
                .forEach(kvp->
                        System.out.printf("%s - %d times%n",kvp.getKey(),kvp.getValue()));
    }
}
