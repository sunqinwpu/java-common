package org.dolphin.study.java.chronical;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class OffHeapMapUtilTest {

    @Test
    public void putTest() {
        for (int i = 0; i < 10000; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("test" + i, "test" + i);
            OffHeapMapUtil.put("test" + i, map);
        }

        HashMap<String, String> targetMap = (HashMap<String, String>) OffHeapMapUtil.get("test" + 1000);
        Assert.assertEquals(targetMap.get("test" + 1000), "test" + 1000);
    }
    
    @Test
    public void testClear(){
        OffHeapMapUtil.clear();
        OffHeapMapUtil.size();
        Assert.assertEquals(0, OffHeapMapUtil.size());
    }
}
