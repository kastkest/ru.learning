package ru.learning.seabattlev;


import java.util.ArrayList;

public class DotCom {

    private String name;

    private ArrayList<String> locationCells;


    public void setLocationCells(ArrayList<String> locationCells) {

        this.locationCells = locationCells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.printf("ОЙ! Вы потопили %s :(", name);
            } else {
                result = "Попал";
            }
        }
        return result;
    }
}


