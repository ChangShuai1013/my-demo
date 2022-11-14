package com.cs.design_patterns.builder;

/**
 * author:chang shuai
 * date:2021/4/25
 * time:16:10
 */
public interface PersonBuilder {
    void buildHead();
    void buildBody();
    void buildFoot();
    Person build();
}
