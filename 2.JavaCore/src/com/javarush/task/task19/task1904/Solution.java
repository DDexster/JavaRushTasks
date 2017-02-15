package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(new File("file.txt"));
//        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
//        System.out.println(personScannerAdapter.read().toString());
//        personScannerAdapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] sPerson = fileScanner.nextLine().split(" ");
//            for (String s : sPerson) {
//                System.out.println(s);
//            }
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
            Date birthDate = null;
            try {
                birthDate = sdf.parse(sPerson[3] + sPerson[4] + sPerson[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(sPerson[1], sPerson[2], sPerson[0], birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
