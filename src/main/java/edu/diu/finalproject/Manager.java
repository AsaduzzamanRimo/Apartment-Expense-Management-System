package edu.diu.finalproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int mId;
    private String mName;
    private String mEmail;
    private int mAge;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(int mId, String mName, String mEmail, int mAge) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mAge = mAge;
	}
	@Override
	public String toString() {
		return "Manager [mId=" + mId + ", mName=" + mName + ", mEmail=" + mEmail + ", mAge=" + mAge + "]";
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public int getmAge() {
		return mAge;
	}
	public void setmAge(int mAge) {
		this.mAge = mAge;
	}

}
