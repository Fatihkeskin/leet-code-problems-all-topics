package com.company;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        int[] arrayToBeSorted = new int[10];

        for (int i = 0; i<10; i++) {
            arrayToBeSorted[i] = new Random().nextInt(1000);
        }
        System.out.println("Array before sort ");
        for (int i = 0; i<10; i++) {
            System.out.println(arrayToBeSorted[i]);
        }

        arrayToBeSorted = mergeSort(arrayToBeSorted);

        System.out.println("Array after sort ");
        for (int i = 0; i<10; i++) {
            System.out.println(arrayToBeSorted[i]);
        }

    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1)
            return array;

        int middleIndex = array.length /2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, middleIndex);
        int[] rightHalf = Arrays.copyOfRange(array, middleIndex, array.length);

        return merge(mergeSort(leftHalf),mergeSort(rightHalf));

    }

    public static int[] merge(int[] first, int[] second) {
        int[] mergedArray = new int[first.length + second.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < first.length && rightIndex < second.length ) {
            if (first[leftIndex] < second[rightIndex])
                mergedArray[mergedIndex++] = first[leftIndex++];
             else
                mergedArray[mergedIndex++] = second[rightIndex++];
        }

        while (leftIndex < first.length)
            mergedArray[mergedIndex++] = first[leftIndex++];


        while (rightIndex < second.length)
            mergedArray[mergedIndex++] = second[rightIndex++];


        return mergedArray;
    }

}