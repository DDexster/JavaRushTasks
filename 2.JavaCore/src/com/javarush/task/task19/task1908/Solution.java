package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = reader.readLine();
        String targetFile = reader.readLine();
        reader.close();
        String line = "";
        BufferedReader fileReader = new BufferedReader(new FileReader(sourceFile));
        while (fileReader.ready()) {
            line += fileReader.readLine() + " ";
        }
        String[] words = line.split(" ");
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(targetFile));
        for (String word : words) {
            if (isItNumber(word)) {
                fileWriter.write(word + " ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }

    private static boolean isItNumber(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
