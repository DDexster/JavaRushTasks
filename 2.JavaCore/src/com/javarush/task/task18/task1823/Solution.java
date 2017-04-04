package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        ArrayList<String> fileNames = new ArrayList<>();
        while (!filename.equals("exit")) {
            fileNames.add(filename);
            filename = reader.readLine();
        }

        for (String fileName : fileNames) {
            ReadThread thread = new ReadThread(fileName);
            thread.start();
        }
//        System.out.println(resultMap);


    }

    public static class ReadThread extends Thread {
        private String filename;

        public ReadThread(String fileName) {
            //implement constructor body
            this.filename = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(this.filename);
                HashMap<Integer, Integer> map = getCharMap(fis);
                fis.close();
                int maxValue = getMaxValue(map);
                for (Integer key : map.keySet()) {
                    if (map.get(key) == maxValue) resultMap.put(filename, key);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static int getMaxValue(HashMap<Integer, Integer> map) {
        int maxValue = 0;
        for (Integer value : map.values()) {
            if (value > maxValue) maxValue = value;
        }
        return maxValue;
    }

    private static HashMap<Integer, Integer> getCharMap(FileInputStream fis) throws IOException {
        HashMap<Integer, Integer> map = new HashMap<>();
        while (fis.available() > 0) {
            int letter = fis.read();
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                int counter = map.get(letter);
                counter++;
                map.put(letter, counter);
            }
        }
        return map;
    }
}
