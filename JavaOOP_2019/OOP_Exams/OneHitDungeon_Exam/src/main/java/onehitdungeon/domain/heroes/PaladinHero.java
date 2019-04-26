package onehitdungeon.domain.heroes;

import onehitdungeon.domain.items.ArmorItemImpl;
import onehitdungeon.domain.items.OffhandItemImpl;
import onehitdungeon.domain.items.WeaponItemImpl;

import java.lang.reflect.Field;

public class PaladinHero extends BaseHero {

    private static final Integer WEAPON_BATTLE_POWER_INIT_VALUE = 20;
    private static final Double WEAPON_PRICE_FOR_UPGRADE_INIT_VALUE = 10D;
    private static final Integer OFFHAND_BATTLE_POWER_INIT_VALUE = 10;
    private static final Double OFFHAND_PRICE_FOR_UPGRADE_INIT_VALUE = 10D;
    private static final Integer ARMOR_BATTLE_POWER_INIT_VALUE = 25;
    private static final Double ARMOR_PRICE_FOR_UPGRADE_INIT_VALUE = 20D;


    public PaladinHero(String name) {
        super(name,
                new WeaponItemImpl(WEAPON_BATTLE_POWER_INIT_VALUE,
                        WEAPON_PRICE_FOR_UPGRADE_INIT_VALUE),
                new OffhandItemImpl(OFFHAND_BATTLE_POWER_INIT_VALUE,
                        OFFHAND_PRICE_FOR_UPGRADE_INIT_VALUE),
                new ArmorItemImpl(ARMOR_BATTLE_POWER_INIT_VALUE,
                        ARMOR_PRICE_FOR_UPGRADE_INIT_VALUE)
        );
    }

    @Override
    public String getHeroClass() {
        return "Paladin";
    }

    private Integer getCurrentLevel() {
        Class<?> superClass = this.getClass().getSuperclass();

        Field fieldLevel = null;

        try {
            fieldLevel = superClass.getDeclaredField("timesTrained");
            fieldLevel.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            return (Integer) fieldLevel.get(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getTotalBattlePower() {
        return ((super.getWeapon().getBattlePower()
                + super.getOffhand().getBattlePower()
                + super.getArmor().getBattlePower()) * 4) / 9;
    }

    @Override
    public String toString() {
        return String.format("%s - Lvl. %d Paladin\n" +
                        "* Mace - %d (BP)\n" +
                        "* Shield - %d (BP)\n" +
                        "* Cuirass - %d (BP)\n" +
                        "%s",
                super.getName(), this.getCurrentLevel(),
                super.getWeapon().getBattlePower(),
                super.getOffhand().getBattlePower(),
                super.getArmor().getBattlePower(),
                super.toString());
    }
}
