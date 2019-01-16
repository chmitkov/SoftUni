package rpg_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dummy implements Target {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = new ArrayList<Weapon>() {{
            new Axe(AXE_ATTACK, AXE_DURABILITY);
            new Axe(AXE_ATTACK, AXE_DURABILITY);
            new Axe(AXE_ATTACK, AXE_DURABILITY);
        }};
    }

    public int getHealth() {
        return this.health;
    }

    public Weapon getRandomWeapon() {
        return this.possibleLoot.get(new Random().nextInt(this.possibleLoot.size()));
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
