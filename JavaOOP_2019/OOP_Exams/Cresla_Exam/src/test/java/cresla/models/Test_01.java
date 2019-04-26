package cresla.models;

import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Test01_TestCryoReactorAddEnergyModule
public class Test_01 {

    private static final int DEFAULT_VALUE = 10;
    private static final int ONE = 1;
    private static final String WRONG_RESULT_MESSAGE = "Wrong result from message %s!";

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cryoReactorClass = findReactorClass("Cryo");
        Reactor cryoReactor = (Reactor) cryoReactorClass
                .getDeclaredConstructor(int.class, int.class, int.class)
                .newInstance(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);

        Method methodGetModuleCount =
                cryoReactorClass
                        .getSuperclass()
                        .getDeclaredMethod("getModuleCount");
        methodGetModuleCount.setAccessible(true);

        Method methodAddEnergyModule =
                cryoReactorClass
                        .getSuperclass()
                        .getDeclaredMethod("addEnergyModule", EnergyModule.class);
        methodAddEnergyModule.setAccessible(true);

        EnergyModule mockedEnergyModule = Mockito.mock(EnergyModule.class);

        methodAddEnergyModule.invoke(cryoReactor, mockedEnergyModule);

        Assert.assertEquals(String.format(WRONG_RESULT_MESSAGE, "addEnergyModule")
                , ONE, methodGetModuleCount.invoke(cryoReactor));
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
