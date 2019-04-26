package entities;

import entities.interfaces.Bag;
import entities.interfaces.Passenger;
import entities.items.interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class BagImpl implements Bag {

    private Passenger passenger;
    private List<Item> items;


    public BagImpl(Passenger passenger) {
        this.passenger = passenger;
        this.items = new ArrayList<>();
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
