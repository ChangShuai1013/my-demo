package com.cs.iterative;

import org.apache.flink.api.java.tuple.Tuple5;
import org.apache.flink.streaming.api.collector.selector.OutputSelector;

import java.util.Collections;

/**
 * author:chang shuai
 * date:2021/1/21
 * time:15:27
 */
public class FibonacciOverflowSelector implements OutputSelector<Tuple5<Integer, Integer, Integer, Integer, Integer>> {
    private static final int BOUND = 10;
    @Override
    public Iterable<String> select(Tuple5<Integer, Integer, Integer, Integer, Integer> value) {
        if (value.f4 < BOUND) {
            return Collections.singleton("iterate");
        } else {
            return Collections.singleton("output");
        }
    }
}
