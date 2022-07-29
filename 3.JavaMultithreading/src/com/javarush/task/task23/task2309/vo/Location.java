package com.javarush.task.task23.task2309.vo;

import com.javarush.task.task23.task2309.AbstractDbSelectExecutor;

import java.util.List;

public class Location extends NamedItem {
    public List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        }.execute();
    }
}
