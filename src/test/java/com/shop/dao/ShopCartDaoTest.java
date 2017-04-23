package com.shop.dao;

import com.shop.domain.ShopCart;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;


public class ShopCartDaoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: insert(ShopCart sc) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here... 
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
* Method: update(ShopCart sc) 
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
* Method: findAll(int Cid) 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here...
    ShopCartDao scd = new ShopCartDao();
    int cid = 10000;
    List<ShopCart> list = scd.findAll(cid);
    System.out.println(list);
    assertNotNull(list);
} 

/** 
* 
* Method: getShopCart(ResultSet rs) 
* 
*/ 
@Test
public void testGetShopCart() throws Exception { 
//TODO: Test goes here... 
} 


} 
