package com.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private float price;
	private String qyantity;
	private String authorname;
	private boolean avalaibleind;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getQyantity() {
		return qyantity;
	}
	public void setQyantity(String qyantity) {
		this.qyantity = qyantity;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public boolean isAvalaibleind() {
		return avalaibleind;
	}
	public void setAvalaibleind(boolean avalaibleind) {
		this.avalaibleind = avalaibleind;
	}
	
	
	
	
	
	
}
