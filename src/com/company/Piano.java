package com.company;

import com.company.MusicalInstrument;

public class Piano extends MusicalInstrument {
    boolean electricInstrument;

    public Piano(String name, int price, int quantity, boolean electricInstrument) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.electricInstrument = electricInstrument;
    }

    @Override
    public void info() {
        System.out.println("Piano{" +
                ", name=" + name +
                ", price=" + price +
                "stringsNumber=" + electricInstrument +
                '}');
    }

    @Override
    public String toString() {
        return "Piano{" +
                ", name=" + name +
                ", price=" + price +
                "stringsNumber=" + electricInstrument +
                '}';
    }
}
