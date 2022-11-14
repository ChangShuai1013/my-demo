package com.cs.design_patterns.builder;

/**
 * author:chang shuai
 * date:2021/4/25
 * time:16:12
 */
public class ManBuilder implements PersonBuilder {
    private Person person;

    public ManBuilder() {
        this.person = new Man();
    }

    @Override
    public void buildHead() {
        person.setHead("build man head");
    }

    @Override
    public void buildBody() {
        person.setBody("build man body");
    }

    @Override
    public void buildFoot() {
        person.setFoot("build man foot");
    }

    @Override
    public Person build() {
        return person;
    }
}
