package com.javarush.task.pro.task15.task1504;


import java.io.IOException;
import java.nio.file.Files;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path1 = scanner.nextLine();
        String path2 = scanner.nextLine();
        scanner.close();

        try (
                var input = Files.newInputStream(Paths.get(path1));
                var output = Files.newOutputStream(Paths.get(path2));
                ) {
            byte[] ByteIN = input.readAllBytes();
            byte[] ByteOUT = new byte[ByteIN.length];
            for (int i = 0; i < ByteIN.length; i+=2) {
                if (i < ByteIN.length - 1) {
                    ByteOUT[i] = ByteIN[i+1];
                    ByteOUT[i+1] = ByteIN[i];
                }
                else {
                    ByteOUT[i] = ByteIN[i];
                }
            }
            output.write(ByteOUT);

        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }



    }
}

