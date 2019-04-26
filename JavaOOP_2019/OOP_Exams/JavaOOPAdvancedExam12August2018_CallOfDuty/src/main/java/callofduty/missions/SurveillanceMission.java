package callofduty.missions;

public class SurveillanceMission extends BaseMission {


    public SurveillanceMission(String id, Double rating, Double bounty) {

        super(id, rating * 0.25, bounty * 1.5);
    }
}
