// Classe per determinar quina es la posicio actual del jugador
public class cJugador {
	
	private cZona zonaActual;
	
	// Metodos para determinar la zona del Jugador
	public void setZona(cZona zona) {
		this.zonaActual = zona;
	}
	
	public cZona getZona () {
		return zonaActual;
	}

}