package com.example.exercice2;

public class Femme extends Personne{

    private double height;
    private double weight;
    private double age;


    public Femme(int height, double weight, int age) {
        super(height, weight, age);
    }

    public double getMeta() {
        return 667.051 + (13.707 * this.weight) + (492.3 * this.height) - (6.673 * this.age);
    }
}
