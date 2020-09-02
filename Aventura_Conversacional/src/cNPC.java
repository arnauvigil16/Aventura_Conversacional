// Classe per controlar els NPC
public class cNPC {
	
	private cZona posicion;
	private boolean vivo = true;
	
	//Metodos para determinar la zona del NPC
	public void setZonaNPC(cZona zona) {
		this.posicion = zona;
	}
	
	
	// Metodos para determinar si esta vivo el NPC
	public void setVivo(boolean viu) {
		this.vivo = viu;
	}
	
	public boolean getVivo() {
		return vivo;
	}
}
