package com.hibernate;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Categories {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="catId")
	private int categoryId;
	@Column(name="catname")
	private String categoryName;
	@ManyToMany(targetEntity=Item.class, cascade=CascadeType.ALL)
	@JoinTable(name="categories_items", joinColumns=@JoinColumn(name="cat_fk", referencedColumnName="catid"),
	inverseJoinColumns=@JoinColumn(name="item_fk",referencedColumnName="itemid"))
	private Set<Item> items;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
}



