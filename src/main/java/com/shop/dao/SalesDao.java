package com.shop.dao;

import com.shop.domain.Sales;
import com.shop.utils.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SalesDao extends DBUtil {

    /**
     * 插入一个sales对象
     *
     * @param sales 订单表
     * @return
     */
    public boolean insert(Sales sales) {
       //sql语句
        String sql = "insert into sales(cid,pid,count,totalPrice,orderDate,invoiceNo,orderStatus) values(?,?,?,?,?,?,?)";
        //sql参数
        Object[] params = {
                sales.getcId(),
                sales.getpId(),
                sales.getCount(),
                sales.getTotalPrice(),
                sales.getOrderDate(),
                sales.getInvoiceNo(),
                sales.getOrderStatus(),
        };try {
            int n = this.doUpdate(sql, params);
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return false;
    }

    /**
     * 按照ID删除订单
     *
     * @param id 订单ID
     * @return
     */
    public boolean delete(int id) {
        String sql = "delete from sales where id="+id;
        try {
            int n = this.doUpdate(sql);
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return false;
    }

    /**
     * 修改订单
     *
     * @param sales 
     * @return
     */
    public boolean update(Sales sales) {
        String sql = "update  set cId=?,pId=?,count=?,totalPrice=?,orderDate=?,invoiceNo=?,orderStaus=?,delivDate where id=?";
        Object[] params = {
                sales.getcId(),
                sales.getpId(),
                sales.getCount(),
                sales.getTotalPrice(),
                sales.getOrderDate(),
                sales.getInvoiceNo(),
                sales.getOrderStatus(),
                sales.getDelivDate(),
                sales.getId()
        };
        try {
            int n = this.doUpdate(sql, params);
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return false;
    }

    /**
     * 按照Name查找订单
     *
     * @param id 订单ID 
     * @return
     */
    public Sales find(int id) {
        String sql = "select * from sales where id = "+id;
        try {
            this.rs = this.doQuery(sql);
            if (rs.next()) {
                return getSales(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }
    /**
     * 查找某用户id的所有购物车
     *
     * @return
     */
    public ArrayList<Sales> findAll(int cid) {
        String sql = "select * from sales where cId = ? order by id";
        ArrayList<Sales> list = new ArrayList<Sales>();
        Object[] params = {cid};
        try {
            this.rs = this.doQuery(sql, params);
            while (rs.next()) {
                list.add( getSales(rs));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }
    public Sales getSales(ResultSet rs) {
        try{
            if(rs != null) {
                Sales sales = new Sales();
                sales.setcId(rs.getInt(1));
                sales.setpId(rs.getInt(2));
                sales.setCount(rs.getInt(3));
                sales.setTotalPrice(rs.getBigDecimal(4));
                sales.setOrderDate(rs.getTimestamp(5));
                sales.setInvoiceNo(rs.getString(6));
                sales.setOrderStatus(rs.getString(7));
                sales.setDelivDate(rs.getTimestamp(8));
                return sales;
            }else{
                return null;
            }
        }catch(Exception e ) {
            e.printStackTrace();
        }
        return null;
    }
}
