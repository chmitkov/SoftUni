package hell.entities.heroes;

public class Wizard extends AbstractHero {

    private static final int BASE_INTELLIGENCE_HERO_STRENGTH = 25;
    private static final int BASE_INTELLIGENCE_HERO_AGILITY = 25;
    private static final int BASE_INTELLIGENCE_HERO_INTELLIGENCE = 100;
    private static final int BASE_INTELLIGENCE_HERO_HITPOINTS = 100;
    private static final int BASE_INTELLIGENCE_HERO_DAMAGE = 250;

    public Wizard(String name) {
        super(name, BASE_INTELLIGENCE_HERO_STRENGTH, BASE_INTELLIGENCE_HERO_AGILITY, BASE_INTELLIGENCE_HERO_INTELLIGENCE, BASE_INTELLIGENCE_HERO_HITPOINTS, BASE_INTELLIGENCE_HERO_DAMAGE);
    }
}