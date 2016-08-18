package org.dolphin.study.java.netty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by qi.sun on 16/8/16.
 */
public class HelloNettyServerTest {

    private static Logger logger = LogManager.getLogger(HelloServerHandler.class);

    @Test public void testNettyServer() {
        new HelloNettyServer(8080).start();
        logger.info("finish start ");
    }
}
