package com.example.demo.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.District;
@CrossOrigin(origins = "*")
public interface DistrictRepository extends JpaRepository<District, Integer> {

	
	@RestResource(path= "/byDistrictPage")
	public Page<District> findByDesignationContainsIgnoreCase(@Param("mc") String pr,Pageable peaPageable);
}
