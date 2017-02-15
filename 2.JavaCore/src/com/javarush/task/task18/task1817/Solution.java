package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);

        int charCount = 0;
        int spaceCount = 0;
        while (fis.available() > 0) {
            charCount++;
            int letter = fis.read();
            if (letter == 32) spaceCount++;
        }

        fis.close();
        double result = (double) spaceCount / (double) charCount * 100;
        System.out.println(String.format("%.2f", result));
    }
}
