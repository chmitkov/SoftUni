package entities.factories.interfaces;

import entities.items.interfaces.Item;

import java.lang.reflect.InvocationTargetException;

public interface ItemFactory {
    Item createItem(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
