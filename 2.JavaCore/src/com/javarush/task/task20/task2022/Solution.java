package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String filename;

    public Solution(String fileName) throws FileNotFoundException {
        this.filename = fileName;
        this.stream = new FileOutputStream(filename);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.writeObject(filename);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(filename, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("filename");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            Solution serializ = new Solution("serializ");

            serializ.writeObject("String");

            serializ.writeObject(objectOutputStream);

            outputStream.close();
            objectOutputStream.close();
            FileInputStream fileInputStream = new FileInputStream("filename");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            Solution serializ2 = new Solution("ser2");

            serializ2.readObject(inputStream);

            serializ2.writeObject("Second string");
            fileInputStream.close();
            objectOutputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
