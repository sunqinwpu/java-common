package org.dolphin.study.java.xml.object;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunqi
 * @version $Id: Blog.java, v 0.1 2015年12月22日 下午2:18:49 sunqi Exp $
 */
public class Blog {
    private Author writer;
    private List   entries = new ArrayList();

    public Blog(Author writer) {
        this.writer = writer;
    }

    public void add(Entry entry) {
        entries.add(entry);
    }

    public List getContent() {
        return entries;
    }
}
