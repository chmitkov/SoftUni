package cresla.models;

import cresla.interfaces.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Test09_TestManagerReactorCommand
public class Test_09 {

    private static final String DEFAULT_TYPE = "Cryo";
    private static final String DEFAULT_VALUE = "10";
    private static final String WRONG_RESULT_MESSAGE = "Wrong result from ReactorCommand";
    private static final String EXPECTED_RESULT_MESSAGE = "Created Cryo Reactor -";


    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> managerClass = this.findReactorClass();
        Manager manager = (Manager) managerClass
                .getDeclaredConstructor()
                .newInstance();


        String[] args = new String[]{DEFAULT_TYPE,
                DEFAULT_VALUE, DEFAULT_VALUE};
        Method methodReactorCommand =
                methodReactorCommand = managerClass
                        .getDeclaredMethod("reactorCommand", List.class);
        methodReactorCommand.setAccessible(true);
        String result = (String) methodReactorCommand
                .invoke(manager, Arrays.asList(args));

        result = result.subSequence(0, result.length() - 1).toString().trim();
        Assert.assertEquals(WRONG_RESULT_MESSAGE,
                EXPECTED_RESULT_MESSAGE, result);

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
