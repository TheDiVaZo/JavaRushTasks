package com.javarush.task.task15.task1522;

import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static  {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        String param = new Scanner(System.in).nextLine();
        if(param.equalsIgnoreCase(Planet.EARTH)) {
            thePlanet = Earth.getInstance();
        }
        else if(param.equalsIgnoreCase(Planet.MOON)) {
            thePlanet = Moon.getInstance();
        }
        else if(param.equalsIgnoreCase(Planet.SUN)) {
            thePlanet = Sun.getInstance();
        }
        else thePlanet=null;
    }
}
