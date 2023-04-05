package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class Controller {

	private Project[] projects;
	private KnowledgeUnit[] units;

	public Controller() {

		projects = new Project[10];
		units = new KnowledgeUnit[50];
	
	}
	
	public boolean RegisterProject(String name, String clientName, int projectType,int diaInicio, int mesInicio, int anInicio, int diaFinal, int mesFinal, int anFinal, Double budget, String mensaje) {

		ProjectType projectTypeN = ProjectType.POR_DEFINIR;

		Etapa etapa = Etapa.INICIO;

		Calendar fechaIni = new GregorianCalendar(diaInicio, mesInicio, anInicio);

		Calendar fechaFini = new GregorianCalendar(diaFinal, mesFinal, anFinal);


        if (projectType == 1){

            projectTypeN = ProjectType.DESARROLLO;

        }else if (projectType == 2){

            projectTypeN = ProjectType.MANTENIMIENTO;

        }else{

			projectTypeN = ProjectType.DESPLIEGUE;

		}

        Project newProject = new Project(name, clientName, projectTypeN, fechaIni, fechaFini, budget, mensaje,etapa);

        for(int i = 0; i < projects.length; i++){

            if(projects[i] == null){

                projects[i] = newProject;
                return true;
			}
        }

        return false;
		
	}


	// Date class also has their own before() and after() method
	public String searchProjectsAfterDate(int diaIniBusqueda, int mesIniBusqueda, int anIniBusqueda) throws ParseException {

		String msg = "";

		Calendar fechaComparacion = new GregorianCalendar(diaIniBusqueda, mesIniBusqueda, anIniBusqueda);
		
		for(int i = 0; i < projects.length; i++){
			if(projects[i] != null){

				int val = fechaComparacion.compareTo(projects[i].getInitialDate());

				if (val == -1){

					msg += "\n"+ (i+1) + ". " + projects[i].getProjectInfo();

				}

			}
		}	

		return msg;
	}
	
	// Date class also has their own before() and after() method
	public String searchProjectsBeforeDate(int diaIniBusqueda, int mesIniBusqueda, int anIniBusqueda) throws ParseException {

		String msg = "";

		Calendar fechaComparacion = new GregorianCalendar(diaIniBusqueda, mesIniBusqueda, anIniBusqueda);
		
		for(int i = 0; i < projects.length; i++){
			if(projects[i] != null){

				int val = fechaComparacion.compareTo(projects[i].getFinalDate());

				if (val == 1){

					msg += "\n"+ (i+1) + ". " + projects[i].getProjectInfo();

				}

			}
		}	

		return msg;

	}

	public String culminateProjectState(int id) {

		String msg = "";

		Date fechaActual = new Date();

		Etapa etapaProyecto = projects[id].getEtapa();

		if (etapaProyecto == Etapa.INICIO){

			msg += "Etapa Inicio finalizada - estado Inactiva. Etapa Analisis iniciada - estado Activo. Fecha de realización: " + fechaActual;

			projects[id].setEtapa(Etapa.ANALISIS);

		}else if (etapaProyecto == Etapa.ANALISIS){

			msg += "Etapa Analisis finalizada - estado Inactiva. Etapa Diseno iniciada - estado Activo. Fecha de realización: " + fechaActual;

			projects[id].setEtapa(Etapa.DISENO);

		}else if (etapaProyecto == Etapa.DISENO){

			msg += "Etapa Diseno finalizada - estado Inactiva. Etapa Ejecucion iniciada - estado Activo. Fecha de realización: " + fechaActual;

			projects[id].setEtapa(Etapa.EJECUCION);

		}else if (etapaProyecto == Etapa.EJECUCION){

			msg += "Etapa Ejecucion finalizada - estado Inactiva. Etapa Cierre iniciada - estado Activo. Fecha de realización: " + fechaActual;

			projects[id].setEtapa(Etapa.CIERRE);

		}else if (etapaProyecto == Etapa.CIERRE){

			msg += "Etapa Cierre finalizada - estado Inactiva. Etapa Seguimiento y Control iniciada - estado Activo. Fecha de realización: " + fechaActual;

			projects[id].setEtapa(Etapa.SEGUIMIENTO_CONTROL);

		}else if (etapaProyecto == Etapa.SEGUIMIENTO_CONTROL){

			msg += "Etapa Seguimiento y Control finalizada - estado Inactiva. Proyecto Finalizado. Fecha de realización: " + fechaActual;

			projects[id].setEtapa(Etapa.PROYECTO_TERMINADO);

		}


		return msg;

 

	}


	public String showProjects() throws ParseException {

		String msg = "";

        for(int i = 0; i < projects.length; i++){

            if(projects[i]!=null){
                msg += "\n"+ (i+1) + ". " + projects[i].getProjectInfo();
            }
        }

        return msg;
	}

	public boolean registerKnowledgeUnit(String id, String description, int type, String learnedLessons) {


        Type typeKU = Type.TECNICO;

        if (type == 1){

            typeKU = Type.TECNICO;

        }else{

            typeKU = Type.EXPERIENCIAS;
        }

        KnowledgeUnit newUnit = new KnowledgeUnit(id, description, typeKU, learnedLessons);

        for(int i = 0; i < units.length; i++){

            if(units[i] == null){

                units[i] = newUnit;
                return true;
			}
        }

        return false;
	}


	public String approveKnowledgeUnit(int id, int cambio) {

		String msg = "";

		Date fechaActual = new Date();

        if (cambio == 1){

            units[id].setStatus(Status.APROBADO);

        }else{

            units[id].setStatus(Status.NO_APROBADO);

        }

		msg += "Fecha de aprobación" + fechaActual;

		return msg;

	}

	public void publishKnowledgeUnit(int id, String url) {

    	units[id].setPublicacion(Publicacion.PUBLICADA);
		units[id].setUrl(url);

	}

	public String searchKnowledgeUnits(){

        String msg = "";

        for(int i = 0; i < units.length; i++){

            if(units[i]!=null){
                msg += "\n"+ (i+1) + ". " + units[i].getId();
            }
        }

        return msg;

        
    }

	public String getAllKnowledgeUnits() {

		String msg = "";

        for(int i = 0; i < units.length; i++){

            if(units[i]!=null){
                msg += "\n" + units[i].toString();
            }
        }

        return msg;
	}
}
