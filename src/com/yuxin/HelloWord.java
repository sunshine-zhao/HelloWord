package com.yuxin;

public class HelloWord {
    public static void main(String[] args) {
        System.out.println("Hello  Worllld!");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        Thread.currentThread().setContextClassLoader();
    }
}