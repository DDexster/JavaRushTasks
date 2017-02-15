package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> strings = new ArrayList<>();
        while (reader.ready()) {
            strings.add(reader.readLine());
        }
        reader.close();
        Map<String, Double> map = new HashMap<>();
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
        double maxSalary = 0;
        for (Double aDouble : map.values()) {
            if (aDouble > maxSalary) maxSalary = aDouble;
        }

        for (String name : map.keySet()) {
            if (map.get(name) == maxSalary) {
                System.out.println(name);
            }
        }
    }
}
