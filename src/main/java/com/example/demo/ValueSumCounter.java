package com.example.demo;

import com.example.demo.node.Node;

import java.util.*;
import java.util.concurrent.RecursiveTask;

public class ValueSumCounter extends RecursiveTask<Long> {


    private final Node node;

    public ValueSumCounter(Node node) {
        this.node = node;
    }

    @Override
    protected Long compute() {
        long sum = node.getValue();
        List<ValueSumCounter> subTasks = new LinkedList<>();

        if (Objects.nonNull(node.getChildren())) {
            for(Node child : node.getChildren()) {
                ValueSumCounter task = new ValueSumCounter(child);
                task.fork();
                subTasks.add(task);
            }

            for(ValueSumCounter task : subTasks) {
                sum += task.join();
            }
        }

        System.out.println(Thread.currentThread().getName() + ": " + sum);
        return sum;
    }
}
