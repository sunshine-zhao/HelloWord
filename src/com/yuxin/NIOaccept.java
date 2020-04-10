package com.yuxin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * NIO多路复用，接受端
 */
public class NIOaccept {
    public static void main(String[] args) {
        try(Socket socket=new Socket(InetAddress.getLocalHost(),6666)){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println("NIO客户端："+s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
