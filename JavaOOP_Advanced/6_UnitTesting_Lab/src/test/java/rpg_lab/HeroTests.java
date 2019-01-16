package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {

    private static final String HERO_NAME = "Hero name";
    private static final int TARGET_RETURN_EXPERIENCE = 10;
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int ZERO = 0;

    private Hero hero;


    @Before
    public void createHero() {
        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        this.hero = new Hero(HERO_NAME, mockedWeapon);
    }


    @Test
    public void heroGetExpAfterAttack() {
        Assert.assertEquals(ZERO, this.hero.getExperience());
    }

    @Test
    public void heroAttack() {
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(TARGET_RETURN_EXPERIENCE);
        hero.attack(mockedTarget);
        Assert.assertEquals(TARGET_RETURN_EXPERIENCE, this.hero.getExperience());
    }

    @Test
    public void heroInventoryAddAfterAttack() {
        int heroInventorySizeBeforeAttack = this.hero.getInventory().size();

        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        Target mockedTarget = Mockito.mock(Dummy.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(TARGET_RETURN_EXPERIENCE);
        Mockito.when(mockedTarget.getRandomWeapon())
                .thenReturn(mockedWeapon);

        this.hero.attack(mockedTarget);
        Assert.assertEquals(++heroInventorySizeBeforeAttack,
                this.hero.getInventory().size());
    }

}
