package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {

    private static final double INIT_HEALTH = 100D;
    private static final boolean INIT_DEFENSIVE_MODE = true;
    private static final double INIT_ATTACK_POINTS_MOD = 40.0;
    private static final double INIT_DEF_POINTS_MOD = 30.0;


    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints - INIT_ATTACK_POINTS_MOD,
                defensePoints + INIT_DEF_POINTS_MOD, INIT_HEALTH);
        this.defenseMode = INIT_DEFENSIVE_MODE;
    }

    @Override
    public boolean getDefenseMode() {
        return defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        this.defenseMode = !defenseMode;
    }


    @Override
    public double getAttackPoints() {
        return defenseMode
                ? super.getAttackPoints()
                : super.getAttackPoints() + INIT_ATTACK_POINTS_MOD;
    }

    @Override
    public double getDefensePoints() {
        return defenseMode
                ? super.getDefensePoints()
                : super.getDefensePoints() - INIT_DEF_POINTS_MOD;
    }

    @Override
    public String toString() {
        String modeIsOn = this.defenseMode ? "ON" : "OFF";
        String str = this.getTargets().isEmpty()
                ? "None" : String.join(", ", this.getTargets()) ;
        return String.format("- %s\n" +
                        "*Type: Tank\n" +
                        "*Health: %.2f\n" +
                        "*Attack: %.2f\n" +
                        "*Defence: %.2f\n" +
                        "*Targets: %s\n" +
                        "*Defence Mode(%s)",
                this.getName(),
                this.getHealthPoints(),
                this.getAttackPoints(),
                this.getDefensePoints(),
                str
                ,modeIsOn);
    }
}
