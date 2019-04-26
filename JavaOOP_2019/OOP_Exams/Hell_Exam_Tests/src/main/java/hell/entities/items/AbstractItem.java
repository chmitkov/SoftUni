package hell.entities.items;

import hell.interfaces.Item;

public abstract class AbstractItem implements Item {

    private String name;

    private int strengthBonus;

    private int agilityBonus;

    private int intelligenceBonus;

    private int hitPointsBonus;

    private int damageBonus;

    protected AbstractItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        this.setName(name);
        this.setStrengthBonus(strengthBonus);
        this.setAgilityBonus(agilityBonus);
        this.setIntelligenceBonus(intelligenceBonus);
        this.setHitPointsBonus(hitPointsBonus);
        this.setDamageBonus(damageBonus);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    private void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    private void setAgilityBonus(int agilityBonus) {
        this.agilityBonus = agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    private void setIntelligenceBonus(int intelligenceBonus) {
        this.intelligenceBonus = intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    private void setHitPointsBonus(int hitPointsBonus) {
        this.hitPointsBonus = hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }

    private void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("###+%d Strength\r\n", this.getStrengthBonus()));
        result.append(String.format("###+%d Agility\r\n", this.getAgilityBonus()));
        result.append(String.format("###+%d Intelligence\r\n", this.getIntelligenceBonus()));
        result.append(String.format("###+%d HitPoints\r\n", this.getHitPointsBonus()));
        result.append(String.format("###+%d Damage\r\n", this.getDamageBonus()));

        return result.toString();
    }
}
