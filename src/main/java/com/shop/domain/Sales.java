package com.shop.domain;

import java.sql.Timestamp;
import java.util.Date;
public class Sales {
    private long id;
    private int cId;
    private int pId;
    private int count;
    private int totalPrice;
    private Timestamp orderDate;
    private String invoiceNo;
    private String orderStatus;
    private Timestamp delivDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Timestamp getDelivDate() {
		return delivDate;
	}
	public void setDelivDate(Timestamp delivDate) {
		this.delivDate = delivDate;
	}
	@Override
	public String toString() {
		return "Sales [id=" + id + ", cId=" + cId + ", pId=" + pId + ", count=" + count + ", totalPrice=" + totalPrice
				+ ", orderDate=" + orderDate + ", invoiceNo=" + invoiceNo + ", orderStatus=" + orderStatus
				+ ", delivDate=" + delivDate + "]";
	}
    
}
