package com.example.demo.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.AnnexeRepository;
import com.example.demo.dao.BenificiaireRepository;
import com.example.demo.dao.BenificiaireRepository2;
import com.example.demo.entities.Annexe;
import com.example.demo.entities.Benificiaire;
import com.example.demo.services.ReportService;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin("*")
@RestController
public class BenificiaireController {

	@Autowired
	BenificiaireRepository ficheRepository;
	@Autowired
	BenificiaireRepository2 ficheRepository2;

	@Autowired
	AnnexeRepository annexeRepository;
	@Autowired
	ReportService reportService;
//	@GetMapping("/report/{format}")
//	public String generateReport(@PathVariable String format) throws JRException, IOException  {
//		return reportService.exportReport(format);
//	}c
	
	
	@GetMapping("/all")
	public List<Benificiaire> getAllBenificiaires(){
		return ficheRepository.findAll();
	}
	@GetMapping("/allAAL")
	public List<Annexe> getAllAAL(){
		return annexeRepository.findAll();
	}

	
	@GetMapping("/doublons")
	public List<Benificiaire> getBenificiairesGroupedByCin() {
	    List<Benificiaire> benificiaires = ficheRepository.findAll();
	    Map<String, List<Benificiaire>> groupedByCin = benificiaires.stream()
	            .collect(Collectors.groupingBy(b -> b.getCin().trim().toLowerCase()));
	    return groupedByCin.values().stream()
	        .filter(list -> list.size() > 1)
	        .flatMap(List::stream)
	        .collect(Collectors.toList());
	}

	  @GetMapping("/benif2")
	  public  List<Annexe> getBenificiairesGroupedByCin2() {
	    List<Annexe> benificiaires = annexeRepository.findAll();
	    return benificiaires;
	  }
	  
	  
	  
	@GetMapping("/report/{format}")
	public void generateReport(@PathVariable String format, HttpServletResponse response) throws JRException, IOException {
	    reportService.exportReport(format, "C:\\allProjects.jrxml", response);
	}
	@GetMapping("/reportArchive/{format}")
	public void generateReportArchive(@PathVariable String format, HttpServletResponse response) throws JRException, IOException {
	    reportService.exportReportArchive(format, "C:\\allProjects.jrxml", response);
	}

	@GetMapping("/report2/{format}")
	public void generateReport2(@PathVariable String format, HttpServletResponse response) throws JRException, IOException {
	    reportService.exportReport2(format, "C:\\allProjects2.jrxml", response);
	}


	@GetMapping(path="fiche/{id}",produces=org.springframework.http.MediaType.APPLICATION_PDF_VALUE)
	public byte[] getPhoto(@PathVariable("id") int id) throws IOException {
		//Affectation f = affectationRepository.findById(id).get();
		//return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Downloads/"+f.getFicheName()+".pdf"));
	return Files.readAllBytes(Paths.get("C:\\report\\"+"dr"+".pdf"));
	}
	@GetMapping("/getLast")
	public Benificiaire getLastFiche() {
		List<Benificiaire> fiches = ficheRepository.findAll();
		int j = 0;
		Benificiaire fiche = null;
	for(int i=0;i<fiches.size();i++) {
		if(fiches.get(i).getId()>j) {
			j = fiches.get(i).getId();
			fiche = fiches.get(i);
		}
	}
	return fiche;
	}
}