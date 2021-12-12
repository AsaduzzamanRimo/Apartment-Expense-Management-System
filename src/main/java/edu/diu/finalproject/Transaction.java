package edu.diu.finalproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int tId;
    private Date tTime;
    private float tMoney;
	public Transaction() {
		super();
	}
	public Transaction(int tId, Date tTime, float tMoney) {
		super();
		this.tId = tId;
		this.tTime = tTime;
		this.tMoney = tMoney;
	}
	@Override
	public String toString() {
		return "Transaction [tId=" + tId + ", tTime=" + tTime + ", tMoney=" + tMoney + "]";
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public Date gettTime() {
		return tTime;
	}
	public void settTime(Date tTime) {
		this.tTime = tTime;
	}
	public float gettMoney() {
		return tMoney;
	}
	public void settMoney(float tMoney) {
		this.tMoney = tMoney;
	} 

}
