package org.example;

<<<<<<< HEAD
import org.example.builder.BuilderDemo;
=======
import org.example.abstractfactory.AbstractFactoryDemo;
import org.example.builder.BuilderDemo;
import org.example.factorymethod.FactoryMethodDemo;
import org.example.prototype.PrototypeDemo;
>>>>>>> 163d42c092ccf750700abd2cb6a8d127c49c0fb5
import org.example.singleton.SingletonDemo;

/** Runs a demo of each creational design pattern. */
public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        SingletonDemo.run();
        System.out.println();
=======
        FactoryMethodDemo.run();
        System.out.println();
        AbstractFactoryDemo.run();
        System.out.println();
        SingletonDemo.run();
        System.out.println();
        PrototypeDemo.run();
        System.out.println();
>>>>>>> 163d42c092ccf750700abd2cb6a8d127c49c0fb5
        BuilderDemo.run();
    }
}
