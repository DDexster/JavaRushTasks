
package com.javarush.task.task20.task2025;

import java.util.Date;
import java.util.LinkedList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        LinkedList<Integer> armstrongList = new LinkedList<>();
        long[] result = null;
        int stage = 10;
        long[] pows = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 1; i < N; i++) {
            if (i == stage) {
                stage *= 10;
                for (int j = 0; j < pows.length; j++) {
                    pows[j] *= j;
                }
            }
            if (isArmstrong(i, pows)) {
                armstrongList.add(i);
            }

        }
        result = new long[armstrongList.size()];
        for (int j = 0; j < result.length; j++) {
            result[j] = armstrongList.get(j);
        }
        return result;
    }

    private static boolean isArmstrong(int num, long[] pows) {
        int arms = num;
        int sum = 0;
        while (num >= 1) {
            sum += pows[num % 10];
            if (sum > arms) return false;
            num = num / 10;
        }
        return arms == sum;
    }


    public static void main(String[] args) {
        long start = new Date().getTime();
        long stMem = Runtime.getRuntime().freeMemory();
        long[] res = Solution.getNumbers(912_985_153);
        long end = new Date().getTime();
        long stopMem = Runtime.getRuntime().totalMemory();
        System.out.println("Items:");
        for (long re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
        System.out.println("Time: " + (end - start) / 1000 + "s");
        System.out.println("Memory: " + (stopMem - stMem) / 1024 / 1024 + "MB");

    }

}
