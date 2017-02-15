package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream fis1 = new FileInputStream(file1);
        byte[] buf1 = new byte[fis1.available()];
        fis1.read(buf1);
        fis1.close();
        FileInputStream fis2 = new FileInputStream(file2);
        byte[] buf2 = new byte[fis2.available()];
        fis2.read(buf2);
        fis2.close();
        byte[] total = new byte[buf1.length + buf2.length];
        System.arraycopy(buf2, 0, total, 0, buf2.length);
        System.arraycopy(buf1, 0, total, buf2.length, buf1.length);

        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(total);
        fos.close();
    }
}
