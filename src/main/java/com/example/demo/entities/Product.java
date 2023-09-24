package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String designation;
	private int quantite;
	private double prix;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product( String designation, int quantite, double prix) {
		super();
	
		this.designation = designation;
		this.quantite = quantite;
		this.prix = prix;
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


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", designation=" + designation + ", quantite=" + quantite + ", prix=" + prix + "]";
	}
	
	
	
}
