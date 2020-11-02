package pl.bykowski.pracaDomowaT1.model;

import java.math.BigDecimal;
import java.util.Random;

public class Product {
    private String name;
    private Double price;

    public Product(String name) {
        this.name = name;
        this.price = getRandPrice();
    }

    private Double getRandPrice() {
        Random random = new Random();
        return random.nextDouble()*250 + 50;
    }

    @Override
    public String toString() {
        return String.format("Nazwa: %s, cena netto: %1.2f PLN", name, price);
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}
