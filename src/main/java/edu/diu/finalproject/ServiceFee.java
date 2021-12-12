package edu.diu.finalproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceFee{
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int serviceFeeId;

	public int getServiceFeeId() {
		return serviceFeeId;
	}

	public void setServiceFeeId(int serviceFeeId) {
		serviceFeeId = serviceFeeId;
	}

	public ServiceFee(int billNumber, Date billTime, float billAmount, int serviceFeeId) {
		serviceFeeId = serviceFeeId;
	}

	public ServiceFee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ServiceFee [ServiceFeeId=" + serviceFeeId + "]";
	}

}
