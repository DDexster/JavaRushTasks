package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> strings = new ArrayList<>();
        while (reader.ready()) {
            strings.add(reader.readLine());
        }
        reader.close();
        TreeMap<String, Double> map = new TreeMap<>();
        for (String string : strings) {
            String[] tokens = string.split(" ");
            String name = tokens[0];
            double num = Double.parseDouble(tokens[1]);
            if (map.containsKey(name)) {
                double number = map.get(name);
                number += num;
                map.put(name, number);
            } else {
                map.put(name, num);
            }
        }

        for (Map.Entry<String, Double> set : map.entrySet()) {
            System.out.println(set.getKey() + " " + set.getValue());
        }
    }
}
