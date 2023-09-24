package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	@OneToMany(mappedBy = "district")
	private List<Annexe> annexes;
	
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	public District(String designation) {
		super();
		this.designation = designation;
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


	public void setAnnexes(List<Annexe> annexes) {
		this.annexes = annexes;
	}
	
	
}
