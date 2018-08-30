import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = br.readLine().split("\\s+");

        double sum = 0d;

        for (String word : words) {
            sum += totalSumOfWord(word);
        }
        System.out.printf("%.2f",sum);
    }

    private static double totalSumOfWord(String word) {
        double total = 0;
        char firstChar = word.charAt(0);
        int positionOfFirstChar = Character.isUpperCase(firstChar) ?
                firstChar - 64 : firstChar - 96;
        char secondChar = word.charAt(word.length() - 1);
        int positionOfSecondChar = Character.isUpperCase(secondChar) ?
                secondChar - 64 : secondChar - 96;
        int num = Integer.parseInt(word.substring(1, word.length() - 1));

        if (Character.isUpperCase(firstChar)) {
            total = num*1.0/positionOfFirstChar;
        } else {
            total = num*positionOfFirstChar;
        }
        if (Character.isUpperCase(secondChar)){
            total -= positionOfSecondChar;
        }else {
            total+=positionOfSecondChar;
        }
        return total;
    }
}
