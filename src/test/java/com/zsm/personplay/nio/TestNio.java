package com.zsm.personplay.nio;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * created by zsm on 2020/3/17
 */
public class TestNio {
    public static void main(String[] args) throws Exception{
        IntBuffer buffer = IntBuffer.allocate(10);
        for(int i = 0; i < buffer.capacity(); i++){
            int randonNumber = new SecureRandom().nextInt(20);
            buffer.put(randonNumber);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println();
        }
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("xxx来连接");
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            System.out.println("收到客户端的消息" + new String(bytes));

        }
    }
}
