package hell;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

//Test09TestHeroInventoryAddRecipeItemAndMakeNewItem
public class Test09 {

    private static final String ITEM_ONE_NAME = "ItemOneName";
    private static final String ITEM_TWO_NAME = "ItemTwoName";
    private static final String HERO_NAME = "HeroName";
    private static final String RECIPE_NAME = "RecipeName";
    private static final int RECIPE_BONUS = 10;
    private static final String WRONG_RESULT_MESSAGE = "Wrong result from method addRecipe!";


    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Item mockedItemOne = Mockito.mock(Item.class);
        Mockito.when(mockedItemOne.getName()).thenReturn(ITEM_ONE_NAME);
        Item mockedItemTwo = Mockito.mock(Item.class);
        Mockito.when(mockedItemTwo.getName()).thenReturn(ITEM_TWO_NAME);

        Class<?> constructorInventory = Classes.allClasses.values().stream()
                .filter(x -> x.getSimpleName().contains("Inventory")
                        && !x.isInterface())
                .findAny()
                .orElse(null);

        Assert.assertNotNull(constructorInventory);

        Inventory inventory = (Inventory) constructorInventory
                .getDeclaredConstructor()
                .newInstance();

        inventory.addCommonItem(mockedItemOne);
        inventory.addCommonItem(mockedItemTwo);

        Class<?> recipeItem = Classes.allClasses.values().stream()
                .filter(x -> x.getSimpleName().contains("Recipe")
                        && !x.isInterface())
                .findAny()
                .orElse(null);

        Assert.assertNotNull(recipeItem);

        Constructor<?> constructorRecipe = null;
        Recipe recipe = null;
        try {
            constructorRecipe = recipeItem.getDeclaredConstructor(
                    String.class, int.class, int.class, int.class,
                    int.class, int.class, String[].class);
            recipe = (Recipe) constructorRecipe.newInstance(RECIPE_NAME, RECIPE_BONUS,
                    RECIPE_BONUS, RECIPE_BONUS, RECIPE_BONUS, RECIPE_BONUS,
                    new String[]{ITEM_ONE_NAME, ITEM_TWO_NAME});
        } catch (Exception e) {
            constructorRecipe = recipeItem.getDeclaredConstructor(
                    String.class, int.class, int.class, int.class,
                    int.class, int.class, List.class);
            recipe = (Recipe) constructorRecipe.newInstance(RECIPE_NAME, RECIPE_BONUS,
                    RECIPE_BONUS, RECIPE_BONUS, RECIPE_BONUS, RECIPE_BONUS,
                    new ArrayList<String>(){{
                        add(ITEM_ONE_NAME);
                        add(ITEM_TWO_NAME);
                    }});
        }

        inventory.addRecipeItem(recipe);

        Assert.assertEquals(WRONG_RESULT_MESSAGE, inventory.getTotalDamageBonus(), RECIPE_BONUS);
    }
}
