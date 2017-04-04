package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream outputStream) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream inputStream) throws NotSerializableException {

            throw new NotSerializableException();

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        SubSolution subSolution = new SubSolution();
        outputStream.writeObject(subSolution);

        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        subSolution = (SubSolution) objectStream.readObject();
    }
}
