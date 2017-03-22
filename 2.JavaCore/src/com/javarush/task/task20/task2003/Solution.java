package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(filename);
        Properties props = new Properties();
        this.load(inputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties props = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            props.setProperty(entry.getKey(), entry.getValue());
        }
        props.store(outputStream, "Solution props");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties props = new Properties();
        props.load(inputStream);
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            properties.put(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
}
