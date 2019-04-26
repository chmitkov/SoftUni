package heroRepository;

import heroRepository.Hero;
import heroRepository.HeroRepository;
import heroRepository.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTest {


    private static final int INIT_STRENGTH = 10;
    private static final int INIT_AGILITY = 10;
    private static final int INIT_INTELLIGENCE = 10;
    private static final String INIT_NAME = "Name";
    private static final int INIT_LVL = 15;
    private static final int ONE = 1;

    private HeroRepository heroRepository;
    private Hero hero;
    private Item item;

    @Before
    public void setUp() throws Exception {
        this.heroRepository = new HeroRepository();
        this.item = new Item(INIT_STRENGTH, INIT_INTELLIGENCE, INIT_STRENGTH);
        this.hero = new Hero(INIT_NAME, INIT_AGILITY, this.item);
    }

    @Test
    public void add() {
        this.heroRepository.add(this.hero);
        Assert.assertEquals(ONE, this.heroRepository.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void addDuplicate() {
        this.heroRepository.add(this.hero);
        this.heroRepository.add(this.hero);
    }

    @Test
    public void remove() {
        this.heroRepository.add(this.hero);
        this.heroRepository.remove(this.hero.getName());

        Assert.assertEquals(0, this.heroRepository.getCount());
    }
    @Test(expected = NullPointerException.class)
    public void removeFromEmpty() {
        this.heroRepository.remove("");
    }

    @Test
    public void getHeroWithHighestStrength() {
        this.heroRepository.add(this.hero);
        Item item2 = new Item(20, INIT_AGILITY, INIT_INTELLIGENCE);
        Hero hero2 = new Hero("NewNAme", INIT_AGILITY, item2);
        this.heroRepository.add(hero2);

        Assert.assertEquals(hero2, this.heroRepository.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthException() {
        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestAgility() {
        this.heroRepository.add(this.hero);
        Item item2 = new Item(INIT_STRENGTH, 20, INIT_INTELLIGENCE);
        Hero hero2 = new Hero("NewNAme", INIT_AGILITY, item2);
        this.heroRepository.add(hero2);

        Assert.assertEquals(hero2, this.heroRepository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityException() {
        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestIntelligence() {
        this.heroRepository.add(this.hero);
        Item item2 = new Item(INIT_STRENGTH, INIT_AGILITY, 20);
        Hero hero2 = new Hero("NewNAme", INIT_AGILITY, item2);
        this.heroRepository.add(hero2);

        Assert.assertEquals(hero2, this.heroRepository.getHeroWithHighestIntelligence());

    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceException() {
        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void getCount() {
        this.heroRepository.add(this.hero);
        Assert.assertEquals(ONE, this.heroRepository.getCount());
    }

}