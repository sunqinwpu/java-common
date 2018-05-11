package org.dolphin.study.java.btrace;

import org.junit.Test;

/**
 * Created by qi.sun on 2017/9/21.
 */
public class HelloTest {

    public static void main(String[] args) {
        try {
            new HelloTest().testHello();
        } catch (Exception e) {
        }
    }

    public void testHello() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            String value = new Hello().sayHello();
            System.out.println(value);
            Thread.sleep(2000);
        }
    }
}
