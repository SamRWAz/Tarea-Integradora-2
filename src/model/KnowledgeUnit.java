package model;

public class KnowledgeUnit {

	private String id;
	private String description;
	private Type type;
	private String learnedLessons;
	private Status status;
    private Publicacion publicacion;
    private String url;

	public KnowledgeUnit(String id, String description, Type type, String learnedLessons) {

		this.id = id;
		this.description = description;
		this.type = type;
		this.learnedLessons = learnedLessons;
		this.status = Status.POR_DEFINIR;
        this.publicacion = Publicacion.SIN_PUBLICAR;
        this.url = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

    public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

	public String toString() {

		String msg = "";

		msg = "\nId: " + id + "\nDescripcion: " + description + "\nTipo: " + type + "\nAprendizaje o lección aprendida: " + learnedLessons + "\nEstado: " + status + "\nEstado de Publicacion: " + publicacion + "\nURL de Publicacion: " + url;

		return msg; 
	}
    
}