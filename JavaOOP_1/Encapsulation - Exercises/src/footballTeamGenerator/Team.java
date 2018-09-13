package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> playerList;

    public Team(String name) {
        setName(name);
        this.playerList = new ArrayList<>();
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getTeamRating() {
        double result = 0d;
        for (Player player : playerList) {
            result += player.getStats().getOverallSkill();
        }
        return result / (this.playerList.size() * 1.0);
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    public void removePlayer(Player player) {
        if (!this.playerList.contains(player)) {
            throw new IllegalArgumentException(String.format(
                    "Player %s is not in %s team.",
                    player.getName(), this.name));
        }
        this.playerList.remove(player);
    }
}
