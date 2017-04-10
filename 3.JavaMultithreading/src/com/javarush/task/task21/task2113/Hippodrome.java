package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome() {
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse hors : horses) {
            hors.move();
        }
    }

    public void print() {
        for (Horse hors : horses) {
            hors.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = new Horse();
        double distance = 0;
        for (Horse hors : horses) {
            if (distance<hors.getDistance()){
                distance=hors.getDistance();
                winner = hors;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + this.getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        Horse minnie = new Horse("Minnie", 3, 0);
        Horse mainie = new Horse("Mainie", 3, 0);
        Horse moe = new Horse("Moe", 3, 0);
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(minnie);
        horses.add(mainie);
        horses.add(moe);
        Hippodrome.game = new Hippodrome(horses);

        try {
            game.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        game.printWinner();
    }
}
