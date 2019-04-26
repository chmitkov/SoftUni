package cresla.models;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Reactor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Test03_TestCryoReactorHeatAbsorbing
public class Test_03 {

    private static final int DEFAULT_VALUE = 10;
    private static final int ONE = 1;
    private static final String WRONG_RESULT_MESSAGE = "Wrong result from message %s!";

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cryoReactorClass = findReactorClass("Cryo");
        Reactor cryoReactor = (Reactor) cryoReactorClass
                .getDeclaredConstructor(int.class, int.class, int.class)
                .newInstance(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);

        Method methodAddEnergyModule =
                cryoReactorClass
                        .getSuperclass()
                        .getDeclaredMethod("addAbsorbingModule", AbsorbingModule.class);
        methodAddEnergyModule.setAccessible(true);
        AbsorbingModule mockedAbsorbingModel = Mockito.mock(AbsorbingModule.class);
        Mockito.when(mockedAbsorbingModel.getHeatAbsorbing()).thenReturn(DEFAULT_VALUE);
        methodAddEnergyModule.invoke(cryoReactor, mockedAbsorbingModel);

        Method methodGetTotalEnergyOutput = cryoReactorClass
                .getSuperclass()
                .getDeclaredMethod("getTotalHeatAbsorbing");
        methodGetTotalEnergyOutput.setAccessible(true);

        long result = (long) methodGetTotalEnergyOutput.invoke(cryoReactor);


        Assert.assertEquals(String.format(WRONG_RESULT_MESSAGE, "getTotalHeatAbsorbing")
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
