package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = reader.readLine();
        String targetFile = reader.readLine();
        reader.close();

        roundDigits(sourceFile, targetFile);
    }

    private static void roundDigits(String sourceFile, String targetFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        String line = reader.readLine();
        reader.close();
        String[] tokens = line.split(" ");
        ArrayList<BigDecimal> bigDecimals = new ArrayList<>();
        for (String token : tokens) {
            double get = Double.parseDouble(token);
            BigDecimal rounded = null;
            if (get > 0) {
                rounded = new BigDecimal(get).setScale(0, RoundingMode.HALF_UP);
            } else {
                rounded = new BigDecimal(get).setScale(0, RoundingMode.HALF_DOWN);
            }
            bigDecimals.add(rounded);
        }

        FileWriter fileWriter = new FileWriter(targetFile, true);
        for (BigDecimal bigDecimal : bigDecimals) {
            fileWriter.write(bigDecimal.toString() + " ");
        }
        fileWriter.close();

    }
}

