package heroRepository;

import java.util.ArrayList;
import java.util.List;

//THIS IS THE CORRECT SOLUTION
public class HeroRepository {

    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add(Hero hero) {
        if (this.data.contains(hero)){
            throw new IllegalArgumentException("Duplicate heroes!");
        }
        this.data.add(hero);
    }

    public void remove(String name) {
        Hero hero = this.data.stream().filter(x -> x.getName()
                .equals(name)).findFirst().orElse(null);

        if (hero==null){
            throw new NullPointerException("heroRepository.Hero doesn't exist");
        }
        this.data.remove(hero);
    }

    public Hero getHeroWithHighestStrength() {
        int best = 0;
        Hero bestHero = null;
        for (Hero hero : data) {
            if (hero.getItem().getStrength() > best) {
                bestHero = hero;
                best=hero.getItem().getStrength();
            }
        }
        if (bestHero==null){
            throw new NullPointerException("heroRepository.Hero with highest strength not found");
        }
        return bestHero;
    }

    public Hero getHeroWithHighestAgility() {
        int best = 0;
        Hero bestHero = null;
        for (Hero hero : data) {
            if (hero.getItem().getAgility() > best) {
                bestHero = hero;
                best=hero.getItem().getAgility();
            }
        }
        if (bestHero==null){
            throw new NullPointerException("heroRepository.Hero with highest agility not found");
        }
        return bestHero;
    }

    public Hero getHeroWithHighestIntelligence() {
        int best = 0;
        Hero bestHero = null;
        for (Hero hero : data) {
            if (hero.getItem().getIntelligence() > best) {
                bestHero = hero;
                best=hero.getItem().getIntelligence();
            }
        }
        if (bestHero==null){
            throw new NullPointerException("heroRepository.Hero with highest intelligence not found");
        }
        return bestHero;
    }

    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.data.forEach(x -> sb.append(x.toString()));
        return sb.toString();
    }




}
