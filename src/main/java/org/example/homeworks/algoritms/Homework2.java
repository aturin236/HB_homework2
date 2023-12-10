package org.example.homeworks.algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Homework2 {
    public static void runHomework() {
        System.out.println("Задание №1");

        int x = Service.getRandomInt(10);
        int[] array = Service.getRandomArray(10, 10, false);
        if (Service.isIncludedInTheArray(x, array)) {
            System.out.printf("Число %s входит в массив %s", x, Arrays.toString(array));
        } else {
            System.out.printf("Число %s НЕ входит в массив %s", x, Arrays.toString(array));
        }

        System.out.println("\n");
        System.out.println("Задание №2");

        array = Service.getRandomArray(11, 100, true);
        System.out.printf(
                "В массиве %s индекс мин. элемента равен %s",
                Arrays.toString(array),
                Homework2.indexMinNumberInArray(array)
        );

        System.out.println("\n");
        System.out.println("Задание №3");

        int[][] array2Dim = Service.getRandom2DimArray(5);
        System.out.printf(
                "В массиве %s индекс мин. элемента равен %s",
                Arrays.deepToString(array2Dim),
                Arrays.toString(
                        Homework2.indexMinNumber2DimArray(array2Dim)
                )
        );

        System.out.println("\n");
        System.out.println("Задание №4");

        x = Service.getRandomInt(6);
        System.out.printf(
                "Число фибоначчи под номером %s равно %s",
                x,
                Homework2.getFibonacciNumber(x)
        );

        System.out.println("\n");
        System.out.println("Задание №5");

        array = new int[]{-1,2,4,3,3,3,3,6,10,37};
        System.out.printf(
                "В отсортированном массиве %s индексы дубликатов равны %s",
                Arrays.toString(array),
                Arrays.toString(Homework2.getIndexesOfDublicateNumberInSortedArray(array))
        );

        System.out.println("\n");
        System.out.println("Задание №6");

        Integer[] arrayInBox = new Integer[]{-1,3,4,-3,3,0,3,6,10,3};
        System.out.printf(
                "В НЕотсортированном массиве %s индексы дубликатов равны %s",
                Arrays.toString(arrayInBox),
                Arrays.toString(Homework2.getIndexesOfDublicateNumberInUnsortedArray(arrayInBox))
        );

        System.out.println("\n");
        System.out.println("Задание №7");

        arrayInBox = new Integer[]{-1,3,-1,-3,3,0,-3,6,0,5,5};
        System.out.printf(
                "В НЕотсортированном массиве дубликатов %s уникальный элемент равен %s",
                Arrays.toString(arrayInBox),
                Homework2.getUniqueNumberFromUnsortedArray(arrayInBox)
        );
    }

    private static Integer getUniqueNumberFromUnsortedArray(Integer[] array) {
        List<Integer> arrayAsList = Arrays.asList(array);
        return arrayAsList.stream()
                .filter(i -> Collections.frequency(arrayAsList, i) == 1)
                .findFirst().orElse(0);
    }

    private static Integer[] getIndexesOfDublicateNumberInUnsortedArray(Integer[] array) {
        List<Integer> arrayAsList = Arrays.asList(array);
        int dublicate = arrayAsList.stream()
                .filter(i -> Collections.frequency(arrayAsList, i) > 1)
                .findFirst().orElse(0);
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (dublicate == array[i]) {
                indexes.add(i);
            }
        }

        return indexes.toArray(new Integer[0]);
    }

    private static int[] getIndexesOfDublicateNumberInSortedArray(int[] array) {
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
        index--;
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = index++;
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
}
