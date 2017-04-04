package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileInputStream fis2 = new FileInputStream(file2);
        byte[] buf2 = new byte[fis2.available()];
        fis2.read(buf2);
        fis2.close();

        FileInputStream fis3 = new FileInputStream(file3);
        byte[] buf3 = new byte[fis3.available()];
        fis3.read(buf3);
        fis3.close();

        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(buf2);
        fos.close();

        FileOutputStream fos1 = new FileOutputStream(file1, true);
        fos1.write(buf3);
        fos1.close();
    }
}
