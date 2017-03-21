package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tag = args[0];
        String filename = getFileName();

        ArrayList<String> strings = getStrings(filename);

        ArrayList<String> parsedLines = parseLines(strings, tag);

        printResults(parsedLines);

    }

    private static void printResults(ArrayList<String> parsedLines) {
        for (String parsedLine : parsedLines) {
            System.out.println(parsedLine);
        }
    }

    private static ArrayList<String> parseLines(ArrayList<String> strings, String tag) {
        ArrayList<String> result = new ArrayList<>();

        return result;
    }

    private static int getStrCount(String line, String elem) {
        int result = 0;
        if (line.contains(elem)) {
            String[] elements = line.split(" ");
            for (String element : elements) {
                if (element.contains(elem)) result++;
            }
            return result;
        } else return 0;

    }

    private static String getFileName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        return filename;
    }

    private static ArrayList<String> getStrings(String filename) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            line = cleanLine(line);
            strings.add(line);
        }
        br.close();
        return strings;
    }

    private static String cleanLine(String line) {
        return line.replaceAll("\\n|\\t", " ").replaceAll("\\s+", " ");

    }
}
