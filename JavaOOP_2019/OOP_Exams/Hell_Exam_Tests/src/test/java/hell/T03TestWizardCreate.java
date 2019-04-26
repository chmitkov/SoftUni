package hell;

import hell.interfaces.Hero;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class T03TestWizardCreate {
    private static final String HERO_NAME = "HeroName";
    private static final String CLASS_ASSASSIN_NAME = "Wizard";
    private static final String WRONG_RESULT = "Wrong result from create Wizard!";
    private static final int BASE_HERO_STRENGTH = 25;
    private static final int BASE_HERO_AGILITY = 25;
    private static final int BASE_HERO_INTELLIGENCE = 100;
    private static final int BASE_HERO_HIT_POINTS = 100;
    private static final int BASE_HERO_DAMAGE = 250;

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> assassinClass = Classes.allClasses.values().stream()
                .filter(x -> x.getSimpleName().contains(CLASS_ASSASSIN_NAME))
                .findFirst()
                .orElse(null);

        Constructor<?> constructor = assassinClass
                .getDeclaredConstructor(String.class);

        constructor.setAccessible(true);

        Hero wizard = (Hero) constructor.newInstance(HERO_NAME);

        Assert.assertEquals(WRONG_RESULT, wizard.getName(), HERO_NAME);
        Assert.assertEquals(WRONG_RESULT, wizard.getStrength(), BASE_HERO_STRENGTH);
        Assert.assertEquals(WRONG_RESULT, wizard.getAgility(), BASE_HERO_AGILITY);
        Assert.assertEquals(WRONG_RESULT, wizard.getIntelligence(), BASE_HERO_INTELLIGENCE);
        Assert.assertEquals(WRONG_RESULT, wizard.getHitPoints(), BASE_HERO_HIT_POINTS);
        Assert.assertEquals(WRONG_RESULT, wizard.getDamage(), BASE_HERO_DAMAGE);
    }
}
