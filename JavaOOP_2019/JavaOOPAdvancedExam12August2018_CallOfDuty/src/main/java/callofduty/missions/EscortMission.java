package callofduty.missions;

public class EscortMission extends BaseMission {


    public EscortMission(String id, Double rating, Double bounty) {
        super(id, rating * 0.75, bounty * 1.25);
    }
}
