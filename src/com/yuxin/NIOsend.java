package com.yuxin;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * NIO多路复用，发送端
 */
public class NIOsend {
    public static void main(String[] args) {
        //发送端
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        threadPool.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try (
                                Selector selector = Selector.open();
                                ServerSocketChannel serverSocketChannel= ServerSocketChannel.open();
                        ) {
                            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(),6666));
                            serverSocketChannel.configureBlocking(false);
                            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                            while(true){
                                System.out.println("单线程轮询就绪的channel，处于阻塞状态，直到有新的连接请求");
                                selector.select();
                                System.out.println("轮询到新的客户端请求");
                                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                                while(iterator.hasNext()){
                                    SelectionKey key = iterator.next();
                                    System.out.println("获取就绪的channel,接受新的用户请求");
                                    try(
                                            SocketChannel sc=((ServerSocketChannel)key.channel()).accept();

                                    ) {
                                        sc.write(Charset.defaultCharset().encode("你好！NIO"));
                                    }
                                    iterator.remove();
                                }
                            }
                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                    }
                }
        );
    }
}
