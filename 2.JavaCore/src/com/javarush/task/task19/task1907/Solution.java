package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/
/* Файл проверки:      worldworldworld worldlo
        wo
        rld
        world.
        w w , . woo rld. world world 4world world?
        */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String line = "";
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            line += fileReader.readLine() + " ";
        }
        fileReader.close();
        String[] words = line.split("[\\p{Punct} ]");
        int count = 0;
        for (String word : words) {
            if (word.equals("world")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
