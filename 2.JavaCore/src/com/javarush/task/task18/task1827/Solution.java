package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws Exception {
        String trigger = args[0];
        String fileName = getFileName();

        switch (trigger) {
            case "-c":
                addItem(args, fileName);
                break;
            default:
                break;
        }
    }

    private static String getProductName(String[] args) {
        String productName = "";
        for (int i = 1; i < args.length - 2; i++) {
            productName += args[i];
        }
        return productName.trim();
    }


    private static void addItem(String[] args, String fileName) throws IOException {
        int idMax = getMaxId(fileName);
        ArrayList<String> items = getItems(fileName);
        String price = args[args.length - 2];
        String quantity = args[args.length - 1];
        String productName = getProductName(args);
        String item = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", Integer.toString(++idMax), productName, price, quantity);
        items.add(item);
        writeItems(fileName, items);
    }

    private static void writeItems(String fileName, List<String> items) throws IOException {
        PrintWriter writer = new PrintWriter(fileName);
        for (String item : items) {
            writer.println(item);
        }
        writer.close();
    }

    private static ArrayList<String> getItems(String fileName) throws IOException {
        ArrayList<String> items = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            items.add(line);
        }
        reader.close();
        return items;
    }

    private static int getMaxId(String fileName) throws IOException {
        int maxId = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.isEmpty()) {
                if (line.length() > 8) {
                    line = line.substring(0, 8);
                    int id = getId(line);
                    if (id > maxId) maxId = id;
                } else {
                    int id = getId(line);
                    if (id > maxId) maxId = id;
                }
            }
        }
        reader.close();
        return maxId;
    }

    private static int getId(String idString) {
        char[] array = idString.toCharArray();
        ArrayList<Character> resultArray = new ArrayList<>();
        for (char c : array) {
            if (Character.isDigit(c)) {
                resultArray.add(c);
            } else break;
        }
        String resultString = "";
        for (Character character : resultArray) {
            resultString += character;
        }
        return resultString.isEmpty() ? 0 : Integer.parseInt(resultString);
    }

    private static String getFileName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        return fileName;
    }

}
