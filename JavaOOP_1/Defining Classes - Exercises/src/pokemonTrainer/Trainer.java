package pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;


    public Trainer(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonList() {
        return this.pokemonList;
    }
    private void loseHealthAndRemovePoke(){
        for (Pokemon pokemon : this.pokemonList) {
            pokemon.setHealth(pokemon.getHealth()-10);
        }
        pokemonList.removeIf(x->x.getHealth()<=0);
    }

    public void checkForBadge(String element) {
        if(this.pokemonList.stream().anyMatch(pokemon -> pokemon.getElement().equals(element))){
            this.badges++;
        }else {
            loseHealthAndRemovePoke();
        }
    }

    public int getBadges() {
        return this.badges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",this.name,getBadges(),
                getPokemonList().size());
    }
}
