package com.cs.iterative;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;

/**
 * author:chang shuai
 * date:2021/1/21
 * time:15:09
 */
public class RandomFibonacciSource implements SourceFunction<Tuple2<Integer, Integer>> {
    private Random random = new Random();
    private volatile boolean isRunning = true;
    private int counter = 0;
    private static final int MAX_RANDOM_VALUE = 438;

    @Override
    public void run(SourceContext<Tuple2<Integer, Integer>> ctx) throws Exception {
        while (isRunning && counter < MAX_RANDOM_VALUE) {
            int first = random.nextInt(MAX_RANDOM_VALUE / 2 - 1) + 1;
            int second = random.nextInt(MAX_RANDOM_VALUE / 2 -1) + 1;

            if (first > second) continue;

            ctx.collect(new Tuple2<Integer, Integer>(first, second));
            counter++;
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {

    }
}
