package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = reader.readLine();
        String targetFile = reader.readLine();
        reader.close();
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));
        while (fileReader.ready()) {
            strings.add(fileReader.readLine());
        }
        for (String string : strings) {
            string = string.replaceAll("\\.", "!");
            writer.write(string);
            writer.write(System.lineSeparator());
        }
        fileReader.close();
        writer.close();
    }
}
