package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> personMap = new HashMap<>();
        Map<String, Product> productMap = new HashMap<>();

        String[] persons = br.readLine().split(";");
        for (String p : persons) {
            String name = p.split("=")[0];
            double money = Double.parseDouble(p.split("=")[1]);
            try {
                personMap.put(name, new Person(name, money));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
        String[] products = br.readLine().split(";");
        for (String prod : products) {
            String name = prod.split("=")[0];
            double price = Double.parseDouble(prod.split("=")[1]);
            try {
                productMap.put(name, new Product(name, price));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
        String line = br.readLine();

        while (!"END".equals(line)) {
            String[] commands = line.split("\\s+");
            String personName = commands[0];
            String productName = commands[1];
            Person currPerson = personMap.get(personName);
            Product currProduct = productMap.get(productName);
            try {
                currPerson.buyProduct(currProduct);
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            line = br.readLine();
        }

        personMap.values().forEach(System.out::println);
    }
}
