package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String trigger = args[0];
        String filename = getFileName();
        switch (trigger) {
            case "-u":
                updateItem(args, filename);
                break;
            case "-d":
                deleteItem(args, filename);
                break;
            default:
                break;
        }
    }

    private static void deleteItem(String[] args, String filename) throws IOException {
        String id = args[1];
        ArrayList<String> items = getItems(filename);
        ArrayList<String> updatedItems = makeDelete(items, id);
        writeFile(filename, updatedItems);
    }

    private static ArrayList<String> makeDelete(ArrayList<String> items, String id) {
        ArrayList<String> updatedItems = new ArrayList<>();
        for (String item : items) {
            if (id.length() == 8) {
                if (item.startsWith(id)) {
                } else {
                    updatedItems.add(item);
                }
            } else {
                if (item.startsWith(id + " ")) {
                } else {
                    updatedItems.add(item);
                }
            }
        }
        return updatedItems;
    }

    private static String getFileName() throws IOException {
        String file;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file = reader.readLine();
        reader.close();
        return file;

    }

    private static void updateItem(String[] args, String filename) throws IOException {
        String id = args[1];
        String price = args[args.length - 2];
        String quantity = args[args.length - 1];
        String productName = getProductName(args);
        String updatedItem = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", id, productName, price, quantity);
        ArrayList<String> items = getItems(filename);
        ArrayList<String> updatedItems = makeUpdate(items, id, updatedItem);
        writeFile(filename, updatedItems);

    }

    private static ArrayList<String> makeUpdate(ArrayList<String> items, String id, String updatedItem) {
        ArrayList<String> updatedItems = new ArrayList<>();
        for (String item : items) {
            if (id.length() == 8) {
                if (item.startsWith(id)) {
                    updatedItems.add(updatedItem);
                } else {
                    updatedItems.add(item);
                }
            } else {
                if (item.startsWith(id + " ")) {
                    updatedItems.add(updatedItem);
                } else {
                    updatedItems.add(item);
                }
            }
        }
        return updatedItems;
    }

    private static void writeFile(String filename, ArrayList<String> items) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        for (String item : items) {
            writer.println(item);
        }
        writer.close();

    }


    private static ArrayList<String> getItems(String filename) throws IOException {
        ArrayList<String> items = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            items.add(line);
        }
        reader.close();
        return items;
    }

    private static String getProductName(String[] args) {
        String productName = "";
        for (int i = 2; i < args.length - 2; i++) {
            productName += args[i];
        }
        return productName.trim();
    }

}
