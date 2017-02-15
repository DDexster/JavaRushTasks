package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String key = args[0];
        String sourceFile = args[1];
        String targetFile = args[2];

        switch (key) {
            case "-e":
                encryptFile(sourceFile, targetFile);
                break;
            case "-d":
                decryptFile(sourceFile, targetFile);
                break;
            default:
                break;
        }
    }

    private static void decryptFile(String sourceFile, String targetFile) throws IOException {
        FileInputStream fis = new FileInputStream(sourceFile);
        FileOutputStream fos = new FileOutputStream(targetFile, true);
        while (fis.available() > 0) {
            int letter = fis.read() - 10;
            fos.write(letter);
        }
        fis.close();
        fos.close();
    }


    private static void encryptFile(String sourceFile, String targetFile) throws IOException {
        FileInputStream fis = new FileInputStream(sourceFile);
        FileOutputStream fos = new FileOutputStream(targetFile, true);
        while (fis.available() > 0) {
            int letter = fis.read() + 10;
            fos.write(letter);
        }
        fis.close();
        fos.close();
    }


}
