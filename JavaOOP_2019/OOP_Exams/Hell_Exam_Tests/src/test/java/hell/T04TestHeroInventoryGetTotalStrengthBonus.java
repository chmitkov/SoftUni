package hell;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class T04TestHeroInventoryGetTotalStrengthBonus {


    private static final int MOCKED_ITEM_VALUE = 10;
    private static final String MOCKED_ITEM_ONE_NAME = "Mock1";
    private static final String MOCKED_ITEM_TWO_NAME = "Mock2";
    private static final String WRONG_RESULT = "Wrong result from method getTotalStrengthBonus";

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Item mockedItem = Mockito.mock(Item.class);
        Mockito.when(mockedItem.getStrengthBonus())
                .thenReturn(MOCKED_ITEM_VALUE);
        Mockito.when(mockedItem.getName())
                .thenReturn(MOCKED_ITEM_ONE_NAME);
        Item mockedItem2 = Mockito.mock(Item.class);
        Mockito.when(mockedItem2.getStrengthBonus())
                .thenReturn(MOCKED_ITEM_VALUE);
        Mockito.when(mockedItem.getName())
                .thenReturn(MOCKED_ITEM_TWO_NAME);

        Class<?> inventoryClass = Classes.allClasses.values()
                .stream()
                .filter(x -> x.getSimpleName().contains("Inventory")
                        && !x.isInterface())
                .findAny()
                .orElseGet(null);

        Assert.assertNotNull(inventoryClass);
        Constructor<?> inventoryConstructor = inventoryClass.getDeclaredConstructor();

        Inventory inventory = (Inventory) inventoryConstructor.newInstance();

        inventory.addCommonItem(mockedItem);
        inventory.addCommonItem(mockedItem2);

        Assert.assertEquals(WRONG_RESULT,
                MOCKED_ITEM_VALUE * 2, inventory.getTotalStrengthBonus());

    }
}
