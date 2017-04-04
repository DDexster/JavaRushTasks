package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        initMap(fis, freqMap);
        for (Map.Entry<Integer, Integer> set : freqMap.entrySet()) {
            int c = set.getKey();
            int freq = set.getValue();
            System.out.println(((char) c) + " " + freq);
        }

    }

    private static void initMap(FileInputStream fis, TreeMap<Integer, Integer> freqMap) throws IOException {
        while (fis.available() > 0) {
            int letter = fis.read();
            if (!freqMap.containsKey(letter)) {
                freqMap.put(letter, 1);
            } else {
                int count = freqMap.get(letter);
                count++;
                freqMap.put(letter, count);
            }
        }
        fis.close();
    }
}
