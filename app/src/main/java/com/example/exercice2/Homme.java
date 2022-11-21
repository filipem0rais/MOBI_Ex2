package com.example.exercice2;

public class Homme extends Personne{

    private double height;
    private double weight;
    private double age;


    public Homme(int height, double weight, double age) {
        super(height, weight, age);
    }

    public double getMeta() {
        return 77.607 + (13.707 * this.weight) + (492.3 * this.height) - (6.673 * this.age);
    }
}
