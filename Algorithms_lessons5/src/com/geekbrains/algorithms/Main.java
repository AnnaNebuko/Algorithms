package com.geekbrains.algorithms;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //=========================5.1==============================================
        //Приведите пример использования рекурсии
        //Факториал :)
        System.out.println("factorial of 6: " + factorial(6));
        
        //=========================5.2==============================================
        //Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода
        //====Бесконечная рекурсия =====
        int n = 10;
        //countdown(n); // Внимание! StackOverflowError. если раскомментить

        //====Правильная рекурсия (с условием) =====
        countdownCorrectRecursion(n);
        //=========================5.3==============================================
        //Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        // 1) Операционная система выделяет под функции места в порядке их вызова и 2) факториал
        //=========================5.4==============================================
        //Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию
        System.out.println("=====Task 5.4====");

        long start = System.nanoTime();
        System.out.println("Result: " + powerWithLoop(3, 2));
        System.out.println("Runtime using loop: " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println("Result: " + powerWithRecursion(3, 2));
        System.out.println("Runtime using recursion: " + (System.nanoTime() - start));
        //=========================5.5==============================================
        //Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1
        System.out.println("=====Task 5.5====");

        Random random = new Random();
        int key = random.nextInt(10);
        int[] arr = new int[10];
        int[] arrForSortByMerging;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }

        System.out.println("Random key " + key);
        System.out.println("Random array " + Arrays.toString(arr));
        arrForSortByMerging = Arrays.copyOf(arr, arr.length);

        start = System.nanoTime();
        System.out.println("Index: " + recBinaryFind(key, 0, arr.length - 1, arr));
        long timeRecursionBinarySearch = System.nanoTime() - start;
        System.out.println("Time recursionBinarySearch: " + timeRecursionBinarySearch);

        start = System.nanoTime();
        System.out.println("Index: " + binarySearch(arr, key, 0, arr.length - 1));
        long timeBinarySearch = System.nanoTime() - start;
        System.out.println("Time binarySearch: " + timeBinarySearch);

        if (timeBinarySearch > timeRecursionBinarySearch) System.out.println("recursionBinarySearch won");
        else System.out.println("timeBinarySearch won");

        //=========================5.6==============================================
        //На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием
        System.out.println("=====Task 5.6====");
        start = System.nanoTime();
        System.out.println("Sort merge array " + Arrays.toString(sortMerge(arrForSortByMerging)));
        long timeSortMerge = System.nanoTime() - start;
        System.out.println("Time sortMerge: " + timeSortMerge);
    }


    private static int countdownCorrectRecursion(int n) {
        System.out.println(n);
        if (n == 1) return 1;
        return countdownCorrectRecursion(n-1);
    }

    private static int countdown(int n) {
        System.out.println(n);
        return countdown(n-1);
    }

    private static int factorial(int n) {
        int result = 1;
        if (n == 1 || n == 0) {
            return result;
        }
        result = n * factorial(n-1);
        return result;
    }

    private static double powerWithLoop(int x, int n) {
        double result = 1;

        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    public static int recBinaryFind(int searchKey, int low, int high, int[] arr) {
        if (low > high) {
            return arr.length;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == searchKey) {
            return mid;
        } else if (arr[mid] < searchKey) {
            return recBinaryFind(searchKey, mid + 1, high, arr);
        } else {
            return recBinaryFind(searchKey, low, mid - 1, arr);
        }
    }
    private static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    private static double powerWithRecursion(int x, int n) {
        if (n == 1) {
            return x;
        } else {
            return x * powerWithRecursion(x, n - 1);
        }
    }
    static int[] sortMerge(int[] arr) {
        if (arr.length < 2) return arr;
        int middle = arr.length / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, arr.length)));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }
}
