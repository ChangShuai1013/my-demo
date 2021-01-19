package com.cs.design_patterns.observer;

public interface Subject {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notify(String message);
}
