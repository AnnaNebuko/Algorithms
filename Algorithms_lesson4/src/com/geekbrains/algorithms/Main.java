package com.geekbrains.algorithms;

import java.util.*;

//6 видос
public class Main {

    public static void main(String[] args) {
        //=================4.1.===============================================================
        List<MyClass> myClasses = Arrays.asList(new MyClass(1,2,3),
                new MyClass(4, 5, 6), new MyClass(7, 8, 9));
        long nano_startTime = System.nanoTime();
        Stack<MyClass> stack = new Stack<>();
        stack.addAll(myClasses);
        System.out.println("Peek: " + stack.peek());
        stack.push(new MyClass(0, 0, 0));
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken to make Stack: "
                + (nano_endTime - nano_startTime));
        //=================4.2.===============================================================
        nano_startTime = System.nanoTime();
        Queue<MyClass> queue = new java.util.LinkedList<>();
        queue.add(new MyClass(1,2,3));
        System.out.println("queue: ");
        System.out.println("queue size: " + queue.size());
        while(!queue.isEmpty())
        {
            System.out.println(queue.peek());
            queue.remove();
        }
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to make Queue: "
                + (nano_endTime - nano_startTime));
        //=================4.3.===============================================================
        nano_startTime = System.nanoTime();
        Deque<MyClass> deque = new ArrayDeque<>();
        deque.add(new MyClass(1,2,3));
        System.out.println("deque: ");
        System.out.println("deque size: " + deque.size());
        while(!deque.isEmpty())
        {
            System.out.println(deque.poll());
        }
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to make Deque: "
                + (nano_endTime - nano_startTime));
        deque.offerFirst(new MyClass(1,2,3));
        //System.out.println(deque.peek());
        //=================4.4.===============================================================
        nano_startTime = System.nanoTime();
        PriorityQueue<Integer> prior = new PriorityQueue<>();
        prior.add(9);
        prior.add(3);
        prior.add(7);
        prior.offer(5);
        nano_endTime = System.nanoTime();
        while(!prior.isEmpty())
        {
            System.out.println(prior.poll());
        }
        System.out.println("Time taken to make Priority queue: "
                + (nano_endTime - nano_startTime));
        //=================4.5.===============================================================
        nano_startTime = System.nanoTime();
        StackList s1 = new StackList();
        s1.push("Anna", 56);
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to make Stack and Queue based on LinkedList: "
                + (nano_endTime - nano_startTime));
        s1.display();
    }
}
