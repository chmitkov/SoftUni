package hell.entities.items;

public class CommonItem extends AbstractItem {

    public CommonItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("###Item: %s\r\n", this.getName()));
        result.append(super.toString());

        return result.toString();
    }
}
