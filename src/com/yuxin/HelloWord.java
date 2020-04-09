package com.yuxin;

public class HelloWord {
    public static void main(String[] args) {
        System.out.println("Hello  Worlld!");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        Thread.currentThread().setContextClassLoader();
    }
}