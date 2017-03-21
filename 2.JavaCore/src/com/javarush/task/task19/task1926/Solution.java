package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> strings = new ArrayList<>();
        while (reader.ready()){
            strings.add(reader.readLine());
        }
        reader.close();
        for (String string : strings) {
            System.out.println(new StringBuilder(string).reverse().toString());
        }
    }
}
