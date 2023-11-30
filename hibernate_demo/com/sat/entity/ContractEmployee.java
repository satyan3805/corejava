package com.sat.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value = "contract_employee")
@Table(name="contract_emp")
@PrimaryKeyJoinColumn(name="id")
public class ContractEmployee extends Employee{
	
	@Column
	private double payPerHour;
	@Column
	private double contractDuration;
	
	public double getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(double payPerHour) {
		this.payPerHour = payPerHour;
	}
	public double getContractDuration() {
		return contractDuration;
	}
	public void setContractDuration(double contractDuration) {
		this.contractDuration = contractDuration;
	}
	
	
}
