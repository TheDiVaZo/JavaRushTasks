package com.javarush.task.task23.task2309.vo;

import com.javarush.task.task23.task2309.AbstractDbSelectExecutor;

import java.util.List;

public class Subscription extends NamedItem {
    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        }.execute();
    }
}
