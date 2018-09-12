package shoppingSpree;

public class Product {
    private String name;
    private double price;

    public Product(String name, Double price) {
        setName(name);
        setPrice(price);
    }

    private void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
