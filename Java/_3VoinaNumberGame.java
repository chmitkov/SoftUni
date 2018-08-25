import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class _3VoinaNumberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<Integer> player1cards = (LinkedHashSet<Integer>) Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> player2cards = (LinkedHashSet<Integer>) Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int counter = 50;
        while (counter-- > 0) {
            if (player1cards.isEmpty() || player2cards.isEmpty()) {
                break;
            }
            int player1CurrentCard = player1cards.iterator().next();
            player1cards.remove(player1CurrentCard);
            int player2CurrentCard = player2cards.iterator().next();
            player2cards.remove(player2CurrentCard);
            if (player1CurrentCard > player2CurrentCard) {
                player1cards.add(player1CurrentCard);
                player1cards.add(player2CurrentCard);
            } else {
                player2cards.add(player1CurrentCard);
                player2cards.add(player2CurrentCard);
            }
        }

        if (player1cards.isEmpty() || player2cards.isEmpty()) {
            System.out.println(player1cards.isEmpty() ?
                    "Second player win!" :
                    "First player win!");
        } else {
            if (player1cards.size() == player2cards.size()){
                System.out.println("Draw!");
            }else{
                System.out.println(player1cards.size() < player2cards.size() ?
                        "Second player win!" :
                        "First player win!"
                );
            }

        }
    }
}
