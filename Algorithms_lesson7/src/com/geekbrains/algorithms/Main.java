package com.geekbrains.algorithms;

public class Main {

    public static void main(String[] args) {
	    //Приведите пример графа
        //Московское метро. Граф интеренета. Блокчейн. Дорожная карта

        //Реализуйте базовые методы графа
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE

        graph.displayVertex(4);
        graph.displayVertex(2);

        //Реализацию метода обхода в глубину
        System.out.println("Реализацию метода обхода в глубину");
        long nano_startTime = System.nanoTime();
        graph.dfs();
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken to make it depth: "
                + (nano_endTime - nano_startTime));

        //Метод обхода в ширину
        System.out.println("Реализацию метода обхода в ширину");
        nano_startTime = System.nanoTime();
        graph.bfs();
        nano_endTime = System.nanoTime();
        System.out.println("Time taken to make it in width: "
                + (nano_endTime - nano_startTime));

    }
}
