package onehitdungeon.domain.heroes;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

public abstract class BaseHero implements Hero {

    private String name;
    private WeaponItem weapon;
    private OffhandItem offhand;
    private ArmorItem armor;
    private Double gold;
    private Double upgradeCost;
    private Integer timesTrained;

    protected BaseHero(String name, WeaponItem weapon, OffhandItem offhand, ArmorItem armor) {
        this.name = name;
        this.weapon = weapon;
        this.offhand = offhand;
        this.armor = armor;
        this.gold = 0D;
        this.upgradeCost = 0D;
        this.timesTrained = 1;

    }

    @Override
    public abstract String getHeroClass() ;

    @Override
    public Double getGold() {
        return this.gold;
    }

    @Override
    public void earnGold(Double gold) {
        this.gold += gold;
    }

    @Override
    public void payGold(Double gold) {
        this.gold -= gold;
        this.upgradeCost += gold;
        this.timesTrained++;
    }

    @Override
    public WeaponItem getWeapon() {
        return this.weapon;
    }

    @Override
    public OffhandItem getOffhand() {
        return this.offhand;
    }

    @Override
    public ArmorItem getArmor() {
        return this.armor;
    }

    @Override
    public Integer getTotalBattlePower() {
        return (this.weapon.getBattlePower() + this.offhand.getBattlePower()
                + this.armor.getBattlePower());
    }

    @Override
    public Double getTotalPriceForUpgrade() {
        return (this.weapon.getPriceForUpgrade() + this.offhand.getPriceForUpgrade()
                + this.armor.getPriceForUpgrade());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("####################\n" +
                        "Gold: %.2f\n" +
                        "Upgrade cost: %.2f",
                this.gold, this.getTotalPriceForUpgrade());
    }
}
