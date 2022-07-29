package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        for(String line = scanner.nextLine();;line=scanner.nextLine()) {
            Movie movie = MovieFactory.getMovie(line);
            if(movie != null) {
                System.out.println(movie.getClass().getSimpleName());
            }
            else break;

        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            else if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }


    //Напишите тут ваши классы, пункт 3
}
