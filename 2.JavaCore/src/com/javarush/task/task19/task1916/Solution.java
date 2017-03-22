package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = br.readLine();
        String filename2 = br.readLine();
        br.close();

        ArrayList<String> file1 = getStrings(filename1);
        ArrayList<String> file2 = getStrings(filename2);

        lines = makeSomeNoize(file1, file2);

        printComplexList(lines);
    }

    private static List<LineItem> makeSomeNoize(ArrayList<String> file1, ArrayList<String> file2) {
        ArrayList<LineItem> lineItems = new ArrayList<>();
        for (int i = 0; i < file1.size(); i++) {
            if (!file2.isEmpty() && file1.get(i).equals(file2.get(0))) {
                lineItems.add(new LineItem(Type.SAME, file1.get(i)));
                file2.remove(0);
            } else if (file2.size() > 1 && file1.get(i).equals(file2.get(1))) {
                lineItems.add(new LineItem(Type.ADDED, file2.get(0)));
                file2.remove(0);
                i--;
            } else {
                lineItems.add(new LineItem(Type.REMOVED, file1.get(i)));
            }
        }
        if (!file2.isEmpty()) {
            while (!file2.isEmpty()) {
                lineItems.add(new LineItem(Type.ADDED, file2.get(0)));
                file2.remove(0);
            }
        }

        return lineItems;
    }


    private static void printComplexList(List<LineItem> lines) {
        for (LineItem line : lines) {
            System.out.println(line.type + " " + line.line);
        }
    }

    private static void printList(ArrayList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> getStrings(String filename) throws IOException {
        ArrayList<String> res = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (reader.ready()) {
            res.add(reader.readLine());
        }
        reader.close();
        return res;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
