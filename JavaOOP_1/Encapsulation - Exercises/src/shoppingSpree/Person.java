package shoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bagOfProducts;


    public Person(String name, Double money) {
        setName(name);
        setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getBagOfProducts() {
        return Collections.unmodifiableList(this.bagOfProducts);
    }

    public void buyProduct(Product product) {
        if (product.getPrice() > this.money) {
            throw new IllegalArgumentException(
                    String.format("%s can't afford %s",
                            this.name, product.getName())
            );
        }
        setMoney(this.money - product.getPrice());
        this.bagOfProducts.add(product);
    }

    private String returnAllProductName() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.bagOfProducts.size(); i++) {
            if (i == 0) {
                sb.append(this.bagOfProducts.get(i).getName());
            } else {
                sb.append(", ").append(this.bagOfProducts.get(i).getName());
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s - %s",
                this.name,
                this.bagOfProducts.size() == 0 ? "Nothing bought"
                        : returnAllProductName());
    }
}
