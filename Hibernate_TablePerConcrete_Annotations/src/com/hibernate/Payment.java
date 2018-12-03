package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity  
@Table(name = "Payment5") 
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	
	@Column(name = "id")  
	private int id;
	@Column(name = "ampount")  
	private int amount;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}






