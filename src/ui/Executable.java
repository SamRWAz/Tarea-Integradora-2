package ui;

import java.text.ParseException;
import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();

	}

	public static void main(String[] args) throws ParseException {

		Executable exe = new Executable();
		exe.menu();

	}


	public void menu() throws ParseException {
		System.out.println("Bienvenido a GreenSQA App");

        boolean cond = false;

		while(!cond){
            System.out.println("\n");
            System.out.println("1. Registrar proyecto");
            System.out.println("2. Culminar etapa de proyecto");
            System.out.println("3. Consultar proyectos que inician despues de una fecha");
            System.out.println("4. Consultar proyectos que finalizan antes de una fecha");
            System.out.println("5. Registrar capsula de conocimiento");
            System.out.println("6. Aprobar capsulas de conococimientos");
            System.out.println("7. Consultar la informacion de las capsulas");
            System.out.println("8. Publicar cápsulas de conocimientos");
            System.out.println("9. Salir");
            int opcion = reader.nextInt();

            switch(opcion){

                case 1:
                    RegisterProject();
                    break;
                case 2:
                    culminateProjectState();
                    break;
                case 3:
                    searchProjectsAfterDate();
                    break;
                case 4:
                    searchProjectsBeforeDate();
                    break;
                case 5:
                    registerKnowledgeUnit();
                    break;
                case 6:
                    approveKnowledgeUnit();
                    break;
                case 7:
                    showAllKnowledgeUnits();
                    break;    
                case 8:
                    publishKnowledgeUnit();
                    break;
                case 9:
                    cond = true;
                    break;
            }

        }
	}


	public void RegisterProject() {
		System.out.println("Digite a continuacion la informacion de la capsula");

        //Limpieza de buffer
        reader.nextLine();

        System.out.println("Digite el nombre del proyecto");
        String name = reader.nextLine();

        System.out.println("Digite el nombre del cliente");
        String clientName = reader.nextLine();

		System.out.println("Digite el tipo de proyecto que desea registrar. \n1) Desarrollo \n2) Mantenimiento \n3) Despliegue");
        int projectType = reader.nextInt();

		System.out.println("Digite el dia de la fecha de inicio del proyecto");
        int diaInicio = reader.nextInt();

		System.out.println("Digite el mes de la fecha de inicio del proyecto");
        int mesInicio = reader.nextInt();

		System.out.println("Digite el año de la fecha de inicio del proyecto");
        int anInicio = reader.nextInt();

		System.out.println("Digite el dia de la fecha de finalizacion del proyecto");
        int diaFinal = reader.nextInt();

		System.out.println("Digite el mes de la fecha de finalizacion del proyecto");
        int mesFinal = reader.nextInt();

        System.out.println("Digite el año de la fecha de finalizacion del proyecto");
        int anFinal = reader.nextInt();

        System.out.println("Digite el presupuesto del proyecto");
        Double budget = reader.nextDouble();

        System.out.println("Ingrese la cantidad de gerentes encargados del proyecto");
        int canGerentes = reader.nextInt();

         //Limpieza de buffer
        reader.nextLine();

        String mensaje = "";

        for (int i = 0; i < canGerentes; i++){

            
            System.out.println("Digite el nombre del gerente numero " + (i+1));
            String nombreG = reader.nextLine();
            
            System.out.println("Digite el numero telefonico del gerente numero " + (i+1));
            String telefono = reader.nextLine();
            
            mensaje += "\n"+ (i+1) + ". " + nombreG + " - " + telefono;

        }

        if(controller.RegisterProject(name, clientName, projectType, diaInicio, mesInicio, anInicio, diaFinal, mesFinal, anFinal, budget, mensaje)){

            System.out.println("Proyecto registrado exitosamente");

        }else{

            System.out.println("Memoria llena, no se pudo registrar el proyecto");
        }
	}

    public void culminateProjectState() throws ParseException {
		
        String consulta = controller.showProjects();

        if(consulta.equals("")){

            System.out.println("No hay proyectos registrados");

        }else {

            System.out.println("Esta son los proyectos registrados en el sistema");
            System.out.println(consulta);

            System.out.println("Digite el numero del proyecto que desea culminar");
            int opcion = reader.nextInt();

            System.out.println(controller.culminateProjectState(opcion-1));
        }

        


	}

	
	public void searchProjectsAfterDate() throws ParseException {

		System.out.println("Por favor ingrese una fecha, le mostraremos los proyectos que inician despues de esta fecha");
		System.out.println("Digite el dia");
		int diaIniBusqueda = reader.nextInt();
		System.out.println("Digite el mes");
		int mesIniBusqueda = reader.nextInt();
		System.out.println("Digite el año");
		int anIniBusqueda = reader.nextInt();

		System.out.println(controller.searchProjectsAfterDate(diaIniBusqueda, mesIniBusqueda, anIniBusqueda)); 

        

	}
	
	
	public void searchProjectsBeforeDate() throws ParseException {

        System.out.println("Por favor ingrese una fecha, le mostraremos los proyectos que finalizan antes de esta fecha");
		System.out.println("Digite el dia");
		int diaIniBusqueda = reader.nextInt();
		System.out.println("Digite el mes");
		int mesIniBusqueda = reader.nextInt();
		System.out.println("Digite el año");
		int anIniBusqueda = reader.nextInt();

		System.out.println(controller.searchProjectsBeforeDate(diaIniBusqueda, mesIniBusqueda, anIniBusqueda)); 

	}

    private void approveKnowledgeUnit() {

		String consulta = controller.searchKnowledgeUnits();

        if(consulta.equals("")){

            System.out.println("No hay capsulas registrados");
        }else{

            System.out.println("Estas son las capsulas de conocimiento registradas");
            System.out.println(consulta);

            System.out.println("Digite el numero de la capsula, que desea aprobar o desaprobar");
            int opcion = reader.nextInt();

            System.out.println("Digite segun la opcion deseada \n1) Aprobar \n2) Desaprobar");
            int cambio = reader.nextInt();

            System.out.println(controller.approveKnowledgeUnit(opcion-1, cambio));

        }

	}

    private void publishKnowledgeUnit() {

		String consulta = controller.searchKnowledgeUnits();

        if(consulta.equals("")){

            System.out.println("No hay capsulas registrados");
        }else{

            System.out.println("Estas son las capsulas de conocimiento registradas");
            System.out.println(consulta);

            System.out.println("Digite el numero de la capsula, que desea publicar");
            int opcion = reader.nextInt();

             //Limpieza de buffer
            reader.nextLine();

            System.out.println("Ingrese el URL de publicacion de la capsula");
            String url = reader.nextLine();

            controller.publishKnowledgeUnit(opcion-1, url);

        }

	}


	public void registerKnowledgeUnit() {
		System.out.println("Digite a continuacion la informacion de la capsula");

        //Limpieza de buffer
        reader.nextLine();

        System.out.println("Digite el identificador unico de la cápsula. Ej.: A001");
        String id = reader.nextLine();

        System.out.println("Digite una descripcion corta de la situacion que desea registrar. Ej.: Aprendizajes en gestion de informacion");
        String description = reader.nextLine();

        System.out.println("Digite el tipo de capsula que desea registrar. \n1) Tecnico \n2) Experiencias");
        int type = reader.nextInt();

        //Limpieza de buffer
        reader.nextLine();

        System.out.println("Digite el aprendizaje o leccion aprendida con dicha situacion");
        String learnedLessons = reader.nextLine();
        
        if(controller.registerKnowledgeUnit(id, description, type, learnedLessons)){

            System.out.println("Capsula registrada exitosamente");

        }else{

            System.out.println("Memoria llena, no se pudo registrar la capsula");
        }
	}


	public void showAllKnowledgeUnits() {
		System.out.println("Esta es la informacion registrada en el sistema");

        String consulta = controller.getAllKnowledgeUnits();

        if(consulta.equals("")){

            System.out.println("No hay entrenamientos registrados");
        }else {
            
            System.out.println(consulta);
        }
	}
}