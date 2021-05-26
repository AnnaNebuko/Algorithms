package com.geekbrains.algorithms;

public class MyClass {
    private int first;
    private int second;
    private int third;

    public MyClass(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
