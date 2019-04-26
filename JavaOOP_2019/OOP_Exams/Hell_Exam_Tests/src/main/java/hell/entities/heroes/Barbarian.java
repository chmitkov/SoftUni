package hell.entities.heroes;

public class Barbarian extends AbstractHero {

    private static final int BASE_STRENGTH_HERO_STRENGTH = 90;
    private static final int BASE_STRENGTH_HERO_AGILITY = 25;
    private static final int BASE_STRENGTH_HERO_INTELLIGENCE = 10;
    private static final int BASE_STRENGTH_HERO_HITPOINTS = 350;
    private static final int BASE_STRENGTH_HERO_DAMAGE = 150;

    public Barbarian(String name) {
        super(name, BASE_STRENGTH_HERO_STRENGTH, BASE_STRENGTH_HERO_AGILITY, BASE_STRENGTH_HERO_INTELLIGENCE, BASE_STRENGTH_HERO_HITPOINTS, BASE_STRENGTH_HERO_DAMAGE);
    }
}