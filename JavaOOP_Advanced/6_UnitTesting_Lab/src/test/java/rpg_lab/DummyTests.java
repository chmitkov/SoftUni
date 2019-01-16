package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TEN = 10;

    private Dummy dummy;

    @Before
    public void createDummy() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void losesHealthAfterTakeAttack() {
        this.dummy.takeAttack(TEN);

        Assert.assertEquals(ZERO, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void isThrowsExceptionIfDead() {
        this.dummy.takeAttack(TEN);
        this.dummy.takeAttack(ONE);
    }

    @Test
    public void deadDummyGiveExp() {
        this.dummy.takeAttack(TEN);
        Assert.assertEquals(DUMMY_EXPERIENCE, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveExp() {
        int exp = this.dummy.giveExperience();
    }

    @Test
    public void dropsRandomWeapon(){

    }
}
