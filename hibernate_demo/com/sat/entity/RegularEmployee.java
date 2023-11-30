package com.sat.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value = "reg_employee")
@Table(name="reg_emp")
@PrimaryKeyJoinColumn(name="id")
public class RegularEmployee extends Employee{
	
	@Column
	private double salary;
	@Column
	private double bonus;
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	
}
