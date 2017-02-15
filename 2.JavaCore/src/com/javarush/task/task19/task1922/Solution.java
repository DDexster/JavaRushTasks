package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            String line = reader.readLine();
            boolean show = checkLine(line);
            if (show) {
                System.out.println(line);
            }
        }
        reader.close();
    }

    private static boolean checkLine(String line) {
        String[] tokens = line.split(" ");
        int count = 0;
        for (String token : tokens) {
            if (words.contains(token)) {
                count++;
            }
        }
        return count == 2;
    }
}
