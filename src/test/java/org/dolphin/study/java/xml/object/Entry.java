package org.dolphin.study.java.xml.object;

/**
 *
 * @author sunqi
 * @version $Id: Entry.java, v 0.1 2015年12月22日 下午2:19:48 sunqi Exp $
 */
public class Entry {
    /** */
    private String title;
    /** */
    private String description;

    /**
     * @param title
     * @param description
     */
    public Entry(String title, String description) {
        this.setTitle(title);
        this.setDescription(description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
