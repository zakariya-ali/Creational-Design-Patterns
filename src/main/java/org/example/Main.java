package org.example;

import org.example.abstractfactory.AbstractFactoryDemo;
import org.example.builder.BuilderDemo;
import org.example.factorymethod.FactoryMethodDemo;
import org.example.prototype.PrototypeDemo;
import org.example.singleton.SingletonDemo;

/** Runs a demo of each creational design pattern. */
public class Main {
    public static void main(String[] args) {
        FactoryMethodDemo.run();
        System.out.println();
        AbstractFactoryDemo.run();
        System.out.println();
        SingletonDemo.run();
        System.out.println();
        PrototypeDemo.run();
        System.out.println();
        BuilderDemo.run();
    }
}
