package com.geekbrains.algorithms;

public class Node {
    public Person person;
    public Node leftChild;
    public Node rightChild;

    public void display() {
        System.out.println("Имя: " + person.name + " Возраст: " + person.age);
    }
}
