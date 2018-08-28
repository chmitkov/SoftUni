import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class _4CountCharacterTypes {
    public static void main(String[] args) {

        Character[] vowels = new Character[]{'a', 'i', 'e', 'o', 'u'};
        Character[] punctuationMarks = new Character[]{'.', ',', '!', '?'};
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('v', 0);
        dict.put('c', 0);
        dict.put('p', 0);

        try (BufferedReader br =
                     Files.newBufferedReader(
                             Paths.get("C:\\TestFolder\\input.txt"));
             PrintWriter out =
                     new PrintWriter(new FileWriter("C:\\TestFolder\\output.txt"));
        ) {
            String line = br.readLine();

            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    if (currentChar != 32) {
                        if (Arrays.asList(vowels).contains(currentChar)) {
                            dict.put('v',dict.get('v')+1);
                        }else if (Arrays.asList(punctuationMarks).contains(currentChar)){
                            dict.put('p',dict.get('p')+1);
                        }else{
                            dict.put('c',dict.get('c')+1);
                        }
                    }
                }
                line = br.readLine();
            }

            out.printf("Vowels: %d%n",dict.get('v'));
            out.printf("Consonants: %d%n",dict.get('c'));
            out.printf("Punctuation: %d%n",dict.get('p'));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
