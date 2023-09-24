package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.example.demo.dao.AnnexeRepository;
import com.example.demo.dao.BenificiaireRepository;
import com.example.demo.dao.CategorieRepository;
import com.example.demo.dao.DistrictRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Annexe;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Benificiaire;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.District;
import com.example.demo.entities.Product;

@SpringBootApplication
public class CatalogueApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired
	private AnnexeRepository annexeRepository;
	@Autowired
	private BenificiaireRepository benificiaireRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	@Lazy
	private com.example.demo.services.AccountService accountService;
	@Bean
	public BCryptPasswordEncoder getBPE() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public ProjectionFactory projectionFactory() {
	    return new SpelAwareProxyProjectionFactory();
	}
	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		restConfiguration.exposeIdsFor(Annexe.class);
		restConfiguration.exposeIdsFor(District.class);
		restConfiguration.exposeIdsFor(Categorie.class);
		restConfiguration.exposeIdsFor(Benificiaire.class);
		restConfiguration.exposeIdsFor(CategorieRepository.class);
		restConfiguration.exposeIdsFor(BenificiaireRepository.class);
		restConfiguration.exposeIdsFor(AnnexeRepository.class);
		restConfiguration.exposeIdsFor(DistrictRepository.class);
		restConfiguration.exposeIdsFor(UserRepository.class);
		restConfiguration.exposeIdsFor(RoleRepository.class);
	
		if(accountService.finduserByUsrname("iftar")==null) {
			accountService.save(new AppUser(null,"iftar","Laayoune2023@",null,null));
			accountService.saveRole(new AppRole(null,"ADMIN"));
			accountService.saveRole(new AppRole(null,"USER"));
			accountService.addRoleToUser("iftar","ADMIN");
			accountService.addRoleToUser("iftar","USER");
		

		}


	}

}
