package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fiche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	@OneToMany(mappedBy = "fiche")
	private List<Benificiaire> benificiares;


	public Fiche(int id, String designation, List<Benificiaire> benificiares) {
		super();
		this.id = id;
		this.designation = designation;
		this.benificiares = benificiares;
	}
	public Fiche() {
		super();
		// TODO Auto-generated constructor stub
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

	
	
}
