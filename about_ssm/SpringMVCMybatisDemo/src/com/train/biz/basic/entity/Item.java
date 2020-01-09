package com.train.biz.basic.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * 系统用户实体
 * 
 * @author Tong Baojun
 * 
 */
@XmlRootElement(name = "SysUsers")
@XmlType(name = "SysUser")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1256594705821295606L;
	private Integer itemId;
	private String itemCode;
	private String itemName;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	private String itemUnit;
	private String itemSpec;
	private String itemWeight;
	private String itemDrawNo;
	private Long highPrice;
	private Long newPrice;
	private Long lowPrice;
	private Integer useFlag;
	private String itemDescription;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getItemSpec() {
		return itemSpec;
	}

	public void setItemSpec(String itemSpec) {
		this.itemSpec = itemSpec;
	}

	public String getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(String itemWeight) {
		this.itemWeight = itemWeight;
	}

	public Long getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(Long highPrice) {
		this.highPrice = highPrice;
	}

	public Long getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Long newPrice) {
		this.newPrice = newPrice;
	}

	public Long getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(Long lowPrice) {
		this.lowPrice = lowPrice;
	}

	public Integer getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(Integer useFlag) {
		this.useFlag = useFlag;
	}

	public String getItemDrawNo() {
		return itemDrawNo;
	}

	public void setItemDrawNo(String itemDrawNo) {
		this.itemDrawNo = itemDrawNo;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", itemName=" + itemName + ", itemUnit=" + itemUnit
				+ ", itemSpec=" + itemSpec + ", itemWeight=" + itemWeight + ", itemDrawNo=" + itemDrawNo
				+ ", highPrice=" + highPrice + ", newPrice=" + newPrice + ", lowPrice=" + lowPrice + ", useFlag="
				+ useFlag + ", itemDescription=" + itemDescription + "]";
	}

	
	
	
}
