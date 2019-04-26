package hell;

import hell.interfaces.Hero;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class T02TestBarbarianCreate {
    private static final String HERO_NAME = "HeroName";
    private static final String CLASS_ASSASSIN_NAME = "Barbarian";
    private static final String WRONG_RESULT = "Wrong result from create Barbarian!";
    private static final int BASE_HERO_STRENGTH = 90;
    private static final int BASE_HERO_AGILITY = 25;
    private static final int BASE_HERO_INTELLIGENCE = 10;
    private static final int BASE_HERO_HIT_POINTS = 350;
    private static final int BASE_HERO_DAMAGE = 150;

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> assassinClass = Classes.allClasses.values().stream()
                .filter(x -> x.getSimpleName().contains(CLASS_ASSASSIN_NAME))
                .findFirst()
                .orElse(null);

        Constructor<?> constructor = assassinClass
                .getDeclaredConstructor(String.class);

        constructor.setAccessible(true);

        Hero barbarian = (Hero) constructor.newInstance(HERO_NAME);

        Assert.assertEquals(WRONG_RESULT, barbarian.getName(), HERO_NAME);
        Assert.assertEquals(WRONG_RESULT, barbarian.getStrength(), BASE_HERO_STRENGTH);
        Assert.assertEquals(WRONG_RESULT, barbarian.getAgility(), BASE_HERO_AGILITY);
        Assert.assertEquals(WRONG_RESULT, barbarian.getIntelligence(), BASE_HERO_INTELLIGENCE);
        Assert.assertEquals(WRONG_RESULT, barbarian.getHitPoints(), BASE_HERO_HIT_POINTS);
        Assert.assertEquals(WRONG_RESULT, barbarian.getDamage(), BASE_HERO_DAMAGE);
    }
}
