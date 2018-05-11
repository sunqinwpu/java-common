package org.dolphin.study.java.btrace;

import java.util.Date;

/**
 * Created by qi.sun on 2017/9/21.
 */
public class Hello {

    public String sayHello() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }
        return "Hello, time : " + new Date();
    }
}
