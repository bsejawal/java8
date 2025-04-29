package com.bsejawal.util;

import java.util.Random;
import java.util.stream.IntStream;

public class NumberUtil {
    /**
     * Generates an array of random integers within a specified range.
     *
     * @param count the number of random integers to generate
     * @param min the minimum value (inclusive) of the random numbers
     * @param max the maximum value (inclusive) of the random numbers
     * @return an array of random integers between min and max (inclusive)
     * @throws IllegalArgumentException if count is negative or min is greater than max
     */
    public static int[] generateRandomNumbers(int count, int min, int max) {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative.");
        }
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than max.");
        }

        Random random = new Random();

        return IntStream.range(0, count)
                .map(i -> random.nextInt((max - min) + 1) + min)
                .toArray();
    }
}
