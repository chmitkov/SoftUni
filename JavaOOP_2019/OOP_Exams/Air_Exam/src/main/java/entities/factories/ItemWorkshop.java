package entities.factories;

import entities.factories.interfaces.ItemFactory;
import entities.items.interfaces.Item;

import java.lang.reflect.InvocationTargetException;

public class ItemWorkshop implements ItemFactory {
    private static final String PATH = "entities.items.";

    @Override
    public Item createItem(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(PATH + type);

        return (Item) clazz.getDeclaredConstructor().newInstance();
    }
}
