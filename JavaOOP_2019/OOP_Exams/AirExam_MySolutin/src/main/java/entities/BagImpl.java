package entities;

import entities.interfaces.Bag;
import entities.interfaces.Passenger;
import entities.items.interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class BagImpl implements Bag {

    private Passenger passenger;
    private List<Item> items;


    public BagImpl(Passenger passenger, List<Item> items) {
        this.passenger = passenger;
        this.items = items;
    }

    @Override
    public Passenger getOwner() {
        return this.passenger;
    }

    @Override
    public List<Item> getItems() {
        return this.items;
    }
}
