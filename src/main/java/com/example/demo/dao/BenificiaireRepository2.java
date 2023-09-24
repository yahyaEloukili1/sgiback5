package com.example.demo.dao;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.Benificiaire;

import com.example.demo.entities.BenificiaireArchive;
import com.example.demo.entities.Categorie;
import com.example.demo.projections.AnnexeProjection;
import com.example.demo.projections.BenificiaireProjection;
import com.example.demo.projections.BenificiaireProjection2;

@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = BenificiaireProjection2.class)
public interface BenificiaireRepository2 extends JpaRepository<BenificiaireArchive, Integer> {

	@Query("SELECT b.cin, b FROM BenificiaireArchive b")
	List<Object[]> findByCinGrouped();
	List<BenificiaireArchive> findByCinIgnoreCase(String cin);

	List<BenificiaireArchive> findByAnnexeId(Integer id);

}
