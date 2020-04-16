package com.zsm.personplay.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * created by zsm on 2020/3/17
 */
public class TestNio {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for(int i = 0; i < buffer.capacity(); i++){
            int randonNumber = new SecureRandom().nextInt(20);
            buffer.put(randonNumber);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println();
        }
    }
}
