package callofduty.agents;

import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;
import callofduty.missions.BaseMission;

import java.util.List;

public class MasterAgent extends BaseAgent implements BountyAgent {

    private Double bounty;

    public MasterAgent(String id, String name, Double rating) {
        super(id, name, rating);
        this.bounty = 0D;
    }


    @Override
    public void acceptMission(Mission mission) {
        super.acceptMission((BaseMission) mission);
    }

    @Override
    public void completeMissions() {
        for (BaseMission mission : super.getAllMissions()) {
            super.setRating(super.getRating() + mission.getRating());
            this.bounty+=mission.getBounty();
            mission.changeStatus();
        }
        super.addCompleteMissions(super.getAllMissions());
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    public void addOldMissions(List<BaseMission> missions) {
        super.addCompleteMissions(missions);
    }

    @Override
    public String printStatus() {
        return String.format("Master Agent - %s\n" +
                        "Personal Code: %s\n" +
                        "Assigned Missions: %d\n" +
                        "Completed Missions: %d\n" +
                        "Rating: %.2f\n" +
                        "Bounty Earned: $%.2f",
                super.getName(), super.getId(), super.getAllMissions().size(),
                super.getCompleteMissions().size(), super.getRating(),
                this.bounty);
    }
}
