package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Сравниваем модификаторы
*/

final class sss {
    static volatile int g = 0;
    public sss() {
        g=1;
    }
    public static synchronized void fff() {g++;}
}

public class Solution {
    public static void main(String[] args) {
        int classModifiers = sss.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.FINAL));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.FINAL));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        List<String> bytes = Arrays.asList(Integer.toBinaryString(allModifiers).split(""));
        List<String> byteMod = Arrays.asList(Integer.toBinaryString(specificModifier).split(""));
        Collections.reverse(byteMod);
        Collections.reverse(bytes);
        for(int i = 0; i < bytes.size() && i < byteMod.size(); i++) {
            if(bytes.get(i).equals(byteMod.get(i)) && bytes.get(i).equals("1")) return true;
        }
        return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
