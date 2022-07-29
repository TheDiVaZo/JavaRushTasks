package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        URL url = new URL(reader.readLine()+"&");
        List<String> rr = Arrays.asList(url.getQuery().split("(=[0-9a-z.A-Z]+)?&"));
        System.out.println(String.join(" ", rr));
        if(rr.indexOf("obj") != -1) {
            String mydata = url.getQuery();
            Matcher matcher = Pattern.compile("obj=([a-zA-Z0-9.]+)").matcher(mydata);

            if (matcher.find())
            {
                try {
                    alert(Double.valueOf(matcher.group(1)));
                }
                catch (Throwable e) {
                    alert((matcher.group(1)));
                }
            }

        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
