package com.example.demo.projections;

import javax.persistence.Entity;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.Benificiaire;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.District;


@Projection(name = "inlinePartie3", types = { Benificiaire.class })
public interface BenificiaireProjection {

	int getId();
	String getNom();
	String getCin();
	String getAddress();
	String getFiche();
	District getDistrict();
	String getAnnexeName();
	String getCategorieName();
	String getDistrictName();
	Categorie getCategorie();
	Annexe getAnnexe();
	String getIdentifiant(); 
}
