package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    private OurPresident() {
    }

    static {
        president = new OurPresident();
        synchronized (president) {
            getOurPresident();
        }
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
