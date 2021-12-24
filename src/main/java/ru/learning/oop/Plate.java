package ru.gb.kasterov.hw7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }


    public void decreaseFood(int n) {
        if (isNotEmpty(n)) {
            food -= n;
        }
    }

    public boolean isNotEmpty(int n) {
        return food > 0 && food >= n;
    }

    public void increaseFood(int n) {
        if (n > 0) {
            System.out.println("Добавляем еду =)");
            food += n;
        } else {
            System.out.println("Кол-во добавляемой еды не может быть отрицательным или равно нулю.");
        }
    }


    public void info() {
        System.out.println("В тарелке " + food + " еды.");
    }
}
