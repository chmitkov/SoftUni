package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {

    private static final double INIT_HEALTH = 200D;
    private static final boolean INIT_AGGRESSIVE_MODE = true;
    private static final double INIT_ATTACK_POINTS_MOD = 50.0;
    private static final double INIT_DEF_POINTS_MOD = 25.0;


    private boolean attackMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints + INIT_ATTACK_POINTS_MOD,
                defensePoints - INIT_DEF_POINTS_MOD, INIT_HEALTH);
        this.attackMode = INIT_AGGRESSIVE_MODE;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.attackMode;
    }

    @Override
    public void toggleAggressiveMode() {
        this.attackMode = !this.attackMode;
    }

    @Override
    public double getAttackPoints() {
        return attackMode
                ? super.getAttackPoints()
                : super.getAttackPoints() - INIT_ATTACK_POINTS_MOD;
    }

    @Override
    public double getDefensePoints() {
        return attackMode
                ? super.getDefensePoints()
                : super.getDefensePoints() + INIT_DEF_POINTS_MOD;
    }

    @Override
    public String toString() {

        String modeIsOn = this.attackMode ? "ON" : "OFF";
        String str = this.getTargets().isEmpty()
                ? "None" : String.join(", ", this.getTargets()) ;
        return String.format("- %s\n" +
                        "*Type: Fighter\n" +
                        "*Health: %.2f\n" +
                        "*Attack: %.2f\n" +
                        "*Defence: %.2f\n" +
                        "*Targets: %s\n" +
                        "*Aggressive Mode(%s)",
                this.getName(),
                this.getHealthPoints(),
                this.getAttackPoints(),
                this.getDefensePoints(),
                str, modeIsOn);
    }
}
