package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = reader.readLine();
        String targetFile = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));

        ArrayList<String> strings = new ArrayList<>();
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            strings.add(line);
        }

        for (String string : strings) {
            string = string.replaceAll("[\\p{Punct}]", "");
            writer.write(string);
        }
        fileReader.close();
        writer.close();
    }
}
