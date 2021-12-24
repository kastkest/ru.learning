package ru.gb.kasterov.hw7;

public class App {
    public static void main(String[] args) {
        Plate plate = new Plate(70);
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Барсик", 10, false);
        cat[1] = new Cat("Обжора", 20, false);
        cat[2] = new Cat("Мурзик", 13, false);
        cat[3] = new Cat("Вискас", 14, false);
        cat[4] = new Cat("Мяукало", 9, false);

        plate.info();
        System.out.println();
        for (Cat value : cat) {
            value.eat(plate);
        }
        plate.increaseFood(10);
        plate.info();
    }
}

