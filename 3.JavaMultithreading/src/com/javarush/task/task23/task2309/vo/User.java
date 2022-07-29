package com.javarush.task.task23.task2309.vo;

import com.javarush.task.task23.task2309.AbstractDbSelectExecutor;

import java.util.List;

public class User extends NamedItem {
    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        }.execute();
    }
}
