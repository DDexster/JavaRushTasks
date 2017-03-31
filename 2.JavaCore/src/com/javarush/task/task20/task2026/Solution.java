package com.javarush.task.task20.task2026;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int rectCount = 0;
        // Set for storing coordinates that checked
        Set<Integer> checked = new HashSet<>();

        //walking throw an array
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int pos = i * 10 + j;
                if (!checked.contains(pos)) {
                    if (a[i][j] == 0) {
                        checked.add(pos); //if 0 adding coordinates to set
                    } else {
                        rectCount++;
                        checked.addAll(getRect(a, i, j)); //if has 1 then bring all of it's coordinates to set
                    }
                }
            }
        }
        return rectCount;
    }

    private static Collection<? extends Integer> getRect(byte[][] array, int y, int x) {
        Set<Integer> rectangle = new HashSet<>();
        //finding a X & Y sizes of rectangle
        int i = y;
        int j = x;
        int lenX = 0;
        int lenY = 0;
        while (j < array.length && array[y][j] != 0) {
            lenX++;
            j++;
        }
        while (i < array.length && array[i][x] != 0) {
            lenY++;
            i++;
        }

        //adding rectangle coordinates to set
        for (int k = 0; k < lenY; k++) {
            for (int l = 0; l < lenX; l++) {
                rectangle.add((y + k) * 10 + (x + l));
            }
        }

        return rectangle;
    }
}
