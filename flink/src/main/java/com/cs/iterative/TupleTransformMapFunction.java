package com.cs.iterative;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple5;

/**
 * author:chang shuai
 * date:2021/1/21
 * time:15:15
 */
public class TupleTransformMapFunction extends RichMapFunction<Tuple2<Integer, Integer>, Tuple5<Integer, Integer, Integer, Integer, Integer>> {

    @Override
    public Tuple5<Integer, Integer, Integer, Integer, Integer> map(Tuple2<Integer, Integer> tuple) throws Exception {
        return new Tuple5<>(tuple.f0, tuple.f1, tuple.f0, tuple.f1, 0);
    }
}
