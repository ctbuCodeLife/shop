package com.shop.utils;

import com.shop.utils.DBUtil;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Steven on 2017/4/6.
 */
public class DBUtilTest {
    @Test
    public void testConn(){
        assertNotNull(DBUtil.getConnection());
    }
}
