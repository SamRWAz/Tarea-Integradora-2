package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;


public class Project{
	
	private String name;
	private String clientName;
	private ProjectType projectType;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
	private String contactos;
	private Etapa etapa;

	private DateFormat formatter;

	public Project(String name, String clientName, ProjectType projectType, Calendar initialDate, Calendar finalDate, double budget, String contactos, Etapa etapa){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");

		this.name = name;	
		this.clientName = clientName;
		this.projectType = projectType;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
		this.contactos = contactos;
		this.etapa = etapa;
	}

	public String getName(){
		return name;
	}
	
	public String getClientName(){
		return clientName;
	}

	public ProjectType getProjectType(){
		return projectType;
	}

	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated() throws ParseException{
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated() throws ParseException{
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;
	}

	public String getContactos(){
		return contactos;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Etapa getEtapa(){
		return etapa;
	}

	public String getProjectInfo() throws ParseException{
		
		return "\nName: " + name + "\nClient: " + clientName + "\nProject Type: " + projectType + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + "\nGerentes encargados: " + contactos + "\nEtapa: " + etapa + ". - ACTIVA\n";
	}
}


