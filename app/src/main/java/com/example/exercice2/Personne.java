package com.example.exercice2;

abstract public class Personne {

    private double height;
    private double weight;
    private double age;

    public Personne(int height, double weight, double age) {
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    abstract public double getMeta();

}
