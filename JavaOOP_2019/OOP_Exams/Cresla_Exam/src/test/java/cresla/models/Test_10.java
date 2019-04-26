package cresla.models;

import cresla.interfaces.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Test10_TestManagerModuleCommand
public class Test_10 {

    private static final String DEFAULT_TYPE = "Cryo";
    private static final String DEFAULT_TYPE_2 = "CryogenRod";
    private static final String DEFAULT_VALUE = "10";
    private static final String WRONG_RESULT_MESSAGE = "Wrong result from ModuleCommand";
    private static final String EXPECTED_RESULT_MESSAGE = "Added CryogenRod -";
    private static final String EXPECTED_RESULT_MESSAGE_2 = "to Reactor -";
    private static final String ONE = "1";


    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> managerClass = this.findReactorClass();
        Manager manager = (Manager) managerClass
                .getDeclaredConstructor()
                .newInstance();


        List<String> args = new ArrayList<String>() {{
            add(DEFAULT_TYPE);
            add(DEFAULT_VALUE);
            add(DEFAULT_VALUE);
        }};

        Method methodReactorCommand = managerClass
                .getDeclaredMethod("reactorCommand", List.class);
        methodReactorCommand.setAccessible(true);
        methodReactorCommand.invoke(manager, args);


        List<String> args2 = new ArrayList<String>() {{
            add(ONE);
            add(DEFAULT_TYPE_2);
            add(DEFAULT_VALUE);
        }};

        Method methodModuleCommand = managerClass
                .getDeclaredMethod("moduleCommand", List.class);
        methodReactorCommand.setAccessible(true);
        String result = (String) methodModuleCommand
                .invoke(manager, args2);


        Assert.assertTrue(WRONG_RESULT_MESSAGE,
                result.contains(EXPECTED_RESULT_MESSAGE)
                        && result.contains(EXPECTED_RESULT_MESSAGE_2));

    }

    //@SuppressWarnings("all")
    private Class<?> findReactorClass() {
        return Classes.allClasses.values().stream()
                .filter(x -> x.getSimpleName()
                        .toLowerCase().contains("manager")
                        && !x.isInterface())
                .findFirst()
                .orElse(null);
    }
}
