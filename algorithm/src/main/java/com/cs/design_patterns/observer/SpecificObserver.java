package com.cs.design_patterns.observer;

public class SpecificObserver implements Observer{
    private String name;

    public SpecificObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "\t" + message);
    }
}
