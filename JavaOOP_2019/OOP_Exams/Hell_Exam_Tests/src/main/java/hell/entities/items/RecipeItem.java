package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.Collections;
import java.util.List;

public class RecipeItem extends AbstractItem implements Recipe {

    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus,
                      int intelligenceBonus, int hitPointsBonus, int damageBonus, List<String> requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = requiredItems;
    }
    
    public List<String> getRequiredItems() {
        return Collections.unmodifiableList(this.requiredItems);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("###Recipe: %s\r\n", this.getName()));
        result.append(String.format("###Required Items: %s\r\n", String.join(", ", this.getRequiredItems())));
        result.append(super.toString());

        return result.toString();
    }
}
