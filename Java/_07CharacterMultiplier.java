import java.util.Scanner;

public class _07CharacterMultiplier {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();
        long sum = 0;
        for (int i = 0; i < Math.max(str1.length(),str2.length()); i++) {
            int currSum = 0;
            if (i>=str1.length()){
                currSum = str2.charAt(i);
            }else if (i>=str2.length()){
                currSum = str1.charAt(i);
            }else{
                currSum = str1.charAt(i)*str2.charAt(i);
            }
            sum+=currSum;
        }
        System.out.println(sum);
    }
}
