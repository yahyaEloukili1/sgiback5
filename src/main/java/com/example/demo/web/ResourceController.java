package com.example.demo.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
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

import com.example.demo.dao.EndroitRepository;
import com.example.demo.entities.Annexe;

import com.example.demo.entities.Endroit;
import com.example.demo.services.ReportService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin("*")
@RestController
public class ResourceController {

	@Autowired
	EndroitRepository endroitsrRepository;

	@Autowired
	AnnexeRepository annexeRepository;
	@Autowired
	ReportService reportService;
	@GetMapping("/endroits2")
	public List<Endroit> getAllBenificiaires(){
		return endroitsrRepository.findAll();
	}
	@GetMapping("/allAAL")
	public List<Annexe> getAllAAL(){
		return annexeRepository.findAll();
	}

	@PostMapping("/report4")
	public void generateReport5(@RequestBody Map<String, String> request, HttpServletResponse response) throws JRException, IOException {
	    String reportTitle = request.get("reportTitle");
	    String dataJson = request.get("data");
	    List<Endroit> data = new ObjectMapper().readValue(dataJson, new TypeReference<List<Endroit>>(){});
	    reportService.exportReport3("pdf", data, "C:\\allProjects.jrxml", reportTitle, response);
	}





	 
}