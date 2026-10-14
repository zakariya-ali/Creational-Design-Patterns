package org.example;

import org.example.builder.BuilderDemo;
import org.example.singleton.SingletonDemo;

/** Runs a demo of each creational design pattern. */
public class Main {
    public static void main(String[] args) {
        SingletonDemo.run();
        System.out.println();
        BuilderDemo.run();
    }
}
