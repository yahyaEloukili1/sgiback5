package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Annexe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	@ManyToOne()
	private District district;
	@OneToMany(mappedBy = "annexe")
	private List<Endroit> endroits;
	@OneToMany(mappedBy = "annexe")
	private List<AppUser> users;
	public Annexe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Annexe(String designation ,District distric) {
		super();
		
		this.designation = designation;
		this.district = distric;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public List<Endroit> getEndroits() {
		return endroits;
	}
	public List<AppUser> getUsers() {
		return users;
	}
	
	
}
