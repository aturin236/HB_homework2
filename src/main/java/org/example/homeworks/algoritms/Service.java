package org.example.homeworks.algoritms;

public class Service {
    public static int getRandomInt(int rightBorder) {
        return (int) (Math.random() * (rightBorder + 1));
    }

    public static int[] getRandomArray(int size, int rightBorder) {
        return getRandomArray(size, rightBorder, false);
    }

    public static int[] getRandomArray(int size, int rightBorder, boolean unique) {
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

    public static int[][] getRandom2DimArray(int size) {
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

    public static boolean isIncludedInTheArray(int x, int[] array) {
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
}
