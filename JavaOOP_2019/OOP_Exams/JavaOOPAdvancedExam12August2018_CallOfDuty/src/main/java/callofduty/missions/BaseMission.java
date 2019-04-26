package callofduty.missions;

import callofduty.interfaces.Mission;

public abstract class BaseMission implements Mission {

    private String id;
    private Double rating;
    private Double bounty;
    private boolean isCompleted;


    protected BaseMission(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
        this.isCompleted = false;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    public boolean getStatus() {
        return this.isCompleted;
    }

    public String printStatus() {
        return String.format(" Mission - %s\n" +
                        "Status: %s\n" +
                        "Rating: %.2f\n" +
                        "Bounty: %.2f",
                this.id, isCompleted ? "Completed" : "Open",
                this.rating, this.bounty
                );
    }

    public void changeStatus() {
        this.isCompleted = true;
    }
}
