/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package org.dolphin.study.java.xml;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author sunqi
 * @version $Id: SAXTest.java, v 0.1 2016年1月18日 下午11:17:22 sunqi Exp $
 */
public class SAXTest {
    /** */
    private static Logger logger = LogManager.getLogger(DomTest.class);

    /**
     * 测试SAX解析XML
     */
    public void testSaxParse() {
        InputStream inputStream = DomTest.class.getClassLoader().getResourceAsStream(
            "xml/books.xml");
        
    }
}
