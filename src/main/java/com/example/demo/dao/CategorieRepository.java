package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.District;
@CrossOrigin(origins = "*")
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
