package edu.diu.finalproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	private String billName;
	private Date billTime;
	private float billAmount;
	
	public Bill(int billId, String billName, Date billTime, float billAmount) {
		super();
		this.billId = billId;
		this.billName = billName;
		this.billTime = billTime;
		this.billAmount = billAmount;
	}

	public Bill(int billId, String billName) {
		super();
		this.billId = billId;
		this.billName = billName;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billName=" + billName + ", billTime=" + billTime + ", billAmount="
				+ billAmount + "]";
	}
	
	
	public Bill() {
		
	}


	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getBillName() {
		return billName;
	}
	public void setBillName(String billName) {
		this.billName = billName;
	}
	public Date getBillTime() {
		return billTime;
	}
	public void setBillTime(Date billTime) {
		this.billTime = billTime;
	}
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

}
