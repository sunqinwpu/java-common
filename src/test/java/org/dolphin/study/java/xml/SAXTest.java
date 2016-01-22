/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package org.dolphin.study.java.xml;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.helpers.DefaultHandler;

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
        try {
            InputStream inputStream = DomTest.class.getClassLoader().getResourceAsStream(
                "xml/books.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, new BooksHandler());
        } catch (Exception e) {
            logger.error("parse exception", e);
        }
    }
}

/**
 *
 * @author sunqi
 * @version $Id: SAXTest.java, v 0.1 2016年1月19日 下午3:52:36 sunqi Exp $
 */
class BooksHandler extends DefaultHandler {

}