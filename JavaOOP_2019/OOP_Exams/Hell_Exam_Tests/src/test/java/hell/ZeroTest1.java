package hell;

import hell.interfaces.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//T10TestCreateHeroOutput
public class ZeroTest1 {

    private static final String EXPECTED_RESULT = "Created Barbarian - IIIIvan";
    private static final String INPUT = "IIIIvan Barbarian";
    private static final String WRONG_RESULT = "Hero command doesn't return the correct result!";

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


        Method method = manager.getClass().getDeclaredMethod("addHero",
                List.class);
        ArrayList<String> args = new ArrayList<String>() {{
            add("IIIIvan");
            add("Barbarian");
        }};


        String result = (String) method.invoke(manager, args);

        Assert.assertEquals(WRONG_RESULT, EXPECTED_RESULT, result);


    }
}
