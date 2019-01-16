package rpg_lab;

public interface Target {
    boolean isDead();
    int giveExperience();
    void takeAttack(int attackPoints);
    int getHealth();
    Weapon getRandomWeapon();
}
