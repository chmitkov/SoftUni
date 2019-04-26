package hell;

import hell.interfaces.Hero;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class T01TestAssassinCreate {
    private static final String HERO_NAME = "HeroName";
    private static final String CLASS_ASSASSIN_NAME = "Assassin";
    private static final String WRONG_RESULT = "Wrong result from create Assassin!";
    private static final int BASE_HERO_STRENGTH = 25;
    private static final int BASE_HERO_AGILITY = 100;
    private static final int BASE_HERO_INTELLIGENCE = 15;
    private static final int BASE_HERO_HIT_POINTS = 150;
    private static final int BASE_HERO_DAMAGE = 300;

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> assassinClass = Classes.allClasses.values().stream()
                .filter(x -> x.getSimpleName().contains(CLASS_ASSASSIN_NAME))
                .findFirst()
                .orElse(null);

        Assert.assertNotNull(assassinClass);
        Constructor<?> constructor = assassinClass
                .getDeclaredConstructor(String.class);

        Assert.assertNotNull(constructor);
        constructor.setAccessible(true);

        Hero assassin = (Hero) constructor.newInstance(HERO_NAME);

        Assert.assertEquals(WRONG_RESULT, assassin.getName(), HERO_NAME);
        Assert.assertEquals(WRONG_RESULT, assassin.getStrength(), BASE_HERO_STRENGTH);
        Assert.assertEquals(WRONG_RESULT, assassin.getAgility(), BASE_HERO_AGILITY);
        Assert.assertEquals(WRONG_RESULT, assassin.getIntelligence(), BASE_HERO_INTELLIGENCE);
        Assert.assertEquals(WRONG_RESULT, assassin.getHitPoints(), BASE_HERO_HIT_POINTS);
        Assert.assertEquals(WRONG_RESULT, assassin.getDamage(), BASE_HERO_DAMAGE);
    }
}
