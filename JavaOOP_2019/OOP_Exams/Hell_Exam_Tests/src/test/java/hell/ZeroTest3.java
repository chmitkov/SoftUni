package hell;

import hell.interfaces.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//T12TestCreateItemOutput
public class ZeroTest3 {
    private static final String EXPECTED_RESULT =
            "Hero: Ivan, Class: Barbarian" +System.lineSeparator()+
                    "HitPoints: 450, Damage: 200" +System.lineSeparator()+
                    "Strength: 115" +System.lineSeparator()+
                    "Agility: 35" +System.lineSeparator()+
                    "Intelligence: 20" +System.lineSeparator()+
                    "Items:" +System.lineSeparator()+
                    "###Item: Spear" +System.lineSeparator()+
                    "###+25 Strength" +System.lineSeparator()+
                    "###+10 Agility" +System.lineSeparator()+
                    "###+10 Intelligence" +System.lineSeparator()+
                    "###+100 HitPoints" +System.lineSeparator()+
                    "###+50 Damage";
    private static final String WRONG_RESULT_MESSAGE = "Wrong result from method inspect!";
    private static final String HERO_NAME = "Ivan";
    private static final String HERO_TYPE = "Barbarian";


    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> managerClass = Classes.allClasses.values().stream()
                .filter(x -> x.getSimpleName().contains("Manager")
                        && !x.isInterface())
                .findAny()
                .orElseGet(null);

        Constructor<?> constructorManager = managerClass.getDeclaredConstructor();
        constructorManager.setAccessible(true);

        Manager manager = (Manager) constructorManager.newInstance();

        manager.addHero(new ArrayList<String>(){{
            add(HERO_NAME);
            add(HERO_TYPE);
        }});

        Method method = manager.getClass().getDeclaredMethod("addItem",
                List.class);

        ArrayList<String> args = new ArrayList<String>() {{
            add("Knife");
            add(HERO_NAME);
            add("0");
            add("10");
            add("0");
            add("0");
            add("30");
        }};

        method.invoke(manager, args);

        ArrayList<String> args2 = new ArrayList<String>() {{
            add("Stick");
            add(HERO_NAME);
            add("0");
            add("0");
            add("10");
            add("0");
            add("5");
        }};

        method.invoke(manager, args2);

        ArrayList<String> args3 = new ArrayList<String>() {{
            add("Spear");
            add(HERO_NAME);
            add("25");
            add("10");
            add("10");
            add("100");
            add("50");
            add("Knife");
            add("Stick");
        }};

        Method methodAddRecipe = manager.getClass()
                .getDeclaredMethod("addRecipe", List.class);

        methodAddRecipe.invoke(manager, args3);



        Method methodInspect = manager.getClass()
                .getDeclaredMethod("inspect", List.class);


        String result = (String) methodInspect.invoke(manager,
                new ArrayList<String>(){{
                    add(HERO_NAME);
                }});

        Assert.assertEquals(WRONG_RESULT_MESSAGE, EXPECTED_RESULT, result);


    }
}
