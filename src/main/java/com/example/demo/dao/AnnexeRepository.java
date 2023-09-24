package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Annexe;
import com.example.demo.entities.Endroit;
import com.example.demo.projections.AnnexeProjection;

@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = AnnexeProjection.class)
public interface AnnexeRepository extends JpaRepository<Annexe, Integer> {
	List<Annexe> findByDistrictId(Integer id);
}
