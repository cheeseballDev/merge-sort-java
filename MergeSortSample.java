package SchoolFolder;

import java.util.Random;

public class MergeSortSample {
    public static void main(String[] args) {
        Random randomNumbers = new Random();
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = randomNumbers.nextInt(100);
        }
        System.out.println("Numbers: ");
        printNumbers(numbers);

        splitNumbers(numbers);

        System.out.println("Sorted: ");
        printNumbers(numbers);
    }

    static void splitNumbers(int[] numbers) {
        int arrayLength = numbers.length;
        int midIndex = arrayLength / 2;
        int[] left = new int[midIndex];
        int[] right = new int[arrayLength - midIndex];

        if (arrayLength < 2) {
            return;
        }

        for (int i = 0; i < midIndex; i++) {
            left[i] = numbers[i]; 
        }
        for (int i = midIndex; i < arrayLength; i++) {
            right[i - midIndex] = numbers[i];
        }

        splitNumbers(left);
        splitNumbers(right);

        mergeNumbers(numbers, left, right);
    }

    static void mergeNumbers(int[] numbers, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int l = 0, r = 0, i = 0;

        while (l < leftLength && r < rightLength) {
            if (left[l] < right[r]) {
                numbers[i] = left[l];
                l++;
            } else {
                numbers[i] = right[r];
                r++;
            }
            i++;
        }

        while(l < leftLength) {
            numbers[i] = left[l];
            l++;
            i++;
        }
        while(r < rightLength) {
            numbers[i] = right[r];
            r++;
            i++;
        }
    }

    

    static void printNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
