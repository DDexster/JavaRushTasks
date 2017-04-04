package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        String sourceFile = args[0];
        String targetFile = args[1];
        ArrayList<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        while (reader.ready()) {
            String[] tokens = reader.readLine().split(" ");
            Collections.addAll(words, tokens);
        }
        reader.close();

        FileWriter fileWriter = new FileWriter(targetFile);
        for (String word : words) {
            if (hasDigit(word)){
                fileWriter.write(word+" ");
            }
        }

        fileWriter.close();

    }

    private static boolean hasDigit(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
}
