package edu.diu.finalproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CleanerBill {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int cleanerBillId;

	public int getCleanerBillId() {
		return cleanerBillId;
	}

	public void setCleanerBillId(int cleanerBillId) {
		cleanerBillId = cleanerBillId;
	}

	public CleanerBill(int billNumber, Date billTime, float billAmount, int cleanerBillId) {
		
		cleanerBillId = cleanerBillId;
	}

	public CleanerBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CleanerBill(int billNumber, Date billTime, float billAmount) {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CleanerBill [CleanerBillId=" + cleanerBillId + "]";
	}

}
