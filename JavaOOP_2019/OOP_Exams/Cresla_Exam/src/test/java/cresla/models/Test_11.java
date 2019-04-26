package cresla.models;

import cresla.interfaces.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//Test11_TestManagerReportCommand
public class Test_11 {

    private static final String DEFAULT_TYPE = "Cryo";
    private static final String DEFAULT_TYPE_2 = "HeatProcessor";
    private static final String DEFAULT_VALUE = "10000";
    private static final String ONE = "1";
    private static final String WRONG_RESULT_MESSAGE = "Wrong result from ReportCommand!";
    private static final String EXPECTED_OUTPUT =
            "Energy Output: 0" + System.lineSeparator() +
            "Heat Absorbing: 10000" + System.lineSeparator() +
            "Modules: 1";

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> managerClass = this.findManagerClass();
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
        methodModuleCommand.setAccessible(true);
        methodModuleCommand
                .invoke(manager, args2);

        Method methodReport = managerClass
                .getDeclaredMethod("reportCommand", List.class);
        methodReport.setAccessible(true);
        String result = (String) methodReport.invoke(
                manager, new ArrayList<>() {{
                    add("1");
                }});

        Assert.assertTrue(WRONG_RESULT_MESSAGE, result.contains(EXPECTED_OUTPUT));
    }

    private Class<?> findManagerClass() {
        return Classes.allClasses.values().stream()
                .filter(x -> x.getSimpleName()
                        .toLowerCase().contains("manager")
                        && !x.isInterface())
                .findFirst()
                .orElse(null);
    }
}
