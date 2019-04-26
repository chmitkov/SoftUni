package hell.interfaces;

public interface Inventory {
    long getTotalStrengthBonus();

    long getTotalAgilityBonus();

    long getTotalIntelligenceBonus();

    long getTotalHitPointsBonus();

    long getTotalDamageBonus();

    void addCommonItem(Item item);

    void addRecipeItem(Recipe recipe);
}
