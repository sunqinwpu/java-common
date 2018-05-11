package org.dolphin.study.java.netty;

import org.junit.Test;

/**
 * Created by qi.sun on 16/8/26.
 */
public class ByteTest {

    @Test public void testByte() {

        String ip = "10.11.255.3";

        byte[] bytes = new byte[21];
        // magic
        bytes[0] = 0x50;
        bytes[1] = 0x30;
        bytes[2] = 0x46;
        bytes[3] = 0x02;

        // type
        bytes[4] = 0x04;

        // ip
        String[] parts = ip.split(".");
        int i = 5;
        for (String part : parts) {
            bytes[i++] = (byte)Integer.parseInt(part);
        }



    }
}
