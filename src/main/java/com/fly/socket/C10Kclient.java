package com.fly.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @author: 马士兵教育
 * @create: 2020-06-06 15:12
 */
public class C10Kclient {

    public static void main(String[] args) {
        LinkedList<SocketChannel> clients = new LinkedList<>();
        InetSocketAddress serverAddr = new InetSocketAddress("10.211.55.8", 10222);

        for (int i = 40000; i < 65000; i++) {
            try {
                SocketChannel client2 = SocketChannel.open();
                client2.bind(new InetSocketAddress("10.211.55.2", i));
                client2.connect(serverAddr);
                boolean c2 = client2.isOpen();
                clients.add(client2);
                System.out.println("clients "+ clients.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
