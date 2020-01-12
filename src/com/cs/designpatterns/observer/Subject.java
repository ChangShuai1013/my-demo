package com.cs.designpatterns.observer;

public interface Subject {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notify(String message);
}
