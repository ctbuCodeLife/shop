package com.shop.domain;

import java.sql.Timestamp;

public class Product {
    private int id;
    private String pName;
    private String pDesc;
    private int pNum;
    private Timestamp pubTime;
    private int pKeepTime;
    private String pImage;
    private int kId;
    private int iPrice;
    private int mPrice;
    private String isHot;
    private String isShow;
	@Override
	public String toString() {
		return "Product [id=" + id + ", pName=" + pName + ", pDesc=" + pDesc + ", pubTime=" + pubTime + ", pKeepTime="
				+ pKeepTime + ", pImage=" + pImage + ", kId=" + kId + ", iPrice=" + iPrice + ", mPrice=" + mPrice
				+ ", isHot=" + isHot + ", isShow=" + isShow + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public Timestamp getPubTime() {
		return pubTime;
	}
	public void setPubTime(Timestamp pubTime) {
		this.pubTime = pubTime;
	}
	public int getpKeepTime() {
		return pKeepTime;
	}
	public void setpKeepTime(int pKeepTime) {
		this.pKeepTime = pKeepTime;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public int getkId() {
		return kId;
	}
	public void setkId(int kId) {
		this.kId = kId;
	}
	public int getiPrice() {
		return iPrice;
	}
	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
	public String getIsHot() {
		return isHot;
	}
	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
}
