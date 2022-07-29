package com.javarush.task.task23.task2309.vo;

import com.javarush.task.task23.task2309.AbstractDbSelectExecutor;

import java.util.List;

public class Subject extends NamedItem {
    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        }.execute();
    }
}
