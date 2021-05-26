package com.geekbrains.algorithms;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //============================3.1.======================================
        Integer[] mArray = {1, 2, 3, 4, 5};
        long nano_startTime = System.nanoTime();
        List<Integer> mList = new ArrayList<>(Arrays.asList(mArray));
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken to make ArrayList out of array: "
                + (nano_endTime - nano_startTime));

        //============================3.2.======================================
        nano_startTime = System.nanoTime();
        mList.add(6);
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to add: "
                + (nano_endTime - nano_startTime));

        nano_startTime = System.nanoTime();
        mList.remove(5);
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to remove: "
                + (nano_endTime - nano_startTime));

        nano_startTime = System.nanoTime();
        mList.get(4);
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to get: "
                + (nano_endTime - nano_startTime));

        //============================3.3.======================================
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        ArrayList<String> arrayListCopy = new ArrayList<>(linkedList);
        linkedList.addFirst("Start");
        linkedList.peekLast();

        System.out.println(linkedList);
        linkedList.remove("B");
        System.out.println("Linked list after "
                + "deletion: " + linkedList);

        //============================3.4.======================================
        List<MyClass> myClasses = Arrays.asList(new MyClass(1,2,3),
                new MyClass(4, 5, 6), new MyClass(7, 8, 9));
        System.out.println(myClasses);
        //============================3.5.======================================
        //Итератор на основе linkedList + базовые операции итератора
        nano_startTime = System.nanoTime();
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        nano_endTime = System.nanoTime();
        System.out.print("Time taken to : "
                + (nano_endTime - nano_startTime));
        iterator.remove();
    }
}
