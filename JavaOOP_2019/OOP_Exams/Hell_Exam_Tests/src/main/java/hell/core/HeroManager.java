package hell.core;

import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Manager;
import hell.utilities.Constants;

import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroManager implements Manager {
    private Map<String, Hero> heroes;

    public HeroManager() {
        this.heroes = new LinkedHashMap<String, Hero>();
    }

    public String addHero(List<String> arguments) {
        String result = null;

        String heroName = arguments.get(0);
        String heroType = arguments.get(1);

        try {
            Class<?> newClass = Class.forName(Constants.HEROES_PATH + heroType);
            Constructor<?> ctor = newClass.getConstructor(String.class);
            Hero hero = (Hero) ctor.newInstance(heroName);
            this.heroes.put(hero.getName(), hero);
            result = String.format(Constants.HERO_CREATE_MESSAGE, heroType, hero.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String addItem(List<String> arguments) {
        String result = null;

        String itemName = arguments.get(0);
        String heroName = arguments.get(1);
        int strengthBonus = Integer.parseInt(arguments.get(2));
        int agilityBonus = Integer.parseInt(arguments.get(3));
        int intelligenceBonus = Integer.parseInt(arguments.get(4));
        int hitPointsBonus = Integer.parseInt(arguments.get(5));
        int damageBonus = Integer.parseInt(arguments.get(6));

        CommonItem newItem = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.heroes.get(heroName).addItem(newItem);

        result = String.format(Constants.ITEM_CREATE_MESSAGE, newItem.getName(), heroName);
        return result;
    }

    public String addRecipe(List<String> arguments) {
        String result = null;

        String recipeName = arguments.get(0);
        String heroName = arguments.get(1);
        int strengthBonus = Integer.parseInt(arguments.get(2));
        int agilityBonus = Integer.parseInt(arguments.get(3));
        int intelligenceBonus = Integer.parseInt(arguments.get(4));
        int hitPointsBonus = Integer.parseInt(arguments.get(5));
        int damageBonus = Integer.parseInt(arguments.get(6));
        List<String> requiredItems = arguments.stream().skip(7).collect(Collectors.toList());

        RecipeItem newRecipe = new RecipeItem(recipeName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);
        this.heroes.get(heroName).addRecipe(newRecipe);

        result = String.format(Constants.RECIPE_CREATE_MESSAGE, newRecipe.getName(), heroName);
        return result;
    }

    public String inspect(List<String> arguments) {
        String heroName = arguments.get(0);

        return this.heroes.get(heroName).toString();
    }

    public String quit() {
        int counter = 1;

        StringBuilder result = new StringBuilder();

        for (Hero hero : this.heroes.values().stream().sorted((x1, x2) -> {
            int compareResult = Long.compare((x2.getStrength() + x2.getAgility() + x2.getIntelligence()), (x1.getStrength() + x1.getAgility() + x1.getIntelligence()));

            if (compareResult == 0) {
                compareResult = Long.compare((x2.getHitPoints() + x2.getDamage()), (x1.getHitPoints() + x1.getDamage()));
            }

            return compareResult;
        }).collect(Collectors.toList())) {
            result.append(String.format("%d. %s: %s\r\n", counter, hero.getClass().getSimpleName(), hero.getName()));
            result.append(String.format("###HitPoints: %d\r\n", hero.getHitPoints()));
            result.append(String.format("###Damage: %d\r\n", hero.getDamage()));
            result.append(String.format("###Strength: %d\r\n", hero.getStrength()));
            result.append(String.format("###Agility: %d\r\n", hero.getAgility()));
            result.append(String.format("###Intelligence: %d\r\n", hero.getIntelligence()));
            result.append(String.format("###Items: %s\r\n", hero.getItems().size() > 0 ? String.join(", ", hero.getItems().stream().map((x) -> x.getName()).collect(Collectors.toList()))  : "None"));

            counter++;
        }

        return result.toString().trim();
    }
}
