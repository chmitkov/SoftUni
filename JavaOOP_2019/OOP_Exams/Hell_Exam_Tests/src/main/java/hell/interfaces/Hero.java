package hell.interfaces;

import java.util.Collection;

/**
 *
 */
public interface Hero {
    String getName();

    long getStrength();

    long getAgility();

    long getIntelligence();

    long getHitPoints();

    long getDamage();

    Collection<Item> getItems();

    void addItem(Item item);

    void addRecipe(Recipe recipe);
}