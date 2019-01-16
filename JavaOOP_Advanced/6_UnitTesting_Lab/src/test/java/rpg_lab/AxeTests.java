package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int ZERO = 0;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void createAxeAndDummy() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void axeLosesDurabilityAfterAttack() {
        this.axe.attack(this.dummy);
        Assert.assertEquals(9, this.axe.getDurabilityPoints());

    }


    @Test(expected = IllegalStateException.class)
    public void attackWithBrokenWeapon() {
        this.axe = new Axe(AXE_ATTACK, ZERO);
        this.axe.attack(this.dummy);
    }
}
