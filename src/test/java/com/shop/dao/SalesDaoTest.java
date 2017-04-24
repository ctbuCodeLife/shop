package com.shop.dao; 

import com.shop.domain.Sales;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class SalesDaoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: insert(Sales sales) 
* 
*/ 
@Test
public void testInsert() throws Exception {
    //插入测试成功
//
    //设置sales对象
    Sales sales = new Sales();
    sales.setcId(10005);
    sales.setpId(10001);
    sales.setCount(2);
//    BigDecimal unitPrice = new BigDecimal(999.01);
//    BigDecimal totalPrice ;
//    totalPrice = unitPrice.multiply(new BigDecimal(2));
//    System.out.println(totalPrice);
    double unitPrice = 999.00;
    int count = 2;
    double totalPrice = unitPrice * count;
    sales.setTotalPrice(totalPrice);
    //插入到sales表
    SalesDao sd = new SalesDao();
    boolean result = sd.insert(sales);
    assertTrue(result);
} 

/** 
* 
* Method: delete(int id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: update(Sales sales) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: find(int id) 
* 
*/ 
@Test
public void testFind() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll(int cid) 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSales(ResultSet rs) 
* 
*/ 
@Test
public void testGetSales() throws Exception { 
//TODO: Test goes here... 
} 

@Test
public void testFindShow() {
    int cid = 10006;
    SalesDao sd = new SalesDao();
    List<Sales> list = sd.findShow(cid);
    System.out.println(list);
//    for (Sales s : list) {
//        System.out.println(s);
//    }
    assertNotNull(list);
}
}
