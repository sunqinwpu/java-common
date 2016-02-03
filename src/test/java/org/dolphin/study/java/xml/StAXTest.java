/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package org.dolphin.study.java.xml;

import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 *
 * @author sunqi
 * @version $Id: StAXTest.java, v 0.1 2016年2月2日 下午2:14:39 sunqi Exp $
 */
public class StAXTest {
    /** */
    private static Logger logger = LogManager.getLogger(DomTest.class);

    /**
     * 测试SAX解析XML
     */
    @Test
    public void testStAXParse() {
        try {
            InputStream inputStream = DomTest.class.getClassLoader().getResourceAsStream(
                "xml/books.xml");
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
            while (xmlStreamReader.hasNext()) {
                int eventType = xmlStreamReader.next();
                // 如果是元素的开始  
                if (eventType == XMLStreamConstants.START_ELEMENT) {
                    logger.info("localName:" + xmlStreamReader.getLocalName());
                    for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                        logger.info("attribute name:" + xmlStreamReader.getAttributeName(i));
                        logger.info("attribute value:" + xmlStreamReader.getAttributeValue(i));
                    }
                }

                if (eventType == XMLStreamConstants.START_DOCUMENT) {
                    logger.info("start document");
                }
                if (eventType == XMLStreamConstants.END_DOCUMENT) {
                    logger.info("end document");
                }
                if (eventType == XMLStreamConstants.CHARACTERS) {
                    logger.info("text:" + xmlStreamReader.getText());
                }
            }
        } catch (Exception e) {
            logger.error("parse exception", e);
        }
    }
}
