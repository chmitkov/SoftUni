package googleEx;

public class PokemonOwned {
    private String pokemonName;
    private String pokemonType;

    public PokemonOwned(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public String getPokemonName() {
        return this.pokemonName;
    }

    public String getPokemonType() {
        return this.pokemonType;
    }
    @Override
    public String toString() {
        return String.format("%s %s%n", getPokemonName(),getPokemonType());
    }
}
