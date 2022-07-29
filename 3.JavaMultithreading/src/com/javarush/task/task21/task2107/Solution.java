package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();

            System.out.println(solution.hashCode());
            System.out.println(clone.hashCode());

            System.out.println(solution.users.equals(clone.users));
            System.out.println(clone.users.hashCode());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return new User(age, name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution solClone = new Solution();
        Set<Map.Entry<String, User>> set = users.entrySet();
        for(Map.Entry<String, User> entry: set) {
            solClone.users.put(new String(entry.getKey()), entry.getValue().clone());
        }
        return solClone;
    }
}
