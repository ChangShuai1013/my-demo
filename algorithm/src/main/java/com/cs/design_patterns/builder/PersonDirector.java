package com.cs.design_patterns.builder;

/**
 * author:chang shuai
 * date:2021/4/25
 * time:16:14
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder personBuilder) {
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildFoot();
        return personBuilder.build();
    }
}
