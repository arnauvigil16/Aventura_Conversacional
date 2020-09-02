public class cItems {

	
	private String nombre;
	private String descripcion;
	private boolean altura;
	private boolean oculto;

	// Metodes para ver si un objeto esta visible o no
	public void setOculta(boolean oculta) {
		this.oculto = oculta;
	}
	
	public boolean getOculta() {
		return oculto;
	}
	
	// Metodes para determinar la altura de un objeto
	public void setAltura(boolean altura) {
		this.altura = altura;
	}
	
	public boolean getAltura() {
		return altura;
	}
	
	// Metodos para las descripciones de los objetos
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	// Metodos para los nombres de los objetos
	public String getNom() {
		return nombre;
	}
	
	public void setNom(String nom) {
		this.nombre = nom;
	}

	
	
}
