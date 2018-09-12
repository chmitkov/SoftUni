package firstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Player> firstTeamPlayers;
    private List<Player> secondTeamPlayers;

    public Team(String name) {
        this.name = name;
        this.firstTeamPlayers = new ArrayList<>();
        this.secondTeamPlayers = new ArrayList<>();
    }

    public List<Player> getFirstTeamPlayers() {
        return Collections.unmodifiableList(this.firstTeamPlayers);
    }

    public List<Player> getSecondTeamPlayers() {
        return Collections.unmodifiableList(this.secondTeamPlayers);
    }

    public void addPlayer(Player player) {
        if (player.getAge() < 40) {
            this.firstTeamPlayers.add(player);
        } else {
            this.secondTeamPlayers.add(player);
        }
    }

    @Override
    public String toString() {
        return String.format("First team have %d players%nReserve team have %d players"
                , this.firstTeamPlayers.size(), this.secondTeamPlayers.size());
    }

}
