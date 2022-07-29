package com.javarush.task.pro.task12.task1212;

/* 
Создаем свой список
*/


public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        String[] new_element = new String[(int) (capacity * 1.5)];

        for(int i = 0; i<capacity;i++) {
            new_element[i] = elements[i];
        }
        elements = new_element;
        capacity = (int) (capacity * 1.5);
    }

    public String[] toArray() {
        return elements;
    }

}
