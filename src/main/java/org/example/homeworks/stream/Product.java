package org.example.homeworks.stream;

public class Product {
    private final String name;
    private final double price;
    private final long volume;

    public Product(String name, double price, long volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public long getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }
}
