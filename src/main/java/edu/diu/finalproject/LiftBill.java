package edu.diu.finalproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class LiftBill{
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int liftBillId;
	

	public LiftBill() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LiftBill(int billNumber, Date billTime, float billAmount, int liftBillId) {
		this.liftBillId = liftBillId;
	}

	@Override
	public String toString() {
		return "LiftBill [liftBillId=" + liftBillId + "]";
	}

	public int getLiftBillId() {
		return liftBillId;
	}

	public void setLiftBillId(int liftBillId) {
		this.liftBillId = liftBillId;
	}

}
