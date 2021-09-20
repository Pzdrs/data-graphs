package me.pzdrs.dataGraphs;

public class Person {
    private String name;
    private double iq;

    public Person(String name, double iq) {
        this.name = name;
        this.iq = iq;
    }

    public String getName() {
        return name;
    }

    public double getIq() {
        return iq;
    }
}
