package com.cs.designpatterns.observer;

public class Main {
    public static void main(String[] args) {
        Subject subject = new SpecificSubject();
        Observer ob1 = new SpecificObserver("1");
        Observer ob2 = new SpecificObserver("2");
        Observer ob3 = new SpecificObserver("3");
        subject.addObserver(ob1);
        subject.addObserver(ob2);
        subject.addObserver(ob3);
        subject.notify("notify");
    }
}
