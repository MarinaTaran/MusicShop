package com.company;

import com.company.MusicalInstrument;

public class Trumpet extends MusicalInstrument {
    String material;

    public Trumpet(String name, int price, int quantity, String material) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.material = material;

    }

    @Override
    public void info() {
        System.out.println("Trumpet{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", material=" + material +
                '}');
    }

    @Override
    public String toString() {
        return "Trumpet{" +
                "name='" + name + '\'' +
                ", price=" + price + ", material=" + material +
                '}';
    }
}
