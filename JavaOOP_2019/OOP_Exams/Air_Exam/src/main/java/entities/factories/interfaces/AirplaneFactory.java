package entities.factories.interfaces;

import entities.airplanes.interfaces.FlyingMachine;

import java.lang.reflect.InvocationTargetException;

public interface AirplaneFactory {
    FlyingMachine createAirplane(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}

