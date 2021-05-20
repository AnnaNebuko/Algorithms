package com.geekbrains.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] numsPrimitive = new int[] { 1, 2, 3, 4, 5 };
        List<Integer> numsReference = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        NumsMine numsMine = new NumsMine(1, 2, 3, 4, 5);

        System.out.println("Array: " + Arrays.toString(numsPrimitive));
        System.out.println("List: " + Arrays.toString(numsReference.toArray()));
        System.out.println("My class: " + numsMine.toString());

        //============For Array===============
        long nano_startTime = System.nanoTime();
        System.out.println("Element position in array:"
                + findElementInArray(numsPrimitive, 5));
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken to find in array: "
                + (nano_endTime - nano_startTime));
        System.out.println();

        //============For List===============
        nano_startTime = System.nanoTime();
        System.out.println("Element position in List:"
                + findElementInList(numsReference, 5));
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to find in List: "
                + (nano_endTime - nano_startTime));
        System.out.println();

        //============For my class===========
        nano_startTime = System.nanoTime();
        numsMine.findElementInMyClass(5);
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to find in my class: "
                + (nano_endTime - nano_startTime));
    }

    public static int findElementInArray(int arr[], int item) {
        int pos = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    private static int findElementInList(List<Integer> numsReference, int item) {
        return numsReference.indexOf(item);
    }
}
