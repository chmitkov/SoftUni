package googleEx;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private CarOwned car;
    private List<PokemonOwned> pokemonOwnedList;
    private List<Parents> parentsList;
    private List<Children> childrenList;

    public Person() {
        this.pokemonOwnedList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<PokemonOwned> getPokemonOwnedList() {
        return this.pokemonOwnedList;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CarOwned getCar() {
        return this.car;
    }

    public void setCar(CarOwned car) {
        this.car = car;
    }

    public List<PokemonOwned> getPokemon() {
        return this.pokemonOwnedList;
    }

    public void setPokemon(List<PokemonOwned> pokemon) {
        this.pokemonOwnedList = pokemon;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    private String takeAllFromCollection(List list) {
        if (list.isEmpty()) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            list.forEach(element -> {
                sb.append(element.toString());
                        //.append(System.lineSeparator());
            });
            return sb.toString();
        }
    }


    @Override
    public String toString() {
        return String.format("%s%n" +
                        "Company:%n%s" +
                        "Car:%n%s" +
                        "Pokemon:%n%s" +
                        "Parents:%n%s" +
                        "Children:%n%s",
                getName(),
                this.company == null ? "" : this.company.toString(),
                this.car == null ? "" : this.car.toString(),
                takeAllFromCollection(this.pokemonOwnedList),
                takeAllFromCollection(this.parentsList),
                takeAllFromCollection(this.childrenList)
        );
    }
}
