package rpg_lab;

public interface Weapon {
    void attack(Target target);
    int getDurabilityPoints();
    int getAttackPoints();
}
