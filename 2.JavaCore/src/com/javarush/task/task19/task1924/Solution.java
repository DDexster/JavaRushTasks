package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static
    {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            strings.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        for (String string : strings) {
            string = doString(string);
            System.out.println(string);
        }


    }

    private static String doString(String string) {
        String result = "";
        for (String s : string.split(" ")) {
            if (isMapNumber(s)) {
                result += map.get(Integer.parseInt(s)) + " ";
            } else {
                result += s + " ";
            }
        }
        return result.trim();
    }

    private static boolean isMapNumber(String s) {
        try {
            int a = Integer.parseInt(s);
            if (a >= 0 && a <= 12) {
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }

}
