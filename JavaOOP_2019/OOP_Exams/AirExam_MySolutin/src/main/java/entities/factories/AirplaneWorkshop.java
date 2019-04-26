package entities.factories;

import entities.airplanes.interfaces.FlyingMachine;
import entities.factories.interfaces.AirplaneFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AirplaneWorkshop implements AirplaneFactory {
    private static final String PATH = "entities.airplanes.";

    @Override
    public FlyingMachine createAirplane(String type) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Class<?> clazz = Class.forName(type);
        //Class<?> clazz = Class.forName(PATH + type);
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return (FlyingMachine) constructor.newInstance();
    }
}
