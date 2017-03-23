package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
        try {
            System.out.println(new Solution(4));
            File your_file_name = File.createTempFile("JR_Serialize", null);
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(your_file_name));
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(your_file_name));

            Solution savedObject = new Solution(5);
            outputStream.writeObject(savedObject);

            Solution loadedSolution = new Solution(10);
            loadedSolution = (Solution) inputStream.readObject();

            System.out.println(savedObject.string.equals(loadedSolution.string));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Ecxeption");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;


    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
