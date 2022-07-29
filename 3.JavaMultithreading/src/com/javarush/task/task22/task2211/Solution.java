package com.javarush.task.task22.task2211;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String path2 = args[1];
        FileInputStream FileInputStream = new FileInputStream(path);
        byte[] file_1 = new byte[FileInputStream.available()];
        FileInputStream.read(file_1);
        String StringFile_1 = new String(file_1, "windows-1251");
        byte[] file_2 = StringFile_1.getBytes(Charset.forName("UTF-8"));
        FileOutputStream FileOutputStream = new FileOutputStream(path2);
        FileOutputStream.write(file_2);
    }
}
