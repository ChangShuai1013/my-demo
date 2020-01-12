package com.cs.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class SpecificSubject implements Subject {
    private List<Observer> list = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : list) {
            observer.update(message);
        }
    }
}
