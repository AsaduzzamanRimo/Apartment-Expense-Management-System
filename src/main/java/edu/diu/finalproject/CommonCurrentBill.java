package edu.diu.finalproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CommonCurrentBill  {
	
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int commonCurrentBillId;

	public CommonCurrentBill(int commonCurrentBillId) {
		super();
		commonCurrentBillId = commonCurrentBillId;
	}

	public CommonCurrentBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommonCurrentBill [CommonCurrentBillId=" + commonCurrentBillId + "]";
	}

	public int getCommonCurrentBillId() {
		return commonCurrentBillId;
	}

	public void setCommonCurrentBillId(int commonCurrentBillId) {
		commonCurrentBillId = commonCurrentBillId;
	}

}
