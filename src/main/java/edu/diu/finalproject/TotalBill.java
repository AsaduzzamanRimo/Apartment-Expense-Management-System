package edu.diu.finalproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TotalBill {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int billNumber;
    private Date billTime;
    private float billAmount;

    public TotalBill(int billNumber, Date billTime, float billAmount) {
		super();
		this.billNumber = billNumber;
		this.billTime = billTime;
		this.billAmount = billAmount;
	}

	public TotalBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TotalBill [billNumber=" + billNumber + ", billTime=" + billTime + ", billAmount=" + billAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(billAmount);
		result = prime * result + billNumber;
		result = prime * result + ((billTime == null) ? 0 : billTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TotalBill other = (TotalBill) obj;
		if (Float.floatToIntBits(billAmount) != Float.floatToIntBits(other.billAmount))
			return false;
		if (billNumber != other.billNumber)
			return false;
		if (billTime == null) {
			if (other.billTime != null)
				return false;
		} else if (!billTime.equals(other.billTime))
			return false;
		return true;
	}

	public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
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
