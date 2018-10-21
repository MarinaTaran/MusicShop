package com.company;

public class MusicalInstrument {
    String name;
    int price;
    int quantity;

    public MusicalInstrument(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public MusicalInstrument() {
    }

    public void info(){};

    @Override
    public String toString() {
        return "MusicalInstrument{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
