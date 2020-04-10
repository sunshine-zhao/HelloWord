package com.yuxin;


import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * JDK7,Files测试
 */
public class FilesDemo {
    /**
     * JDK7新特性
     * try-with-sources
     *
     * @param args
     */
    public static void main(String[] args) {
        try (
                FileOutputStream fis = new FileOutputStream("D:/javazone/javaProject/FilesDemo/tt.txt", true);
        ) {
            fis.write("Hello World!".getBytes("UTF-8"));
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    /**
     * Files输入流
     */
    @Test
    public void t1() {
        System.out.println("Hello");
        try {
            Path write = Files.write(Paths.get("D:/javazone/javaProject/FilesDemo/tt.txt"), "Hello Files".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            System.out.println(write);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Files输入流
     */
    @Test
    public void FileOutTest() {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("D:/javazone/javaProject/FilesDemo/tt.txt"));
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * printWriter
     */
    @Test
    public void printWriter() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("D:/javazone/javaProject/FilesDemo/tt.txt", true), true);
            printWriter.println();
            printWriter.println("Hello PrintWriter!");
            printWriter.println("java");
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
