package callofduty.agents;

import callofduty.interfaces.Mission;
import callofduty.missions.BaseMission;

public class NoviceAgent extends BaseAgent {

    public NoviceAgent(String id, String name, Double rating) {
        super(id, name, rating);
    }

    @Override
    public void acceptMission(Mission mission) {
        super.acceptMission((BaseMission)mission);
    }

    @Override
    public void completeMissions() {
        for (BaseMission mission : super.getAllMissions()) {
            super.setRating(super.getRating() + mission.getRating());
            mission.changeStatus();
        }
        super.addCompleteMissions(super.getAllMissions());
    }
}
