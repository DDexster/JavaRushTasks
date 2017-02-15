package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        List<String> strings = new ArrayList<>();
        while (!line.equals("end")) {
            line = reader.readLine();
            strings.add(line);
        }
        reader.close();
        ArrayList<String> parts = new ArrayList<>();
        for (String string : strings) {
            if (string.contains(".part")) parts.add(string);
        }

        Collections.sort(parts);

        String fileName = parts.get(0);
        int partChar = fileName.indexOf(".part");
        fileName = fileName.substring(0, partChar);

        for (String part : parts) {
            FileInputStream fis = new FileInputStream(part);
            FileOutputStream fos = new FileOutputStream(fileName, true);
            byte[] buff = new byte[fis.available()];
            while (fis.available() > 0) {
                fis.read(buff);
                fos.write(buff);
            }
            fis.close();
            fos.close();
        }
    }

}
