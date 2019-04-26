package callofduty.missions;

public class HuntMission extends BaseMission {
    public HuntMission(String id, Double rating, Double bounty) {

        super(id, rating * 1.5, bounty * 2);
    }
}
