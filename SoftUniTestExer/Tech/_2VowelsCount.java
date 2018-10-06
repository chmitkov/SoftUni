import java.util.Arrays;
import java.util.Scanner;

public class _2VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        countVowelsInStr(str);
    }

    private static void countVowelsInStr(String str) {
        char [] vowels = {'a','i','u','e','o','A','I','U','E','O'};
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            for(char ch : vowels){
                if (ch==str.charAt(i)){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
