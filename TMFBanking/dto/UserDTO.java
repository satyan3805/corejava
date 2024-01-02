package com.sat.tmf.bank.dto;

public class UserDTO {
	
	private String userId;
	private String uname;
	private String fullName;
	private String accountID;
	private String currBal;
	private String lastTxnDdatTime;
	
	
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(String userId,String uname, String fullName, String accountID, String currBal, String lastTxnDdatTime) {
		super();
		this.userId = userId;
		this.uname = uname;
		this.fullName = fullName;
		this.accountID = accountID;
		this.currBal = currBal;
		this.lastTxnDdatTime = lastTxnDdatTime;
	}
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getCurrBal() {
		return currBal;
	}
	public void setCurrBal(String currBal) {
		this.currBal = currBal;
	}
	public String getLastTxnDdatTime() {
		return lastTxnDdatTime;
	}
	public void setLastTxnDdatTime(String lastTxnDdatTime) {
		this.lastTxnDdatTime = lastTxnDdatTime;
	}
	
	
}
