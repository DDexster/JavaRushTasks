package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "sd", "se", "sa", "sg", "sn", "sl", "su", "sf");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordsList = new ArrayList<>();
        for (String text : words) {
            Word word = new Word(text);
            int[] coordinates = getCoordinates(crossword, text);
            word.setStartPoint(coordinates[1], coordinates[0]);
            word.setEndPoint(coordinates[3], coordinates[2]);
            wordsList.add(word);
//            System.out.println(word.toString());

        }
        return wordsList;
    }

    private static int[] getCoordinates(int[][] crossword, String text) {
        int[] coordinates = new int[4];
        int[] first = findFirst(crossword, text);
        int count = 2;
        while (first[0] >= 0 && first[1] >= 0) {
            int[] last = findLast(crossword, text, first);
            if (last[0] >= 0) {
                System.arraycopy(first, 0, coordinates, 0, 2);
                System.arraycopy(last, 0, coordinates, 2, 2);
                return coordinates;
            } else {
                first = findNextFirst(crossword, count, text);
                count++;
            }
        }
        return coordinates;
    }

    private static int[] findNextFirst(int[][] crossword, int count, String text) {
        int[] next = {-1, -1};
        int k = 0;
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                if (crossword[i][j] == text.charAt(0)) {
                    k++;
                    if (k == count) {
                        next[0] = i;
                        next[1] = j;
                        return next;
                    }
                }
            }
        }
        return next;
    }

    private static int[] findLast(int[][] crossword, String text, int[] first) {
        int[] end = {-1, -1};
        int x2, y2;
        int step = text.length() - 1;

        y2 = first[0];
        x2 = first[1] + step;
        char charAtEnd = text.charAt(step);
        if (x2 < crossword[0].length && crossword[y2][x2] == charAtEnd) {
            end[0] = y2;
            end[1] = x2;
            return end;
        }

        x2 = first[1] - step;
        if (x2 >= 0 && crossword[y2][x2] == charAtEnd) {
            end[0] = y2;
            end[1] = x2;
            return end;
        }

        x2 = first[1];
        y2 = first[0] + step;
        if (y2 < crossword.length && crossword[y2][x2] == charAtEnd) {
            end[0] = y2;
            end[1] = x2;
            return end;
        }

        y2 = first[0] - step;
        if (y2 >= 0 && crossword[y2][x2] == charAtEnd) {
            end[0] = y2;
            end[1] = x2;
            return end;
        }

        y2 = first[0] + step;
        x2 = first[1] + step;
        if (x2 < crossword[0].length && y2 < crossword.length && crossword[y2][x2] == charAtEnd) {
            end[0] = y2;
            end[1] = x2;
            return end;
        }

        x2 = first[1] - step;
        if (x2 >= 0 && y2 < crossword.length && crossword[y2][x2] == charAtEnd) {
            end[0] = y2;
            end[1] = x2;
            return end;
        }

        y2 = first[0] - step;
        if (x2 >= 0 && y2 >= 0 && crossword[y2][x2] == charAtEnd) {
            end[0] = y2;
            end[1] = x2;
            return end;
        }

        x2 = first[1] + step;
        if (x2 < crossword[0].length && y2 >= 0 && crossword[y2][x2] == charAtEnd) {
            end[0] = y2;
            end[1] = x2;
            return end;
        } else {
            return end;
        }
    }

    private static int[] findFirst(int[][] crossword, String text) {
        int[] start = {-1, -1};
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                if (crossword[i][j] == text.charAt(0)) {
                    start[0] = i;
                    start[1] = j;
                    return start;
                }
            }
        }
        return start;

    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
