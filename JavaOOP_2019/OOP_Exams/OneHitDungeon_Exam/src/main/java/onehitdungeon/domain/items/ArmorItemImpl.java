package onehitdungeon.domain.items;

import onehitdungeon.interfaces.ArmorItem;

public class ArmorItemImpl extends BaseItem implements ArmorItem {

    public ArmorItemImpl(Integer battlePower, Double priceForUpgrade) {
        super(battlePower, priceForUpgrade);
    }
}
