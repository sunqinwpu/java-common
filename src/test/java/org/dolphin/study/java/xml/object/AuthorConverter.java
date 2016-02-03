package org.dolphin.study.java.xml.object;

import com.thoughtworks.xstream.converters.SingleValueConverter;

/**
 *
 * @author sunqi
 * @version $Id: AuthorConverter.java, v 0.1 2015年12月22日 下午2:34:05 sunqi Exp $
 */
public class AuthorConverter implements SingleValueConverter {

    public String toString(Object obj) {
        return ((Author) obj).getName();
    }

    public Object fromString(String name) {
        return new Author(name);
    }

    public boolean canConvert(Class type) {
        return type.equals(Author.class);
    }
}
