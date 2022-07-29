package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

import java.util.Locale;

/* 
Простая программа
*/

public class SymbolGame extends Game {
    @Override
    public void initialize() {
        String str = "JavaRush";
        setScreenSize(str.length(), 3);
        for(int i = 0; i < str.length(); i++) {
            setCellValueEx(i,1, Color.ORANGE, Character.toString(str.charAt(i)).toUpperCase(Locale.ROOT));
        }
    }
}
