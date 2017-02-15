package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = reader.readLine();
        String targetFile = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(sourceFile);
        FileWriter fileWriter = new FileWriter(targetFile);
        int i = 1;
        while (fileReader.ready()) {
            int letter = fileReader.read();
            if (i % 2 == 0) {
                fileWriter.write(letter);
            }
            i++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
