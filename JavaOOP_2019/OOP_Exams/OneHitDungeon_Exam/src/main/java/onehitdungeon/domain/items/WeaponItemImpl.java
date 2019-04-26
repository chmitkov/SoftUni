package onehitdungeon.domain.items;

import onehitdungeon.interfaces.WeaponItem;

public class WeaponItemImpl extends BaseItem implements WeaponItem {
    public WeaponItemImpl(Integer battlePower, Double priceForUpgrade) {
        super(battlePower, priceForUpgrade);
    }
}
