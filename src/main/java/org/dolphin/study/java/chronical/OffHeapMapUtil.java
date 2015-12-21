package org.dolphin.study.java.chronical;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OffHeapMapUtil {

    private static String                             fileName = "/tmp/chronicleMap";
    private static ChronicleMap<String, Serializable> map;
    private static Logger                             logger   = LoggerFactory.getLogger(OffHeapMapUtil.class);
    static {
        try {
            map = ChronicleMapBuilder.of(String.class, Serializable.class).createPersistedTo(new File(fileName));
        } catch (IOException e) {
            logger.error("create map error", e);
        }
    }

    public static void put(String key, Serializable value) {
        map.put(key, value);
    }

    public static Serializable get(String key) {
        return map.get(key);
    }

    public static void clear() {
        map.clear();
    }

    public static int size() {
        return map.size();
    }
}
