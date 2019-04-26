package entities.interfaces;

import entities.items.interfaces.Item;

import java.util.List;

public interface Bag {
    Passenger getOwner();

    List<Item> getItems();
}
