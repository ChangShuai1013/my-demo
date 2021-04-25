package com.cs.iterative;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple5;

/**
 * author:chang shuai
 * date:2021/1/21
 * time:16:19
 */
public class BuildOutputTupleMapFunction extends RichMapFunction<
        Tuple5<Integer, Integer, Integer, Integer, Integer>,
        Tuple3<Integer, Integer, Integer>> {
    @Override
    public Tuple3<Integer, Integer, Integer> map(Tuple5<Integer, Integer, Integer, Integer, Integer> tuple) throws Exception {
        return new Tuple3<>(tuple.f0, tuple.f1, tuple.f3);
    }
}
