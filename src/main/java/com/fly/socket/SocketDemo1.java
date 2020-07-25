package com.fly.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 张攀钦
 * @date 2020-07-23-16:15
 */
public class SocketDemo1 {
    public static void main(String[] args) throws IOException {
        final ServerSocketChannel open = ServerSocketChannel.open();
        open.configureBlocking(false);
        open.bind(new InetSocketAddress(10222), 20);
        final Selector open1 = Selector.open();
        open.register(open1, SelectionKey.OP_ACCEPT);
        final LinkedBlockingQueue<SocketChannel> objects = new LinkedBlockingQueue<>(1024);
        final AtomicInteger atomicInteger = new AtomicInteger();
        Selector open2 = Selector.open();

        new Thread(() -> {
            int select = 0;
            while (true) {
                try {
                    select = open2.select();
                    final SocketChannel poll = objects.poll();
                    if (Objects.nonNull(poll)) {
                        poll.register(open2, SelectionKey.OP_READ);
                        open2.wakeup();
                    }
                    final int i = atomicInteger.get();
                    if (i >= 1000) {
                        System.out.println("建立了多少个链接: " + i);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                try {
                    if (open1.select(100) <= 0) {
                        continue;
                    }
                    final Set<SelectionKey> selectionKeys = open1.selectedKeys();
                    final Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        final SelectionKey next = iterator.next();
                        iterator.remove();
                        if (next.isValid() & next.isAcceptable()) {
                            final ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                            final SocketChannel accept = channel.accept();
                            atomicInteger.incrementAndGet();
                            if (Objects.nonNull(accept)) {
                                accept.configureBlocking(false);
                                objects.put(accept);
                                open2.wakeup();
                            }
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    System.out.println("建立链接数: " + atomicInteger.get());
                }
            }
        }).start();


    }
}
