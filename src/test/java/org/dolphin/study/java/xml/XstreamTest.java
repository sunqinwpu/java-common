package org.dolphin.study.java.xml;

import org.dolphin.study.java.xml.object.Author;
import org.dolphin.study.java.xml.object.AuthorConverter;
import org.dolphin.study.java.xml.object.Blog;
import org.dolphin.study.java.xml.object.Entry;
import org.dolphin.study.java.xml.xstream.TestDolphin;
import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

/**
 *
 * @author sunqi
 * @version $Id: XstreamTest.java, v 0.1 2015年12月22日 上午11:08:11 sunqi Exp $
 */
public class XstreamTest {
    /**
     *
     */
    @Test
    public void testToXml() {
        TestDolphin testDolphin = new TestDolphin();
        testDolphin.setName("andrew");
        XStream xStream = new XStream();
        xStream.alias("dolphin", TestDolphin.class);
        String xml = xStream.toXML(testDolphin);
        System.out.println("testDolphin:\n" + xml);

        TestDolphin newTestDolphin = (TestDolphin) xStream.fromXML(xml);
        Assert.assertEquals(newTestDolphin.isSmart(), testDolphin.isSmart());
    }

    @Test
    public void testToStarndXml() {
        Blog teamBlog = new Blog(new Author("Guilherme Silveira"));
        teamBlog.add(new Entry("first", "My first blog entry."));
        teamBlog.add(new Entry("tutorial",
            "Today we have developed a nice alias tutorial. Tell your friends! NOW!"));
        XStream xstream = new XStream();

        // class alias
        xstream.alias("blog", Blog.class);
        xstream.alias("entry", Entry.class);

        // field alias
        xstream.aliasField("author", Blog.class, "writer");

        // Implicit Collections
        xstream.addImplicitArray(Blog.class, "entries");

        // field as attribute
        xstream.useAttributeFor(Blog.class, "writer");
        xstream.registerConverter(new AuthorConverter());

        System.out.println("xml:");
        System.out.println(xstream.toXML(teamBlog));
    }
}
