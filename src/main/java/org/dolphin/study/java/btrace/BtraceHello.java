package org.dolphin.study.java.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * Created by qi.sun on 2017/9/21.
 */
@BTrace
public class BtraceHello {

    @TLS
    private static long startTime;

    @OnMethod(clazz = "org.dolphin.study.java.btrace.Hello", method = "sayHello")
    public static void startSayHello() {
        startTime = BTraceUtils.currentThreadCpuTime();
    }

    @OnMethod(clazz = "org.dolphin.study.java.btrace.Hello", method = "sayHello", location = @Location(Kind.RETURN))
    public static void traceSayHello(@ProbeMethodName String probeMethodName) {
        BTraceUtils.println("interval : " + (BTraceUtils.currentThreadCpuTime() - startTime));
        BTraceUtils.println("probeMethodName : " + probeMethodName);
    }
}
