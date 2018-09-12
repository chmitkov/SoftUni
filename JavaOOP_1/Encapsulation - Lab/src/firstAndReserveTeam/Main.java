package firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Player>  players = new ArrayList<>();
        Team ourTeam = new Team("Levski");
        int numberOfPlayers = Integer.parseInt(br.readLine());

        while (numberOfPlayers-- > 0) {
            String[] commands = br.readLine().split("\\s+");
            players.add(new Player(commands[0],
                    commands[1],
                    Integer.parseInt(commands[2]),
                    Double.parseDouble(commands[3])));
        }

        players.forEach(ourTeam::addPlayer);

        System.out.println(ourTeam.toString());
    }
}
