package com.geekbrains.algorithms;

public class NumsMine {
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public NumsMine(int first, int second, int third, int fourth, int fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public void findElementInMyClass(int i) {
        if (first == i || second == i || third == i || fourth == i || fifth == i)
            System.out.println("Found");
    }

    @Override
    public String toString() {
        return "numsMine{" + first + " "
                 + second + " "
                 + third + " "
                 + fourth + " "
                 + fifth + " "
                 + '}';
    }
}
