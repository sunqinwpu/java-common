package org.dolphin.study.java.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author qi.sq
 * @version $Id: DomTest.java, v 0.1 2016年1月18日 下午10:02:23 sunqi Exp $
 */
public class DomTest {
    /** */
    private static Logger logger = LogManager.getLogger(DomTest.class);

    /**
     * 测试
     */
    @Test
    public void testDomParse() {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            InputStream inputStream = DomTest.class.getClassLoader().getResourceAsStream(
                "xml/books.xml");
            Document document = builder.parse(inputStream);
            Element rootElement = document.getDocumentElement();
            NodeList nodes = rootElement.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element child = (Element) node;
                    String id = child.getAttribute("id");
                    logger.info(id);
                    NodeList nodeList = child.getChildNodes();
                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Node valueNode = nodeList.item(j);
                        if (StringUtils.equals(valueNode.getNodeName(), "title")) {
                            String title = valueNode.getChildNodes().item(0).getNodeValue();
                            logger.info("title:" + title);
                        }
                        if (StringUtils.equals(valueNode.getNodeName(), "author")) {
                            String title = valueNode.getChildNodes().item(0).getNodeValue();
                            logger.info("title:" + title);
                        }
                    }
                }
            }

            NodeList nodeList = rootElement.getElementsByTagName("book");
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    String id = element.getAttribute("id");
                    logger.info(id);
                    // 同上
                }
            }
        } catch (Exception e) {
            logger.error("parse exception", e);
        }
    }
}
