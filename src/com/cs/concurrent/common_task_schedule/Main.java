package com.cs.concurrent.common_task_schedule;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TaskEngine engine = TaskEngine.getInstance();
        AbstractTask task = new AbstractTask() {
            @Override
            public void run() {
                //do something
            }
        };
        //添加任务
        engine.schedule(task, 0, TimeUnit.SECONDS.toSeconds(1000));
        //移除任务
        engine.cancelScheduledTask(task);
    }
}
