package org.example.homeworks.algoritms;

import java.util.Arrays;

public class Homework3 {
    public static void runHomework() {
        System.out.println("Задание №1");

        int[] array = Service.getRandomArray(11, 100, false);
        System.out.println("Исходный массив - " + Arrays.toString(array));
        System.out.println("Отсортированный массив - " + Arrays.toString(
                sortingByChoiceInNaturalOrder(array)
        ));

        System.out.print("\n");
        System.out.println("Задание №2");

        array = Service.getRandomArray(11, 100, false);
        System.out.println("Исходный массив - " + Arrays.toString(array));
        System.out.println("Отсортированный массив - " + Arrays.toString(
                sortingByInsertInReverseOrder(array)
        ));

        System.out.print("\n");
        System.out.println("Задание №3");

        array = Service.getRandomArray(11, 20, false);
        int key = Service.getRandomInt(20);
        System.out.println("Исходный массив - " + Arrays.toString(array));
        System.out.println("Число для поиска - " + key);
        System.out.println("Индекс найденного числа = " + getIndexNumberFromUnsortedArray(array, key));

        System.out.print("\n");
        System.out.println("Задание №4");

        array = Service.getRandomArray(11, 20, false);
        key = Service.getRandomInt(20);
        System.out.println("Исходный массив - " + Arrays.toString(array));
        System.out.println("Число для поиска - " + key);
        System.out.println("Найденное число = " + getNumberWithBubbleAndBinarySearch(array, key));

        System.out.print("\n");
        System.out.println("Задание №5");

        array = Service.getRandomArray(11, 20, false);
        key = Service.getRandomInt(20);
        System.out.println("Исходный массив - " + Arrays.toString(array));
        System.out.println("Число для поиска - " + key);
        System.out.println("Найденное число = " + getNumberWithMergeBinarySearch(array, key));

        System.out.print("\n");
        System.out.println("Задание №6");

        array = Service.getRandomArray(11, 10, false);
        key = Service.getRandomInt(10);
        System.out.println("Исходный массив - " + Arrays.toString(array));
        System.out.println("Число для поиска - " + key);
        System.out.println("Индекс в исходном массиве = " + Homework3_3_2.getIndex_homework3_2(array, key));
    }

    private static int getNumberWithMergeBinarySearch(int[] array, int key) {
        return getNumberByBinarySearch(
                sortingByMerge(array),
                key
        );
    }

    private static int[] sortingByMerge(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int mid = array.length / 2;

        int[] arrayLeft = sortingByMerge(Arrays.copyOfRange(array, 0, mid));
        int[] arrayRight = sortingByMerge(Arrays.copyOfRange(array, mid, array.length));

        int[] arrayResult = new int[array.length];
        int indexLeft = 0;
        int indexRight = 0;

        for (int i = 0; i < array.length; i++) {
            if (indexLeft == arrayLeft.length) {
                arrayResult[i] = arrayRight[indexRight];
                indexRight++;
            } else if (indexRight == arrayRight.length) {
                arrayResult[i] = arrayLeft[indexLeft];
                indexLeft++;
            } else if ((arrayLeft[indexLeft] > arrayRight[indexRight])) {
                arrayResult[i] = arrayRight[indexRight];
                indexRight++;
            } else {
                arrayResult[i] = arrayLeft[indexLeft];
                indexLeft++;
            }
        }
        return arrayResult;
    }

    private static int getNumberWithBubbleAndBinarySearch(int[] array, int key) {
        return getNumberByBinarySearch(
                sortingByBubble(array),
                key
        );
    }

    private static int getNumberByBinarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] < key)
                left = mid + 1;
            else if (array[mid] > key)
                right = mid - 1;
            else
                return key;
        }
        return -1;
    }

    private static int[] sortingByBubble(int[] array) {
        boolean weMustContinue = true;
        while (weMustContinue) {
            boolean haveExchange = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i-1] > array[i]) {
                    int buffer = array[i];
                    array[i] = array[i-1];
                    array[i-1] = buffer;

                    haveExchange = true;
                }
            }
            if (!haveExchange) {
                weMustContinue = false;
            }
        }
        return array;
    }

    private static int getIndexNumberFromUnsortedArray(int[] array, int key) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                index = i;
            }
        }
        return index;
    }

    private static int[] sortingByInsertInReverseOrder(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int number = array[i];
            int j = i -1;
            while (j >= 0 && array[j] < number) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = number;
        }
        return array;
    }

    private static int[] sortingByChoiceInNaturalOrder(int[] array) {
        for (int i = array.length-1; i >= 0; i--) {
            int bufferIndex = i;
            for (int j = 0; j <= i-1; j++) {
                if (array[j] > array[bufferIndex]) {
                    bufferIndex = j;
                }
            }
            int buffer = array[i];
            array[i] = array[bufferIndex];
            array[bufferIndex] = buffer;
        }

        return array;
    }
}
