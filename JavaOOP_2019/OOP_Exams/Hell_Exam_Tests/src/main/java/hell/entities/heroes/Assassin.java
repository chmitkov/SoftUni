package hell.entities.heroes;

public class Assassin extends AbstractHero {

    private static final int BASE_AGILITY_HERO_STRENGTH = 25;
    private static final int BASE_AGILITY_HERO_AGILITY = 100;
    private static final int BASE_AGILITY_HERO_INTELLIGENCE = 15;
    private static final int BASE_AGILITY_HERO_HITPOINTS = 150;
    private static final int BASE_AGILITY_HERO_DAMAGE = 300;

    public Assassin(String name) {
        super(name, BASE_AGILITY_HERO_STRENGTH, BASE_AGILITY_HERO_AGILITY, BASE_AGILITY_HERO_INTELLIGENCE, BASE_AGILITY_HERO_HITPOINTS, BASE_AGILITY_HERO_DAMAGE);
    }
}