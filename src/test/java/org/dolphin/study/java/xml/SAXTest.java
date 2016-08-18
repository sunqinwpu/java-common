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
import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author sunqi
 * @version $Id: SAXTest.java, v 0.1 2016��1��18�� ����11:17:22 sunqi Exp $
 */
public class SAXTest {
    /** */
    private static Logger logger = LogManager.getLogger(DomTest.class);

    /**
     * ����SAX����XML
     */
    @Test
    public void testSaxParse() {
        try {
            InputStream inputStream = DomTest.class.getClassLoader().getResourceAsStream(
                "xml/booksll.xml");
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
 * @version $Id: SAXTest.java, v 0.1 2016��1��19�� ����3:52:36 sunqi Exp $
 */
class BooksHandler extends DefaultHandler {
    /** */
    private static Logger logger = LogManager.getLogger(DomTest.class);

    @Override
    public void startDocument() throws SAXException {
        logger.info("start document");
    }

    @Override
    public void endDocument() throws SAXException {
        logger.info("end document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
                                                                                               throws SAXException {
        logger.info("start element, uri:" + uri + ",localName:" + localName + ",qName:" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            logger
                .info("attributes qName:" + attributes.getQName(i) + ":" + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        logger.info("end element, uri:" + uri + ",localName:" + localName + ",qName:" + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        logger.info("element value:" + new String(ch, start, length));
    }
}