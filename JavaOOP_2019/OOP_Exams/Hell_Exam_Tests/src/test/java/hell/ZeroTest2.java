package hell;

import hell.interfaces.Hero;
import hell.interfaces.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//T11TestCreateItemOutput
public class ZeroTest2 {
    private static final String EXPECTED_RESULT = "Added item - Knife to Hero - Ivan999";
    private static final String WRONG_RESULT = "Item command doesn't return the correct result!";
    private static final String HERO_NAME = "Ivan999";
    private static final String HERO_TYPE = "Assassin";

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
            add("Ivan999");
            add("0");
            add("10");
            add("0");
            add("0");
            add("30");
        }};

        String result = (String) method.invoke(manager, args);

        Assert.assertEquals(WRONG_RESULT, EXPECTED_RESULT, result);
    }
}
