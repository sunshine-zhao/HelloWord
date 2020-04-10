package com.yuxin;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class HelloWord {
    public static void main(String[] args) {
        System.out.println("Hello  Worll4leeds!");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        Thread.currentThread().setContextClassLoader();
        String str="asd,a,d,c,d,e,f,aa,hh";
        StringTokenizer tokenizer = new StringTokenizer(str,",",true);
        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(hostAddress);
            String hostName = InetAddress.getLocalHost().getHostName();
            System.out.println(hostName);
            String canonicalHostName = InetAddress.getLoopbackAddress().getCanonicalHostName();
            System.out.println(canonicalHostName);
            Inet4Address.getLocalHost();
            Inet6Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}