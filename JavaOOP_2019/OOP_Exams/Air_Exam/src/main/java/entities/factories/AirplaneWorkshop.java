package entities.factories;

import entities.airplanes.interfaces.FlyingMachine;
import entities.factories.interfaces.AirplaneFactory;

import java.lang.reflect.InvocationTargetException;

public class AirplaneWorkshop implements AirplaneFactory {
    private static final String PATH = "entities.airplanes.";
    private static final String AIRPLANE = "Airplane";

    @Override
    public FlyingMachine createAirplane(String type) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {

        Class<?> clazz = Class.forName(PATH + type + AIRPLANE);
        return (FlyingMachine) clazz.getDeclaredConstructor().newInstance();
    }
}
