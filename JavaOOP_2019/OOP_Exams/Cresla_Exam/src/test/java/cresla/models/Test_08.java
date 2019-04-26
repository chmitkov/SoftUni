package cresla.models;

import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Test08_TestHeatReactorGetTotalEnergyOutput
public class Test_08 {

    private static final int DEFAULT_VALUE = 10;
    private static final int ONE = 1;
    private static final String WRONG_RESULT_MESSAGE = "Wrong result from message %s!";

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> heatReactorClass = findReactorClass("Heat");
        Reactor heatReactor = (Reactor) heatReactorClass
                .getDeclaredConstructor(int.class, int.class, int.class)
                .newInstance(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);


        Method methodAddEnergyModule =
                heatReactorClass
                        .getSuperclass()
                        .getDeclaredMethod("addEnergyModule", EnergyModule.class);
        methodAddEnergyModule.setAccessible(true);
        EnergyModule mockedEnergyModule = Mockito.mock(EnergyModule.class);
        Mockito.when(mockedEnergyModule.getEnergyOutput()).thenReturn(DEFAULT_VALUE);
        methodAddEnergyModule.invoke(heatReactor, mockedEnergyModule);

        Method methodGetTotalEnergyOutput = heatReactorClass
                .getSuperclass()
                .getDeclaredMethod("getTotalEnergyOutput");
        methodGetTotalEnergyOutput.setAccessible(true);

        long result = (long) methodGetTotalEnergyOutput.invoke(heatReactor);

        Assert.assertEquals(String.format(WRONG_RESULT_MESSAGE, "getTotalEnergyOutput")
                , DEFAULT_VALUE, result);
    }


    //@SuppressWarnings("all")
    private Class<?> findReactorClass(String type) {
        return Classes.allClasses.values().stream()
                .filter(x -> x.getSimpleName()
                        .toLowerCase().contains("reactor")
                        && x.getSimpleName()
                        .toLowerCase()
                        .contains(type.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    ;
}
