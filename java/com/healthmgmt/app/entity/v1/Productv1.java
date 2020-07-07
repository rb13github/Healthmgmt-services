package com.healthmgmt.app.entity.v1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Table(name="`ProductMaster`",schema="`public`")
@Table(name="`ProductMaster`")
public class Productv1 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemId_seq")
	@SequenceGenerator(sequenceName="`itemId_seq`",allocationSize = 1, name = "itemId_seq")
	@Column(name ="`ItemId`")
	private Long itemId;
	
	@Column(name="`ItemCode`")
	private String itemCode;
	
	@Column(name="`ItemDesc`")
	private String itemDesc;
	
	@Column(name="`ItemType`")
	private String itemType;
	
	@Column(name="`ItemUnit`")
	private String itemUnit;
	
	@Column(name="`BalanceQty`")
	private Double balanceQty;
	
	@Column(name="`UpdateDate`")
	private Date updateDate;
	
	@Column(name="`UpdateBy`")
	private Integer updateBy;
	
	@Column(name="`status`")
	private boolean isActive=true;
	
	public Productv1() {
		super();
	}
	public Productv1(Long itemId, String itemCode, String itemDesc, String itemType, String itemUnit,
			Double balanceQty, Date updateDate, Integer updateBy) {
		super();
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.itemDesc = itemDesc;
		this.itemType = itemType;
		this.itemUnit = itemUnit;
		this.balanceQty = balanceQty;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}
	public Double getBalanceQty() {
		return balanceQty;
	}
	public void setBalanceQty(Double balanceQty) {
		this.balanceQty = balanceQty;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	@Override
	public String toString() {
		return "Product [itemId=" + itemId + ", itemCode=" + itemCode + ", itemDesc=" + itemDesc + ", itemType="
				+ itemType + ", itemUnit=" + itemUnit + ", balanceQty=" + balanceQty + ", updateDate=" + updateDate
				+ ", updateBy=" + updateBy + "]";
	}
	
	

}
