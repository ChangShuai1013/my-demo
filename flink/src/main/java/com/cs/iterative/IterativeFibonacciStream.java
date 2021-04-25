package com.cs.iterative;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple5;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.IterativeStream;
import org.apache.flink.streaming.api.datastream.SplitStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * author:chang shuai
 * date:2021/1/21
 * time:15:09
 */
public class IterativeFibonacciStream {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment
                .getExecutionEnvironment().setBufferTimeout(1);
        DataStream<Tuple2<Integer, Integer>> inputStream = env.addSource(new RandomFibonacciSource());

        IterativeStream<Tuple5<Integer, Integer, Integer, Integer, Integer>> iterativeStream = inputStream
                .map(new TupleTransformMapFunction()).iterate(5000);

        DataStream<Tuple5<Integer, Integer, Integer, Integer, Integer>> fibonacciStream = iterativeStream
                .map(new FibonacciCalcStepFunction());

        SplitStream<Tuple5<Integer, Integer, Integer, Integer, Integer>> branchedStream = fibonacciStream
                .split(new FibonacciOverflowSelector());

        iterativeStream.closeWith(branchedStream.select("iterate"));

        DataStream<Tuple3<Integer, Integer, Integer>> outputStream = branchedStream
                .select("output")
                .map(new BuildOutputTupleMapFunction());

        outputStream.print();

        env.execute("IterativeStream Demo");
    }
}
