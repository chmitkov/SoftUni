package callofduty.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.missions.BaseMission;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAgent implements Agent {

    private String id;
    private String name;
    private Double rating;
    private List<BaseMission> missions;
    private List<BaseMission> completeMissions;

    protected BaseAgent(String id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.missions = new ArrayList<>();
        this.completeMissions = new ArrayList<>();
    }


    public void acceptMission(BaseMission mission) {

        this.missions.add(mission);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<BaseMission> getCompleteMissions() {
        return this.completeMissions;
    }

    protected void addCompleteMissions(List<BaseMission> missions) {
        this.completeMissions.addAll(missions);
        this.missions = new ArrayList<>();
    }

    protected List<BaseMission> getAllMissions() {
        return this.missions;
    }

    public abstract void completeMissions();


    public String printStatus() {
        return String.format("Novice Agent - %s\n" +
                        "Personal Code: %s\n" +
                        "Assigned Missions: %d\n" +
                        "Completed Missions: %d\n" +
                        "Rating: %.2f",
                this.name, this.id, this.missions.size(),
                this.completeMissions.size(), this.rating);
    }

}
