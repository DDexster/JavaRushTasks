package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> strings = new ArrayList<>();
        while (reader.ready()) {
            strings.add(reader.readLine());
        }
        reader.close();
        for (String string : strings) {
            String[] data = string.split(" ");
            String name = getNameString(data);
            Date date = getDateString(data);
            PEOPLE.add(new Person(name, date));
        }

        for (Person person : PEOPLE) {
            System.out.println(person.getName() + " " + person.getBirthday());
        }
    }

    private static Date getDateString(String[] data) throws ParseException {
        Calendar c = new GregorianCalendar();
        c.set(Integer.parseInt(data[data.length - 1]), Integer.parseInt(data[data.length - 2]) - 1,
                Integer.parseInt(data[data.length - 3]));
        return c.getTime();
    }

    private static String getNameString(String[] data) {
        String name = "";
        for (int i = 0; i < data.length - 3; i++) {
            name += data[i] + " ";
        }
        return name.trim();
    }
}
