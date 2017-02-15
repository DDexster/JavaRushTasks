package com.javarush.task.task18.task1816;

/*
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int count = 0;
        while (fis.available() > 0) {
            int letter = fis.read();
            if ((letter >= 65 && letter <= 90) || (letter >= 97 && letter <= 122)) {
                count++;
            }
        }
        System.out.println(count);
        fis.close();
    }
}
