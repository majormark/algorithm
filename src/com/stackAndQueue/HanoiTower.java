package com.stackAndQueue;

/**
 * Created by major on 2017/12/7.
 */
public class HanoiTower {

    public static void hanoiProblem1() {

    }

    public static void process(int n, String from, String to, String another) {
        if(n == 1)
            System.out.println("move 1 from " + from + " to " + to);
        else {
            process(n - 1, from, another, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            process(n - 1, another, to, from);
        }
    }

    public static void main(String[] args) {
        HanoiTower.process(3, "A", "B", "C");
    }
}
