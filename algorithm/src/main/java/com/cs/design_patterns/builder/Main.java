package com.cs.design_patterns.builder;

/**
 * author:chang shuai
 * date:2021/4/25
 * time:16:16
 */
public class Main {
    public static void main(String[] args) {
        PersonDirector personDirector = new PersonDirector();
        Person man = personDirector.constructPerson(new ManBuilder());
    }
}
