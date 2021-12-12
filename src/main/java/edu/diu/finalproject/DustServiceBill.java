package edu.diu.finalproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class DustServiceBill  {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int dustServiceBillId;

	public int getDustServiceBillId() {
		return dustServiceBillId;
	}

	public void setDustServiceBillId(int dustServiceBillId) {
		this.dustServiceBillId = dustServiceBillId;
	}

	public DustServiceBill(int billNumber, Date billTime, float billAmount, int dustServiceBillId) {
		
		this.dustServiceBillId = dustServiceBillId;
	}

	public DustServiceBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DustServiceBill [dustServiceBillId=" + dustServiceBillId + "]";
	}

}
