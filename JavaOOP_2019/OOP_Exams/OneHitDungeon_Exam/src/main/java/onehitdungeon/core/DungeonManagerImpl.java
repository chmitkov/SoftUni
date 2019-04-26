package onehitdungeon.core;

import onehitdungeon.domain.heroes.MageHero;
import onehitdungeon.domain.heroes.PaladinHero;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.HeroTrainer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DungeonManagerImpl implements DungeonManager {

    private static final Integer INIT_LEVEL_BATTLE_POWER = 20;
    private static final Double INIT_GOLD_FROM_LEVEL_PASS = 15D;
    private static final Integer ONE = 1;


    private Integer dungeonBattlePower;
    private Double goldFromLevelPass;
    private Integer dungeonLevel;
    private HeroTrainer heroTrainer;
    private Map<String, Hero> registeredHeroes;
    private Hero selectedHero;


    public DungeonManagerImpl() {
        this.dungeonBattlePower = INIT_LEVEL_BATTLE_POWER;
        this.goldFromLevelPass = INIT_GOLD_FROM_LEVEL_PASS;
        this.dungeonLevel = ONE;
        this.heroTrainer = new HeroTrainerImpl();
        this.registeredHeroes = new LinkedHashMap<>();
        this.selectedHero = null;
    }

    @Override
    public String hero(List<String> arguments) {
        Hero hero = null;
        if (arguments.get(1).equals("Paladin")) {
            hero = new PaladinHero(arguments.get(2));
        } else {
            hero = new MageHero(arguments.get(2));
        }

        if (this.registeredHeroes.size() == 0) {
            this.selectedHero = hero;
        }

        this.registeredHeroes.put(arguments.get(2), hero);

        return String.format("Successfully added %s - %s.",
                arguments.get(1), arguments.get(2));
    }

    @Override
    public String select(List<String> arguments) {
        this.selectedHero = this.registeredHeroes.get(arguments.get(1));

        return String.format("Successfully selected %s - %s.",
                this.getSelectedHeroType(), this.selectedHero.getName());
    }

    @Override
    public String status(List<String> arguments) {
        return this.selectedHero.toString();
    }

    @Override
    public String fight(List<String> arguments) {

        String resultFromFight;

        if (this.selectedHero.getTotalBattlePower() > this.dungeonBattlePower) {
            this.selectedHero.earnGold(this.goldFromLevelPass);
            resultFromFight = String.format("Fight won. You’ve gained %.2f gold.",
                    this.goldFromLevelPass);
        } else {
            this.dungeonLevelDown();
            resultFromFight = "Fight lost. You’ve returned to the previous level.";
        }

        return resultFromFight;
    }

    @Override
    public String advance(List<String> arguments) {
        this.dungeonLevelUp();
        return String.format("Successfully advanced to dungeon level %d.",
                this.dungeonLevel);
    }

    @Override
    public String train(List<String> arguments) {
        String resultFromTrain;
        if (this.selectedHero.getGold() >= this.selectedHero.getTotalPriceForUpgrade()) {
            this.selectedHero.payGold(this.selectedHero.getTotalPriceForUpgrade());
            this.heroTrainer.trainHero(this.selectedHero);
            resultFromTrain = String.format("Successfully trained hero. Current total battle power: %s.",
                    this.selectedHero.getTotalBattlePower());
        } else {
            resultFromTrain = String.format("Insufficient gold for training. Needed %.2f. Got %.2f.",
                    this.selectedHero.getTotalPriceForUpgrade(), this.selectedHero.getGold());
        }

        return resultFromTrain;
    }

    @Override
    public String quit(List<String> arguments) {
        StringBuilder quitResult = new StringBuilder();
        for (Hero value : this.registeredHeroes.values()) {
            quitResult.append(String.format("%s %s - %d (BP)",
                    this.getSelectedHeroType(),
                    this.selectedHero.getName(),
                    this.selectedHero.getTotalBattlePower()))
                    .append(System.lineSeparator());
        }
        quitResult.append("####################")
                .append(System.lineSeparator())
                .append("Dungeon level reached: ")
                .append(this.dungeonLevel);

        return quitResult.toString();
    }

    private String getSelectedHeroType() {
        return this.selectedHero.getClass().getSimpleName()
                .substring(0, this.selectedHero
                        .getClass()
                        .getSimpleName()
                        .length() - 4);
    }

    private void dungeonLevelDown() {
        this.dungeonLevel--;
        this.dungeonBattlePower /= 2;
        this.goldFromLevelPass /= 2;
    }

    private void dungeonLevelUp() {
        this.dungeonLevel++;
        this.dungeonBattlePower *= 2;
        this.goldFromLevelPass *= 2;
    }
}
