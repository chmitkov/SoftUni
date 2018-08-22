import java.util.ArrayList;
import java.util.Scanner;

public class _2SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("[ \\[\\],;\\\\:.!/()\"']+");
        ArrayList<String > lower = new ArrayList<>();
        ArrayList<String > mix = new ArrayList<>();
        ArrayList<String > upper = new ArrayList<>();

        for (String s : text) {
            if (isMix(s)){
                mix.add(s);
            }
            else if (s.equals(s.toLowerCase())){
                lower.add(s);
            }else if (s.equals(s.toUpperCase())){
                upper.add(s);
            }
        }
        System.out.println("Lower-case: "+String.join(", ",lower));
        System.out.println("Mixed-case: "+String.join(", ",mix));
        System.out.println("Upper-case: "+String.join(", ",upper));
    }

    private static boolean isMix(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
