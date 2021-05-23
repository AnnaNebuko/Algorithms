package com.geekbrains.algorithms;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    //========2.1.=====================================================
        int[] mArray = new int[] { 1, 2, 3, 4, 5 };

        //Arrays.toString(mArray)
        long nano_startTime = System.nanoTime();
        Arrays.toString(mArray);
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken to Arrays.toString(mArray): "
                + (nano_endTime - nano_startTime));

        //Arrays.copyOf(mArray, mArray.length)
        nano_startTime = System.nanoTime();
        int[] newArray = Arrays.copyOf(mArray, mArray.length);
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to Arrays.copyOf(mArray, mArray.length): "
                + (nano_endTime - nano_startTime));

        //Arrays.equals(mArray, newArray)
        nano_startTime = System.nanoTime();
        Arrays.equals(mArray, newArray);
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to Arrays.equals(mArray, newArray): "
                + (nano_endTime - nano_startTime));

        //========2.2.=====================================================
        //Линейный поиск
        int key = 5;
        nano_startTime = System.nanoTime();
        for (int i = 0; i < mArray.length; i++) {
            if(mArray[i] == key){
                System.out.println("linear search success: " + i);
            }
        }
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to linear search: "
                + (nano_endTime - nano_startTime));

        //Двоичный поиск
        nano_startTime = System.nanoTime();
        int firstIndex = 0;
        int lastindex = mArray.length - 1;

        while (firstIndex <= lastindex) {
            int middleIndex = (firstIndex + lastindex)/2;

            if (mArray[middleIndex] == key){
                System.out.println("binary search success: " + middleIndex);
                break;
            }
            else if (mArray[middleIndex] < key) firstIndex = middleIndex + 1;
            else if (mArray[middleIndex] > key) lastindex = middleIndex - 1;
        }
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to binary search: "
                + (nano_endTime - nano_startTime));

        //========2.3.=====================================================
        Random rand = new Random();
        int[] array = new int[400];
        for (int i = 0; i < 400; i++) {
            array[i] = rand.nextInt(100);
        }

        //создаю три массива одинаковых для трех сортировок в 2.4, 2.5, 2.6
        int[] notSortedArrayOne = Arrays.copyOf(array, array.length);
        int[] notSortedArrayTwo = Arrays.copyOf(array, array.length);
        int[] notSortedArrayThree = Arrays.copyOf(array, array.length);

        nano_startTime = System.nanoTime();
        Arrays.sort(array);
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to sort array: "
                + (nano_endTime - nano_startTime));

        //========2.4.=====================================================
        //Bubble Sort N^2
        nano_startTime = System.nanoTime();
        int buff;
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for (int i = 0; i < notSortedArrayOne.length - 1; i++) {
                if(notSortedArrayOne[i] > notSortedArrayOne[i+1]){
                    sorted = false;
                    buff = notSortedArrayOne[i];
                    notSortedArrayOne[i] = notSortedArrayOne[i+1];
                    notSortedArrayOne[i+1] = buff;
                }
            }
        }
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to Bubble Sort: "
                + (nano_endTime - nano_startTime));

        //========2.5.=====================================================
        //Selection sorting algorithm N^2
        nano_startTime = System.nanoTime();
        for (int i = 0; i < notSortedArrayTwo.length; i++) {
            int min = i;
            for (int j = i + 1; j < notSortedArrayTwo.length; j++){
                if(notSortedArrayTwo[j] < notSortedArrayTwo[min]){
                    min = j;
                }
            }
            swapN(notSortedArrayTwo, i, min);
        }
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to Selection sorting algorithm: "
                + (nano_endTime - nano_startTime));

        //========2.6.=====================================================
        //Insert sorting algorithm N^2, the best
        int newBuff;
        int in;
        nano_startTime = System.nanoTime();
        for (int i = 0; i < notSortedArrayThree.length; i++) {
             newBuff = notSortedArrayThree[i];
             in = i;
             while(in > 0 && notSortedArrayThree[in - 1]>=newBuff){
                 notSortedArrayThree[in] = notSortedArrayThree[in - 1];
                 --in;
             }
            notSortedArrayThree[in] = newBuff;
        }
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to Insert sorting algorithm: "
                + (nano_endTime - nano_startTime));
    }

    private static void swapN(int[] notSortedArrayTwo, int i, int min) {
        int buff = notSortedArrayTwo[i];
        notSortedArrayTwo[i] = notSortedArrayTwo[min];
        notSortedArrayTwo[min] = buff;
    }
}
