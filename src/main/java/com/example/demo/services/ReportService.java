package com.example.demo.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.dao.BenificiaireRepository;
import com.example.demo.dao.BenificiaireRepository2;
import com.example.demo.dao.EndroitRepository;
import com.example.demo.entities.Benificiaire;
import com.example.demo.entities.BenificiaireArchive;
import com.example.demo.entities.Endroit;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	@Autowired
	private EndroitRepository ficheRepository;
	@Autowired
	private BenificiaireRepository2 benificiaireRepository2;
	@Autowired
	private BenificiaireRepository benificiaireRepository;
	@Autowired
	private ResourceLoader resourceLoader;
	public List<Benificiaire> getBenificiairesGroupedByCin() {
	    List<Benificiaire> benificiaires = benificiaireRepository.findAll();
	    Map<String, List<Benificiaire>> groupedByCin = benificiaires.stream()
	        .collect(Collectors.groupingBy(Benificiaire::getCin));
	    return groupedByCin.values().stream()
	        .filter(list -> list.size() > 1)
	        .flatMap(List::stream)
	        .collect(Collectors.toList());
	}
	public void exportReport3(String reportFormat,List<Endroit> data, String fileInput, String reportTitle, HttpServletResponse response) throws JRException, IOException {
		   
		for (Endroit endroit : data) {
		    endroit.setReportTitle(reportTitle);
		    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		 System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	    // Compile the JasperReport
	    JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fileInput));

	    // Set up the data source and report parameters
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
	    Map<String, Object> params = new HashMap<>();
	    params.put("CreatedBy", "Java techi");

	    // Fill the report and write it to the response output stream
	    // Fill the report and write it to the response output stream
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
	    response.setContentType("application/" + reportFormat);
	    response.setHeader("Content-Disposition", "attachment; filename=\"report." + reportFormat + "\"");
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	public void exportReport(String reportFormat, String fileInput, HttpServletResponse response) throws JRException, IOException {
	    List<Endroit> projects = ficheRepository.findAll();

	    // Compile the JasperReport
	    JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fileInput));

	    // Set up the data source and report parameters
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projects);
	    Map<String, Object> params = new HashMap<>();
	    params.put("CreatedBy", "Java techi");

	    // Fill the report and write it to the response output stream
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
	    response.setContentType("application/" + reportFormat);
	    response.setHeader("Content-Disposition", "attachment; filename=\"report." + reportFormat + "\"");
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	public void exportReportArchive(String reportFormat, String fileInput, HttpServletResponse response) throws JRException, IOException {
	    List<BenificiaireArchive> projects = benificiaireRepository2.findAll();

	    // Compile the JasperReport
	    JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fileInput));

	    // Set up the data source and report parameters
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projects);
	    Map<String, Object> params = new HashMap<>();
	    params.put("CreatedBy", "Java techi");

	    // Fill the report and write it to the response output stream
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
	    response.setContentType("application/" + reportFormat);
	    response.setHeader("Content-Disposition", "attachment; filename=\"report." + reportFormat + "\"");
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	public void exportReport2(String reportFormat, String fileInput, HttpServletResponse response) throws JRException, IOException {
	    List<Benificiaire> projects = getBenificiairesGroupedByCin();

	    // Compile the JasperReport
	    JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fileInput));

	    // Set up the data source and report parameters
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projects);
	    Map<String, Object> params = new HashMap<>();
	    params.put("CreatedBy", "Java techi");

	    // Fill the report and write it to the response output stream
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
	    response.setContentType("application/" + reportFormat);
	    response.setHeader("Content-Disposition", "attachment; filename=\"report." + reportFormat + "\"");
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}



}
