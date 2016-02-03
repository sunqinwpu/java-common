/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package org.dolphin.study.java.xml;

import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

/**
 *
 * @author sunqi
 * @version $Id: JDomTest.java, v 0.1 2016年2月3日 上午10:12:07 sunqi Exp $
 */
public class JDomTest {
    /** */
    private static Logger logger = LogManager.getLogger(JDomTest.class);

    /**
     *
     */
    @Test
    public void testJdomParse() {
        try {
            InputStream inputStream = DomTest.class.getClassLoader().getResourceAsStream(
                "xml/books.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputStream);
            Element books = document.getRootElement();
            logger.info("books name:" + books.getName());
            List<Element> bookList = books.getChildren();
            for (Element element : bookList) {
                logger.info("book attribute id:" + element.getAttributeValue("id"));
                List<Element> childElements = element.getChildren();
                for (Element childElement : childElements) {
                    logger.info("book child " + childElement.getName() + ",value:"
                                + childElement.getText());
                }
            }
        } catch (Exception e) {
            logger.error("parse error", e);
        }
    }
}
