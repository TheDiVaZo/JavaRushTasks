package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream file3Stream = null;
        Scanner scanner = new Scanner(System.in);
        String file1Path = scanner.nextLine();
        String file2Path = scanner.nextLine();
        scanner.close();
        try (
                FileInputStream file1 = new FileInputStream(file1Path);
                FileInputStream file2 = new FileInputStream(file2Path);
                ) {
            byte[] file1Byte = new byte[file1.available()];
            byte[] file2Byte = new byte[file2.available()];
            file1.read(file1Byte);
            file2.read(file2Byte);
            file3Stream = new ByteArrayOutputStream();
            file3Stream.write(file2Byte);
            file3Stream.write(file1Byte);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(file3Stream != null) {
                try (
                        FileOutputStream file1 = new FileOutputStream(file1Path)
                        ) {
                    file3Stream.writeTo(file1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
