package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String source = args[0];
        String target = args[1];

        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(source));
        while (reader.ready()){
            strings.add(reader.readLine());
        }
        reader.close();
        ArrayList<String> words = new ArrayList<>();
        for (String string : strings) {
            for (String s : string.split(" ")) {
                if (s.length()>6) words.add(s);
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(target));

        String result = "";
        for (String word : words) {
            result+=word+",";
        }
        writer.write(result.substring(0, result.length()-1));
        writer.close();
    }
}
