package footballTeamGenerator;

public class Player {
    private String name;
    private Stats stats;

    public Player(String name, Stats stats){
        setName(name);
        this.stats = stats;
    }

    public Stats getStats() {
        return this.stats;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }


}
