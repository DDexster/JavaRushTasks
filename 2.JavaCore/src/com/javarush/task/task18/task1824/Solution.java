package com.javarush.task.task18.task1824;

/*
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        while (true) {
            try {
                fileName = reader.readLine();
                FileInputStream fis = new FileInputStream(fileName);
                fis.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                try {
                    reader.close();
                    return;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println(fileName);
                try {
                    reader.close();
                    return;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ;
            }


        }
    }
}

