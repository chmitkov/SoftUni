import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class p03_VoinaNumberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();

        Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstPlayerCards::add);

        Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondPlayerCards::add);


        for (int i = 0; i < 50; i++) {
            int firstCard = (int) firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstCard);
            int secondCard = (int) secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            } else if (secondCard > firstCard) {

                secondPlayerCards.add(firstCard);
                secondPlayerCards.add(secondCard);
            } else {
                firstPlayerCards.add(firstCard);
                secondPlayerCards.add(secondCard);
            }

            if (firstPlayerCards.isEmpty()) {
                System.out.println("Second player win!");
                return;
            } else if (secondPlayerCards.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
        }

        System.out.println("Draw!") ;
    }
}
