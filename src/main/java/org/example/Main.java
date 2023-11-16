package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1");

        int x = getRandomInt(10);
        int[] array = getRandomArray(10, 10, false);
        if (isIncludedInTheArray(x, array)) {
            System.out.printf("Число %s входит в массив %s", x, Arrays.toString(array));
        } else {
            System.out.printf("Число %s НЕ входит в массив %s", x, Arrays.toString(array));
        }

        System.out.println("\n");
        System.out.println("Задание №2");

        array = getRandomArray(11, 100, true);
        System.out.printf(
                "В массиве %s индекс мин. элемента равен %s",
                Arrays.toString(array),
                indexMinNumberInArray(array)
        );

        System.out.println("\n");
        System.out.println("Задание №3");

        int[][] array2Dim = getRandom2DimArray(5);
        System.out.printf(
                "В массиве %s индекс мин. элемента равен %s",
                Arrays.deepToString(array2Dim),
                Arrays.toString(
                        indexMinNumber2DimArray(array2Dim)
                )
        );

        System.out.println("\n");
        System.out.println("Задание №4");

        x = getRandomInt(6);
        System.out.printf(
                "Число фибоначчи под номером %s равно %s",
                x,
                getFibonacciNumber(x)
        );

        System.out.println("\n");
        System.out.println("Задание №5");

        array = new int[]{-1,2,4,-3,3,3,3,6,10,37};
        System.out.printf(
                "В массиве %s индексы дубликатов равны %s",
                Arrays.toString(array),
                Arrays.toString(getIndexesOfDublicateNumberInArray(array))
        );
        //test2
    }

    private static int[] getIndexesOfDublicateNumberInArray(int[] array) {
        if (array.length < 2) {
            return new int[0];
        }
        int bufferNumber = array[0];
        int index = 0;
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (bufferNumber == array[i]) {
                if (count == 0) {
                    index = i;
                    count++;
                }
                count++;
            } else {
                bufferNumber = array[i];
            }
        }
        int[] result = new int[count];
        for (int i = 1; i <= count; i++) {
            result[i-1] = index++;
        }

        return result;
    }

    private static int getFibonacciNumber(int position) {
        if (position < 2) {
            return 1;
        }
        if (position < 3) {
            return 2;
        }

        List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 1));
        for (int i = 3; i <= position; i++) {
            sequence.add(sequence.get(i-3) + sequence.get(i-2));
        }

        return sequence.get(sequence.size()-1);
    }

    private static int[] indexMinNumber2DimArray(int[][] array) {
        if (array.length < 1) {
            return new int[]{-1, -1};
        }

        int indexFirstDim = 0;
        int indexSecondDim = 0;
        int minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < minNumber) {
                    indexFirstDim = i;
                    indexSecondDim = j;
                    minNumber = array[i][j];
                }
            }
        }

        return new int[]{indexFirstDim, indexSecondDim};
    }

    private static int indexMinNumberInArray(int[] array) {
        if (array.length < 1) {
            return -1;
        }
        if (array.length < 2) {
            return 0;
        }

        int index = 0;
        int minNumber = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minNumber) {
                minNumber = array[i];
                index = i;
            }
        }

        return index;
    }

    private static boolean isIncludedInTheArray(int x, int[] array) {
        return indexNumberIncludedInTheArray(x, array) >= 0;
    }

    private static int indexNumberIncludedInTheArray(int x, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                return i;
            }
        }

        return -1;
    }

    private static int getRandomInt(int rightBorder) {
        return (int) (Math.random() * (rightBorder + 1));
    }

    private static int[] getRandomArray(int size, int rightBorder, boolean unique) {
        int[] result = new int[size];
        for (int i = 0; i <= size-1; i++) {
            if (unique) {
                int newNumber;
                do {
                    newNumber = getRandomInt(rightBorder);
                }
                while (isIncludedInTheArray(newNumber, result));
                result[i] = newNumber;
            } else {
                result[i] = getRandomInt(rightBorder);
            }

        }

        return result;
    }

    private static int[][] getRandom2DimArray(int size) {
        int[][] result = new int[size][];
        for (int i = 0; i <= size-1; i++) {
            result[i] = getRandomArray(
                    getRandomInt(10),
                    20,
                    true
            );
        }
        return result;
    }
}