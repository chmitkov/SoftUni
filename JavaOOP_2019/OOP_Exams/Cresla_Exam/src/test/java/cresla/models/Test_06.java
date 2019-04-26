package cresla.models;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Reactor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Test06_TestHeatReactorAddAbsorbingModule
public class Test_06 {

    private static final int DEFAULT_VALUE = 10;
    private static final int ONE = 1;
    private static final String WRONG_RESULT_MESSAGE = "Wrong result from message %s!";

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> heatReactorClass = findReactorClass("Heat");
        Reactor heatReactor = (Reactor) heatReactorClass
                .getDeclaredConstructor(int.class, int.class, int.class)
                .newInstance(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);

        Method methodGetModuleCount =
                heatReactorClass
                        .getSuperclass()
                        .getDeclaredMethod("getModuleCount");
        methodGetModuleCount.setAccessible(true);

        Method methodAddEnergyModule =
                heatReactorClass
                        .getSuperclass()
                        .getDeclaredMethod("addAbsorbingModule", AbsorbingModule.class);
        methodAddEnergyModule.setAccessible(true);

        AbsorbingModule mockedAbsorbingModel = Mockito.mock(AbsorbingModule.class);

        methodAddEnergyModule.invoke(heatReactor, mockedAbsorbingModel);

        Assert.assertEquals(String.format(WRONG_RESULT_MESSAGE, "addAbsorbingModule")
                , ONE, methodGetModuleCount.invoke(heatReactor));
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
