package com.geekbrains.algorithms;


import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //6.1. Приведите пример использования древовидной структуры.
        System.out.println("=========Задание 6.1.=============");
        System.out.println("Дерево интерфейса Collection");

        //6.2. - 6.4.
        System.out.println("=========Задание 6.2. - 6.4. =====");
        Tree theTree = new Tree();

        theTree.insert(new Person(4, "Ivan", 35));
        theTree.insert(new Person(2, "Ivan1", 78));
        theTree.insert(new Person(3, "Ivan2", 24));
        theTree.insert(new Person(5, "Ivan3", 21));

        theTree.max().display();
        theTree.min().display();

        theTree.find(3).display();

        //6.5. Реализуйте метод удаления узла и выполните оценку времени
        //базовых методов дерева с помощью System.nanoTime().
        System.out.println("=========Задание 6.5.=============");
        long nano_startTime = System.nanoTime();
        theTree.delete(2);
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken to delete node: "
                + (nano_endTime - nano_startTime));

        System.out.println();
        theTree.displayTree();
        //6.6. Алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
        System.out.println("=========Задание 6.6.=============");
        int[] arr;
        Random rand = new Random();
        arr = new int[10];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(10);
        }

        System.out.println(Arrays.toString(arr)); // Выводим в консоль не отсортированный массив
        HeapSort arrsort = new HeapSort();

        arrsort.sort(arr);

        System.out.println(Arrays.toString(arr));

        //6.7. Приведите пример сбалансированного дерева и его применения.
        System.out.println("=========Задание 6.7.=============");
        System.out.println("класс TreeMap в Java использует эти к/ч деревья");

    }
}
