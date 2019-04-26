package entities.items;

import entities.items.interfaces.Item;

public abstract class BaseItem implements Item {

    private int value;

    protected BaseItem(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
