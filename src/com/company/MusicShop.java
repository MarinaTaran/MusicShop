/*
Музыкальный магазин.

1.	Создать программу с классами Гитара, Фортепиано, Труба, используя класс Музыкальный инструмент. Открыть Музыкальный
 магазин.
2.	Добавить в магазин инструментов метод, который готовит к отгрузке партию музыкальных инструментов согласно заказу.

Сигнатура метода:
public List<Instrument> prepareInstruments(Map<String, Integer> order){...}

В заказе (Map<String, Integer> order) хранится название инструмента и количество необходимых инструментов.

Ключем в заказе является одна из строк "piano", "guitar", "trumpet"

Создать свое исключение, которое будет брошено в случае, когда ключ в заказе другой.

Каким-то образом (самостоятельно выбрать решение) обработать ситуацию, когда количество элементов в заказе отрицательное
, нулевое.

После выполнения метода из магазина должны пропасть те инструменты, которые были отгружены.
В случае, когда количество запрашиваемых инструментов определенного типа больше, чем количество доступных инструментов
 в магазине, должно быть брошено исключение. Выбрать наиболее подходящее из доступных в стандартной библиотеке исключений
Пример:
1.	в магазине было 2 фортепиано, 16 гитар и 7 труб.
2.	пришел заказ на 7 гитар и 2 трубы.
3.	после выполнения заказа в магазине осталось 2 фортепиано, 9 гитар и 5 труб
4.	пришел заказ на 1 фортепиано
5.	после выполнения заказа в магазине осталось 1 фортепиано, 9 гитар и 5 труб
6.	пришел заказ на 1 фортепиано, 8 гитар и 6 труб
7.	товар не был отгружен (было брошено исключение)
в магазине осталось 1 фортепиано, 9 гитар и 5 труб
*/

package com.company;

import java.util.*;

public class MusicShop {
    List<MusicalInstrument> store = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        MusicalInstrument piano = new Piano("piano", 120000, 2, false);
        MusicalInstrument guitar = new Guitar("guitar", 15000, 16, (byte) 7);
        MusicalInstrument trumpet = new Trumpet("trumpet", 3000, 7, "bronze");
        store.add(piano);
        store.add(guitar);
        store.add(trumpet);

        int choose = 0;
        do {
            System.out.println("Enter: 1 - sale, 2 - report, 0 - exit ");
            if (scanner.hasNextInt()) {
                choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        sale();
                        break;
                    case 2:
                        report();
                        break;
                }
            }
        } while (choose != 0);
    }

    private void report() {
        for (MusicalInstrument m : store) {
            m.info();
        }
    }

    private void sale() {
        int continueSale;

        do {
            System.out.println("Enter: 1 - do sale, 0 - exit to main menu!");
            continueSale = scanner.nextInt();
            Map<String, Integer> nextOrder = null;
            if (continueSale == 1) {
                nextOrder = new HashMap<>();
                String continueOrder = null;
                scanner.nextLine();

                do {
                    System.out.println("Which instrument do you want to add into the order?");
                    System.out.println("Enter instruments name!");
                    String instrumentsName = scanner.nextLine();
                    boolean flag = true;
                    for (MusicalInstrument mi : store) {
                        if (mi.name.equals(instrumentsName)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        //todo vibrasivaem svoe iskluchenie
                        System.out.println("there isn't such instrument!");
                        continue;
                    }
                    System.out.println("How many do you want?");
                    int instrumentsQuantity = scanner.nextInt();
                    nextOrder.put(instrumentsName, instrumentsQuantity);
                    scanner.nextLine();
                    System.out.println("Anything else? y/n");
                    continueOrder = scanner.nextLine();
                } while (continueOrder.equals("y"));
                //  peredaem nextOrder v metod prepareInstrument dlya podgotovki instr. k otgruzke
                List<MusicalInstrument> busket = prepareInstruments(nextOrder);
                if (busket != null) {
                    int chek = 0;
                    for (MusicalInstrument musicalInstrument : busket) {
                        chek += musicalInstrument.quantity * musicalInstrument.price;
                        System.out.println(musicalInstrument.toString());
                    }
                    System.out.println("To pay = " + chek);
                    System.out.println("did you get mony? y/n");
                    String getMony = scanner.nextLine();
                    if (getMony.equals("y")) {
                        System.out.println("thanks fore buy");
                        for (MusicalInstrument i : store) {
                            for (MusicalInstrument m : busket) {
                                if (i.name.equals(m.name)) {
                                    i.quantity -= m.quantity;
                                }
                            }
                        }
                    } else {
                        System.out.println("Order is closed");
                    }
                }
            }
        } while (continueSale == 1);

    }

    public List<MusicalInstrument> prepareInstruments(Map<String, Integer> nextOrder) {
        List<MusicalInstrument> busket = new LinkedList<>();

        for (MusicalInstrument temp : store) {
            if (nextOrder.containsKey(temp.name)) {
                MusicalInstrument musicalInstrument = new MusicalInstrument(temp.name, temp.price, nextOrder.get(temp.name));
                if (temp.quantity >= musicalInstrument.quantity) {
                    busket.add(musicalInstrument);
                } else {
                    //  vibrosit iskluchenie
                    try {
                        throw new IllegalAccessException("We don't have enough instrument at store! That is why order is canceled! ");
                    } catch (IllegalAccessException i) {
                        System.out.println(i.getMessage());
                        return null;
                    }

                }
            }
        }
        return busket;
    }


}
