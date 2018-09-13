package footballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> map = new HashMap<>();
        String line = br.readLine();

        while (!"END".equals(line)) {
            String[] commands = line.split(";");
            String action = commands[0];

            Team currTeam = null;
            switch (action) {
                case "Team":
                    try {
                        currTeam = new Team(commands[1]);
                        map.put(commands[1], currTeam);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "Add":
                    String teamName = commands[1];
                    String playerName = commands[2];
                    if (!map.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.", teamName);
                    } else {
                        int playerEndurance = Integer.parseInt(commands[3]);
                        int playerSprint = Integer.parseInt(commands[4]);
                        int playerDribble = Integer.parseInt(commands[5]);
                        int playerPassing = Integer.parseInt(commands[6]);
                        int playerShooting = Integer.parseInt(commands[7]);
                        try {
                            Stats currStats = new Stats(playerEndurance, playerSprint, playerDribble
                                    , playerPassing, playerShooting);
                            Player currPlayer = new Player(playerName, currStats);
                            map.get(commands[1]).addPlayer(currPlayer);
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case "Remove":
                    String teamFromRemove = commands[1];
                    String playerForRemove = commands[2];
                    Player player = map.get(teamFromRemove)
                            .getPlayerList()
                            .stream()
                            .filter(x -> playerForRemove.equals(x.getName()))
                            .findFirst().orElse(null);

                    if (player == null) {
                        System.out.printf("Player %s is not in %s team.\n",
                                playerForRemove, teamFromRemove);
                    } else {
                        try {
                            map.get(teamFromRemove).removePlayer(player);
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case "Rating":
                    String teamToShowStats = commands[1];
                    if (!map.containsKey(teamToShowStats)) {
                        System.out.printf("Team %s does not exist.", teamToShowStats);
                    } else {
                        System.out.printf("%s - %d", teamToShowStats,
                                Math.round(map.get(teamToShowStats).getTeamRating()));
                    }
                    break;
            }
            line = br.readLine();
        }
    }
}
