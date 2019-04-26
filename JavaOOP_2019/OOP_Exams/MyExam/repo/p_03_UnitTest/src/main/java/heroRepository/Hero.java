package heroRepository;

import java.util.Objects;

public class Hero {
    private String name;
    private int level;
    private Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return   Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("heroRepository.Hero: %s – %d%n" +
                        "  *  Strength: %d%n" +
                        "  *  Agility: %d%n" +
                        "  *  Intelligence: %d%n", this.name, this.level,
                this.item.getStrength(), this.item.getAgility(), this.item.getIntelligence());
    }
}