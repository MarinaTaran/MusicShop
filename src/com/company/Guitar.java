package com.company;

public class Guitar extends MusicalInstrument {
    byte stringsNumber;

    public Guitar(String name, int price, int quantity, byte stringsNumber) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.stringsNumber = stringsNumber;
    }

    @Override
    public void info() {
        System.out.println("Guitar{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                "stringsNumber=" + stringsNumber +
                '}');
    }

    @Override
    public String toString() {
        return "Guitar{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                "stringsNumber=" + stringsNumber +
                '}';
    }
}
