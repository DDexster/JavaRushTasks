package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        testString.printSomething();

        String lines = outputStream.toString();

        System.setOut(consoleStream);


        System.out.println(makeContext(lines));


    }

    private static String makeContext(String lines) {
        String result="";

        char [] array = lines.toCharArray();
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]=='\n'){
                count++;
                if(count%2==0){
                    result+="\nJavaRush - курсы Java онлайн";
                }
                result+="\n";
            } else {
                result+=array[i];
            }
        }


        return result;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
