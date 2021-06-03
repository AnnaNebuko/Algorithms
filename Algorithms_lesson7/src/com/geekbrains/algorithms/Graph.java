package com.geekbrains.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private final Vertex[] vertexList; // Массив, в котором хранятся наши вершины. Когда мы захотим посмотреть на какую-нибудь вершину, то мы будем обращаться к данному массиву
    private final int[][] adjMat; // Матрица смежности, которая будет хранить связи между нашими вершинами
    private int size; // Текущее количество вершин
    private final Stack stack;

    public Graph() // Создание нашего графа с вершинами
    {
        // Максимальное количество вершин
        int MAX_VERTS = 32;
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++)
        {
            for (int j = 0; j < MAX_VERTS; j++)
            {
                adjMat[i][j] = 0; // Заполняем матрицу смежности начальными значениями, чтобы она не была пустой
                // На данном этапе у нас нет ещё ни одного ребра между вершинами
            }
        }
    }

    public void addVertex(char label) // Метод для добавления новой вершины
    {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) // Метод добавления связей между вершинами
    // Автоматически задать связи между вершинами нельзя, потому что в графе нужно связать какие-то особенные вершины, а какие-то вершины связанными быть не должны
    {
        adjMat[start][end] = 1; // Здесь мы добавляем связь от A к B
        adjMat[end][start] = 1; // Здесь мы добавляем связь от B к A
    }

    public void displayVertex(int vertex) // Отображение вершины
    {
        System.out.println(vertexList[vertex].label);
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty())
        {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1)
            {
                stack.pop();
            }
            else
            {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < size; i++) // Подчищение графа, чтобы можно было сделать следующий обход
        {
            vertexList[i].wasVisited = false;
        }
    }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++)
        {
            if (adjMat[ver][i] == 1 && !vertexList[i].wasVisited)
            {
                return i;
            }
        }

        return -1;
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>(); // Создаём нашу очередь с помощью базового метода LinkedList
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2; // Смежная с v1 вершина
        while (!queue.isEmpty())
        {
            int v1 = queue.remove(); // Достаём наш элемент из очереди
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) // Если с v2 есть смежное значение v1
            {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i < size; i++) // Сброс флагов, чтобы можно было повторно пройти по данному графу
        {
            vertexList[i].wasVisited = false;
        }
    }

}
