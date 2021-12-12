package edu.diu.finalproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingBill {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int parkingBillId;

	public int getParkingBillId() {
		return parkingBillId;
	}

	public void setParkingBillId(int parkingBillId) {
		parkingBillId = parkingBillId;
	}

	public ParkingBill(int billNumber, Date billTime, float billAmount, int parkingBillId) {
	
		parkingBillId = parkingBillId;
	}

	public ParkingBill() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "ParkingBill [ParkingBillNumber=" + parkingBillId + "]";
	}

}
