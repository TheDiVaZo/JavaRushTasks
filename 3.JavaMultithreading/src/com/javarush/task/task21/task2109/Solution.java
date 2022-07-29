package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

import java.util.Objects;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new A(i, j);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof A)) return false;
            A a = (A) o;
            return getI() == a.getI() && getJ() == a.getJ();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getI(), getJ());
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof B)) return false;
            if (!super.equals(o)) return false;
            B b = (B) o;
            return Objects.equals(getName(), b.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getName());
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            return new C(getI(), getJ(), getName());
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1,2);
        B b = new B(1, 2, "ахмед");
        C c = new C(1, 2, "ve[fvtl");
        System.out.println(a.clone().equals(a));
        System.out.println(c.clone().equals(c));
    }
}
