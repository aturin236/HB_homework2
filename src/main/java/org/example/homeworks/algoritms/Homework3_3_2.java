package org.example.homeworks.algoritms;

public class Homework3_3_2 {
    public static final byte INDEX = 0;
    public static final byte VALUE = 1;

    public static int getIndex_homework3_2(int[] array, int key) {
        int[][] array2D = new int[array.length][2];
        for (int i = 0; i < array.length; i++) {
            array2D[i] = new int[]{i, array[i]};
        }

        return getNumberByBinarySearch(
                sortingByBubble(array2D),
                key
        );
    }

    private static int getNumberByBinarySearch(int[][] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid][VALUE] < key)
                left = mid + 1;
            else if (array[mid][VALUE] > key)
                right = mid - 1;
            else
                return array[mid][INDEX];
        }
        return -1;
    }

    private static int[][] sortingByBubble(int[][] array) {
        boolean weMustContinue = true;
        while (weMustContinue) {
            boolean haveExchange = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i-1][VALUE] > array[i][VALUE]) {
                    int[] buffer = array[i];
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

}
