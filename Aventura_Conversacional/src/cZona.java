import java.util.ArrayList;

// Classe per gestionar les zones del mapa 
public class cZona {

	private String nombre;
	private String descripcion;
	private boolean luz;
	private ArrayList<cItems> objetos_zona = new ArrayList<cItems>();
	private cZona oeste;
	private cZona este;
	private cZona norte;
	private cZona sur;
	private cZona arriba;
	private cZona abajo;
	
	
	// Metodo para asignar la luz a las habitaciones
	public  void setLuz(boolean luz) {
		this.luz = luz;
	}
	
	public boolean getLuz() {
		return luz;
	}
	
	
	//Metodo para retornar el arrayList de cada zona
	public ArrayList<cItems> getObjetos() {
		return objetos_zona;
	}
	
	
	// Metodo para imprimir los objetos de la zona
	public void imprimir_objetos() {
		 for (int a = 0; a < getObjetos().size(); a++ ) {
				System.out.print(" " + getObjetos().get(a).getNom());
			}
		 System.out.println("");
	}
	
	public void vaciar_array() {
		objetos_zona.clear();
	}
	
	//Metodos para coger o dejar un item en la zona
	public void afegir_item(cItems objecte) {
		objetos_zona.add(objecte);
	}
	
	public void eliminar_item(cItems objecte) {
		objetos_zona.remove(objecte);
	}

	// Metodos para asignar el nombre de una zona
	public void setNom(String nom) {
		this.nombre = nom;
	}
	
	public String getNom() {
		return nombre;
	}

	// Metodos para asignar la descripcion de cada zona
	public void setDescripcio(String descripcio) {
		this.descripcion = descripcio;
		}
	
	public String getDescripcio() {
		return descripcion;
	}
	
	// Metodos para definir la distribucion de las zonas
	public void setIzquierda(cZona zona) {
		this.oeste = zona;	
	}
	
	public cZona getIzquierda() {
		return oeste;
	}
	
	public void setDerecha(cZona zona) {
		this.este = zona;	
	}
	
	public cZona getDreta() {
		return este;
	}

	public void setNord(cZona zona) {
		this.norte = zona;	
	}
	
	public cZona getNord() {
		return norte;
	}
	
	public void setSud(cZona zona) {
		this.sur = zona;	
	}
	
	public cZona getSud() {
		return sur;
	}
	
	public void setAmunt(cZona zona) {
		this.arriba = zona;	
	}
	
	public cZona getAmunt() {
		return arriba;
	}
	
	public void setAbaix(cZona zona){
		this.abajo = zona;	
	}
	
	public cZona getAbaix() {
		return abajo;
	}
	
	// Metodos para llenar la zona con la descripcion y el nombre
	public cZona omplirZona(cZona zona, String nom, String descripcio ) {
		
		zona.setDescripcio(descripcio);
		zona.setNom(nom);
		
		return zona;
	}
	
	// Metodos para comprovar si hay zonas a su alrededor
	public boolean tincEsquerra() {
		boolean comprobar;
		
		if (this.oeste != null) {
			comprobar = true;
			}
		
		else{
			comprobar = false;
		}
		
		return comprobar;
	}
	
	public boolean tincDreta() {
		boolean comprobar;
		if (this.este != null) {
			comprobar = true;
			}
		
		else{
			comprobar = false;
		}
		
		return comprobar;
	}
	
	public boolean tincNord() {
		boolean comprobar;
		
		if (this.norte != null) {
			comprobar = true;
			}
		
		else{
			comprobar = false;
		}
		
		return comprobar;
	}
	
	public boolean tincSud() {
		boolean comprobar;
		
		if (this.sur != null) {
			comprobar = true;
			}
		
		else{
			comprobar = false;
		}
		
		return comprobar;
	}
	
	public boolean tincAmunt() {
		boolean comprobar;
		
		if (this.arriba != null) {
			comprobar = true;
			}
		
		else{
			comprobar = false;
		}
	
		return comprobar;
	}

	public boolean tincAbaix() {
		boolean comprobar;
		
		if (this.abajo != null) {
			comprobar = true;
			}
		
		else {
			comprobar = false;
		}
		return comprobar;
		
	}

}



