package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.*;

public abstract class AbstractHero implements Hero {

    private String name;

    private int strength;

    private int agility;

    private int intelligence;

    private int hitPoints;

    private int damage;

    private Inventory inventory;

    protected AbstractHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.setName(name);
        this.setStrength(strength);
        this.setAgility(agility);
        this.setIntelligence(intelligence);
        this.setHitPoints(hitPoints);
        this.setDamage(damage);
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    private void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    private void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    private void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    private void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public Collection<Item> getItems() {
        try {
            Field collectionField = Arrays.asList(this.inventory.getClass().getDeclaredFields())
                    .stream()
                    .filter((x) -> x.isAnnotationPresent(ItemCollection.class))
                    .findFirst()
                    .get();

            if (collectionField != null) {
                collectionField.setAccessible(true);
                return Collections.unmodifiableCollection(((Map<String, Item>) collectionField.get(this.inventory)).values());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("Hero: %s, Class: %s\r\n", this.getName(), this.getClass().getSimpleName()));
        result.append(String.format("HitPoints: %d, Damage: %d\r\n", this.getHitPoints(), this.getDamage()));
        result.append(String.format("Strength: %s\r\n", this.getStrength()));
        result.append(String.format("Agility: %s\r\n", this.getAgility()));
        result.append(String.format("Intelligence: %s\r\n", this.getIntelligence()));
        result.append(String.format("Items:"));

        try {
            if (this.getItems().isEmpty()) {
                result.append(" None");
            } else {
                result.append("\r\n");

                for (Item item : this.getItems()) {
                    result.append(item.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString().trim();
    }
}
