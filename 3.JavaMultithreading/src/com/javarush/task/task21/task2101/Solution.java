package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] NetAddress = new byte[4];
        String[] BinaryIP = new String[]{toBinaryLength(ip[0], 8), toBinaryLength(ip[1], 8), toBinaryLength(ip[2], 8), toBinaryLength(ip[3], 8)};
        String[] BinaryMask = new String[]{toBinaryLength(mask[0], 8), toBinaryLength(mask[1], 8), toBinaryLength(mask[2], 8), toBinaryLength(mask[3], 8)};
        for(int i = 0; i < BinaryIP.length; i++) {
            String byteAddress = "";
            for(int j = 0; j < BinaryIP[i].length(); j++) {
                //System.out.println(BinaryIP[i].charAt(j));
                byteAddress += (BinaryIP[i].charAt(j) - '0') * (BinaryMask[i].charAt(j) - '0');
            }
            NetAddress[i] = (byte) Integer.parseInt(byteAddress, 2);
        }
        return NetAddress;
    }

    public static void print(byte[] bytes) {
        System.out.print(toBinaryLength(bytes[0], 8));
        System.out.print(" ");
        System.out.print(toBinaryLength(bytes[1], 8));
        System.out.print(" ");
        System.out.print(toBinaryLength(bytes[2], 8));
        System.out.print(" ");
        System.out.print(toBinaryLength(bytes[3], 8));
        //System.out.println();
    }

    public static String toBinaryLength(byte number, int length) {
        String BinaryString = Integer.toBinaryString(number);
        if(BinaryString.length() > length) {
            BinaryString = BinaryString.substring(BinaryString.length() - length);
        }
        for(int i = BinaryString.length(); i < length;i++) {
            BinaryString = "0" + BinaryString;
        }
        return BinaryString;
    }
}
