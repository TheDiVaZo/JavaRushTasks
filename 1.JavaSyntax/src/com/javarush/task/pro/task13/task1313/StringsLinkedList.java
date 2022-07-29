package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        if (first.next == null) {
            Node elem = new Node();
            elem.next = null;
            elem.value = value;
            elem.prev = null;
            first.next = elem;
            last.prev = elem;
        }
        else {
            add(value, first);
        }

    }

    private void add(String value, Node prev_elm) {
        if(prev_elm.next == null) {
            Node elem = new Node();
            elem.next = null;
            elem.value = value;
            elem.prev = prev_elm;
            prev_elm.next = elem;
            last.prev = elem;
            return;
        }
        else {
            add(value, prev_elm.next);
        }

    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
