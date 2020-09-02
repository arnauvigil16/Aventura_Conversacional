import java.util.*;

public class Aventura_Conversacional {
	
	// Instanciar el jugador, el array de las zonas y los objetos
	private static cJugador jugador = new cJugador();
	private static cZona[] mapa_zonas = new cZona[10];
	private static ArrayList<cItems> objetos_jugador = new ArrayList<cItems>();
	
	//Instanciar todos los objetos necesarios
	static cItems cuchillo = new cItems();
	static cItems antorcha = new cItems();
	static cItems llave = new cItems();
	static cItems escalera = new cItems();
	static cItems dinero = new cItems();
	static cItems nota = new cItems();
	
	//Instanciar los NPC
	static cNPC JordiJor = new cNPC();
	static cNPC Cocinera = new cNPC();
	
	//Instanciar Zonas
	static cZona zona0 = new cZona();
	static cZona zona1 = new cZona();
	static cZona zona2 = new cZona();
	static cZona zona3 = new cZona();
	static cZona zona4 = new cZona();
	static cZona zona5 = new cZona();
	static cZona zona6 = new cZona();
	static cZona zona7 = new cZona();
	static cZona zona8 = new cZona();
	static cZona zona9 = new cZona();
	
	// Booleans necesarios y teclado
	static boolean puerta = false;
	static Scanner teclat = new Scanner(System.in);
	static boolean final_joc = false;
	
	public static void main(String[] args) {
		
		System.out.println();
		preparacionJuego();	
		reglas_juego();
		introduccion_juego();
		
		System.out.println("");
		
		while(final_joc != true) {	
			
	
			Mostrar_info();		
			
			// Demanar indicacions
			String movimient = teclat.nextLine().toLowerCase();
			
			System.out.println(" "); 	
			
			acciones(movimient);
		
		}

		teclat.close();
	}
	
	// Preguntar si el jugador quiere volver a jugar
	public static void fin_juego() {
		System.out.println("Quieres volver a jugar? ");
		String opcion = teclat.next().toLowerCase();
		
		while (!(opcion.equals("si")) && !(opcion.equals("no"))) {
			System.out.println("Orden Incorrecta");
			opcion = teclat.next().toLowerCase();
		}
	
		 if (opcion.equals("no")) {	
			final_joc = true;
			saltar();
			System.out.println("		______  _              _        _     ___                            \r\n" + 
					"		|  ___|(_)            | |      | |   |_  |                           \r\n" + 
					"		| |_    _  _ __     __| |  ___ | |     | | _   _   ___   __ _   ___  \r\n" + 
					"		|  _|  | || '_ \\   / _` | / _ \\| |     | || | | | / _ \\ / _` | / _ \\ \r\n" + 
					"		| |    | || | | | | (_| ||  __/| | /\\__/ /| |_| ||  __/| (_| || (_) |\r\n" + 
					"		\\_|    |_||_| |_|  \\__,_| \\___||_| \\____/  \\__,_| \\___| \\__, | \\___/ \r\n" + 
					"  		                                                         __/ |       \r\n" + 
				"        		                                                |___/  ");		
		}
		 
		 else if (opcion.equals("si")) {
			 saltar();
			 preparacionJuego();	
			 introduccion_juego();
				
				System.out.println("");
				
				while(final_joc != true) {	
					
			
					Mostrar_info();		
					
	
					// Demanar indicacions
					String movimient = teclat.nextLine().toLowerCase();
					
					System.out.println(" "); 	
					
					acciones(movimient);
				
				}
		}
	}
	
	public static void saltar() {
		for (int a = 0; a < 100; a++) {
			System.out.println("");
		}
	}
	
	// Conjunto de reglas
	public static void reglas_juego() {
		System.out.println("Bienvenido al 'tutorial' de este juego ");
		System.out.println("Esta aventura trata sobre investigar las zonas para recoger objetos y usarlos en otras zonas");
		System.out.println("");
		System.out.println("Hay varios comandos que se pueden usar:");
		System.out.println("- mover (direccion basada en los 4 puntos cardinales)");
		System.out.println("- subir/ bajar");
		System.out.println("- coger/dejar");
		System.out.println("- encender/apagar");
		System.out.println("- usar");
		System.out.println("- mostrar");
		System.out.println("- hablar");
		System.out.println("Entre otros que tendras que ir descubriendo");
		System.out.println("");
		System.out.println("Cuando se este explicando historia o un personaje este hablando, tendras que presionar el intro para avanzar");
		System.out.println("Pruebalo:");
		System.out.print(teclat.nextLine());
		System.out.println("Finalmente, se podran dar algunas preguntas durante el juego ");
		System.out.println("Simplemente se tendra que responder con si o no");
		System.out.println("");
		System.out.print("Estos son vuestros objetos al empezar la aventura: ");
		imprimir_objetos(objetos_jugador);
		System.out.println("");
		System.out.println("Eso es todo por ahora, cuando quieras empezar el juego, presiona la tecla intro");
		System.out.print(teclat.nextLine());
		saltar();
	}
	
	// Explicacion de la historia
	public static String introduccion_juego() {
		System.out.println("  \r\n" + 
				"                   @@@@@@@@  @@@@@@@@  @@@@@@@   @@@@@@@@  @@@@@@@@     @@@ @@@  \r\n" + 
				"                   @@!  @@@  @@!       !@@       @@!       @@!  @@@     @@! !@@  \r\n" + 
				"                   !@!  @!@  !@!       !@!       !@!       !@!  @!@     !@! @!!  \r\n" + 
				"                   @!@  !@!  @!!!:!    !!@@!!    @!!!:!    @!@  !@!      !@!@!   \r\n" + 
				"                   !@!  !!!  !!!!!:     !!@!!!   !!!!!:    !@!  !!!       @!!!   \r\n" + 
				"                   !!:  !!!  !!:            !:!  !!:       !!:  !!!       !!:    \r\n" + 
				"                   :!:  !:!  :!:           !:!   :!:       :!:  !:!       :!:    \r\n" + 
				"                    :::: ::   :: ::::  :::: ::    :: ::::  ::::: ::        ::    \r\n" + 
				"                   :: :  :   : :: ::   :: : :    : :: ::    : :  :         :     \r\n" + 
				"                                                                                 \r\n" + 
				"                                                                                          \r\n" + 
				"         @@@  @@@  @@@@@@@@  @@@  @@@   @@@@@@@@   @@@@@@   @@@  @@@  @@@@@@@@   @@@@@@   \r\n" + 
				"         @@@  @@@  @@@@@@@@  @@@@ @@@  @@@@@@@@@  @@@@@@@@  @@@@ @@@  @@@@@@@@  @@@@@@@@  \r\n" + 
				"         @@!  @@@  @@!       @@!@!@@@  !@@        @@!  @@@  @@!@!@@@       @@!  @@!  @@@  \r\n" + 
				"         !@!  @!@  !@!       !@!!@!@!  !@!        !@!  @!@  !@!!@!@!      !@!   !@!  @!@  \r\n" + 
				"         @!@  !@!  @!!!:!    @!@ !!@!  !@! @!@!@  @!@!@!@!  @!@ !!@!     @!!    @!@!@!@!  \r\n" + 
				"         !@!  !!!  !!!!!:    !@!  !!!  !!! !!@!!  !!!@!!!!  !@!  !!!    !!!     !!!@!!!!  \r\n" + 
				"         :!:  !!:  !!:       !!:  !!!  :!!   !!:  !!:  !!!  !!:  !!!   !!:      !!:  !!!  \r\n" + 
				"          ::!!:!   :!:       :!:  !:!  :!:   !::  :!:  !:!  :!:  !:!  :!:       :!:  !:!  \r\n" + 
				"           ::::     :: ::::   ::   ::   ::: ::::  ::   :::   ::   ::   :: ::::  ::   :::  \r\n" + 
				"            :      : :: ::   ::    :    :: :: :    :   : :  ::    :   : :: : :   :   : :  ");
		
		
		System.out.println("");
		System.out.println("Hacia ya un par de meses que vuestro emperador, RafaFer, habia sido asesinado a manos del traidor de JordiJor.");
		System.out.print(teclat.nextLine());
		System.out.println("Lamentablemente, no pudisteis hacer nada para evitar aquel crimen y salvarle...  El remordimiento y el odio hacia el detestable JordiJor es lo que os mantiene con vida. ");
		System.out.print(teclat.nextLine());
		System.out.println("Aun recordais cuando os dejaron tirado en medio de aquel oscuro y lugubre bosque a vuestra suerte. Pero, por alguna razon del destino, lograsteis encontrar un pueblo cercano.");
		System.out.print(teclat.nextLine());
		System.out.println("Aun asi, vuestras fuerzas solo lograron llevartos hasta la entrada, donde caisteis desmayado." );
		System.out.print(teclat.nextLine());
		System.out.println("Cuando despertasteis, os encontrabais en una cama algo polvorienta.");
		System.out.print(teclat.nextLine());
		System.out.println("Al parecer, una familia, que vivia en aquel pueblo, os habia encontrado y habia decidido acogeros bajo su humilde techo.");
		System.out.print(teclat.nextLine());
		System.out.println("No sabiais cuanto tiempo habia transcurrido desde que os habiais desmayado hasta ahora. Confuso, implorasteis respuestas.");
		System.out.print(teclat.nextLine());
		System.out.println("La familia que os habia acogido, habia reconocido la armadura que llevabais puesta, ya que pertenecia a la antigua guardia real de palacio.");
		System.out.print(teclat.nextLine());
		System.out.println("Por lo cual no dudaron en informaros sobre los cambios que se habian impuesto en el imperio.");
		System.out.print(teclat.nextLine());
		System.out.println("Al parecer, esos pocos meses que habian transcurrido, habian sido suficientes para que JordiJor instaurase un gobierno caracterizado por la tirania:");
		System.out.print(teclat.nextLine());
		System.out.println("Habia subido los impuestos, al igual que los costes de comercio en los pueblos del imperio.");
		System.out.print(teclat.nextLine());
		System.out.println("Para asi poder elevar el nivel de vida de palacio, dejando asi que la poblacion del imperio cayera en la miseria.");
		System.out.print(teclat.nextLine());
		System.out.println("Toda aquella informacion era demasiada para vos. Era algo insolito, que en tan solo ese tiempo, el imperio hubiera cambiado de manera tan drastica.");
		System.out.print(teclat.nextLine());
		System.out.println("Durante el tiempo que duro vuestra recuperacion, es decir, en lo que esperabais que vuestras heridas sanacen, intentabais asimilar todo lo que estaba pasando");
		System.out.print(teclat.nextLine());
		System.out.println("Y, tras un par de dias, os despedisteis de la familia que tan amablemente os habia acogido, y partisteis de aquel pueblo en direccion al bosque.");
		System.out.print(teclat.nextLine());
		System.out.println("Ahi os refugiasteis, con la idea de prepararos para algun dia poder hacer de aquel imperio lo que en su dia fue, devolviendole su esplendor.");
		System.out.print(teclat.nextLine());
		System.out.println("Han pasado varios meses desde todo aquello. Dia y noche os has estado preparando para este momento. Vuestro cuerpo esta preparado para el combate, pero y vuestra mente?...");
		System.out.print(teclat.nextLine());
		System.out.println("Os acercais sigilosamente a una entrada oculta, que lleva a alguna de las habitaciones del castillo.");
		System.out.print(teclat.nextLine());
		System.out.println("Estais listo para la aventura? Si o no? Os afrentareis a vuestro destino?");
		String opcion = teclat.next().toLowerCase();
		
			while (!(opcion.equals("si")) && !(opcion.equals("no"))) {
				System.out.println("Orden Incorrecta");
				opcion = teclat.next().toLowerCase();
			}
		
			if (opcion.equals("si")){
				System.out.println("");
				System.out.println("Adelante pues! Entrais decidido al castillo!");
				System.out.println("");
			}
			
			else if (opcion.equals("no")) {	
				System.out.print(teclat.nextLine());
				System.out.println("");
				System.out.println("A pesar de estar fisicamente preparado, vuestra mentalidad no es tan fuerte como los son vuestros musculos... ");
				System.out.print(teclat.nextLine());
				System.out.println("La muerte de vuestro emperador aun os persigue entre vuestras pesadillas y fantaseais despierto con ello");
				System.out.print(teclat.nextLine());
				System.out.println("Puede que dentro de unos meses esteis preparado, pero por el momento, solamente os retirais de nuevo hacia el bosque...");
				System.out.print(teclat.nextLine());
				
				fin_juego();
				
			}
		return opcion;
		
			}
			
	// Mostrar toda la informacion por pantalla ya sea del jugador o de la zona
	public static void Mostrar_info() {
		System.out.println("Os encontrais en " + jugador.getZona().getNom());
		System.out.println(" ");
		
		if (jugador.getZona().getLuz() == false) {
			System.out.println("Esta muy oscuro para que podais ver algo");
			System.out.println("");
		}
		
		else if (llave.getAltura() == true && jugador.getZona() == zona0) {
			System.out.println(jugador.getZona().getDescripcio());
			System.out.println("");
			System.out.println("Hay algo encima de las estanterias pero no alcanzais a ver que es");
			System.out.println("");
			System.out.println("Necesitariais algun objeto para poder subir");
			System.out.println("");
		}
		
		else if (escalera.getOculta() == true && jugador.getZona() == zona6) {
			System.out.println(jugador.getZona().getDescripcio());
			System.out.println("");
			System.out.println("Os parece que hay algo entre un par de caballos pero no le dais mucha importancia");
			System.out.println();
			System.out.println("");
		}
		
		else {
			if (jugador.getZona().getObjetos().isEmpty()) {
				System.out.println(jugador.getZona().getDescripcio());
				System.out.println("");
				System.out.println("No hay objetos en esta zona");
				System.out.println("");
			}
			
			else {
				System.out.println(jugador.getZona().getDescripcio());
				System.out.println("");
				System.out.print("Objetos de la zona:");
				jugador.getZona().imprimir_objetos();
			}
			
		
		}
		System.out.println(" ");
	}
	
	// Metodo para controlar que acciones hace el jugador
	public static void acciones(String movimient) {
		
		
		String[] palabras = movimient.split("\\s+");
		
		if (palabras.length == 2) {
		
					switch (palabras[0]) {
						case "mover": 
							moure_Jugador(palabras[0], palabras[1]);
							break;
						case "dejar":
							dejar_objeto(palabras[1]);
							break;
						case "coger":
							coger_objeto(palabras[1]);
							break;
						case "usar":
							usar_objeto(palabras[1]);
							break;
						case "mostrar":
							if (palabras[1].equals("inventario")) {
								System.out.print("Estos son los objetos que tienes en el inventario:");
								imprimir_objetos(objetos_jugador);
								 System.out.println("");
								 break;
							}
				
						case "leer":
							if (palabras[1].equals("nota")) {	
								nota();
								break;
							}
						case "encender":
							
							encender_antorcha(palabras[1]);
							break;
							
						case "apagar":
							
							apagar_antorcha(palabras[1]);
							break;
							
						case "subir": 
								escaleras(palabras[0], palabras[1]);
								break;
							
						case "bajar":	
							
							escaleras(palabras[0], palabras[1]);
							break;
							
						case "hablar":
							
							hablar(palabras[1]);
							break;
							
					}
		}
		
		else if (palabras.length != 2) {
			System.out.println("Orden Incorrecta");
			System.out.println("");
		}
	}
	
	//Interactuar con los NPC
	public static void hablar(String objeto) {
		
		if (objeto.equals("cocinera")) {
			if (jugador.getZona() == zona1 && Cocinera.getVivo() == true  && jugador.getZona().getLuz() == true) {
				System.out.println("Cocinera: ");
				System.out.println("");
				System.out.println("Hola jovenzuelo, que os trae por aqui?");
				System.out.print(teclat.nextLine());
				System.out.print(teclat.nextLine());
				System.out.println("Vuestro rostro me es un poco familiar...");
				System.out.print(teclat.nextLine());
				System.out.println("Espera vos sois CarloBon no?!");
				String opcion = teclat.next().toLowerCase();
				
				while (!(opcion.equals("si")) && !(opcion.equals("no"))) {
					System.out.println("Orden Incorrecta");
					opcion = teclat.next().toLowerCase();
				}
			
				if (opcion.equals("si")){
					
					System.out.println("Que alegria poder volver a verte! Pense que habias muerto!");
					System.out.print(teclat.nextLine());
					System.out.print(teclat.nextLine());
					System.out.println("Os intentaron asesinar!?!?! Madre de dios!!");
					System.out.print(teclat.nextLine());
					System.out.println("Oh... quereis venganza... ya veo ya veo...");
					System.out.print(teclat.nextLine());
					System.out.println("La verdad que desde que desaparecio RafaFer, que en paz descanse, las cosas en el castillo han cambiado mucho");
					System.out.print(teclat.nextLine());
					System.out.println("Necesitais ayuda?... Os puedo decir donde encontrar la escalera a cambio de un par de monedas...");
					System.out.print(teclat.nextLine());
					System.out.println("Entiendeme chico... necesito algo mas para poder dar de comer a mi familia...");
					System.out.print(teclat.nextLine());
					System.out.println("");
				}
				
				else if (opcion.equals("no")) {	
					System.out.println("Oh... perdonadme...");
					System.out.print(teclat.nextLine());
					System.out.print(teclat.nextLine());
					System.out.println("Necesitais ayuda con algo?");
					System.out.print(teclat.nextLine());
					System.out.println("Os puedo dar cierta informacion a cambio de unas pocas monedas...");
					System.out.print(teclat.nextLine());
				}	
			}
			
			else if (Cocinera.getVivo() == false) {
				System.out.println("No puedes hablar con alguien que esta muerto");
				System.out.println("");
			}
			
			else if (jugador.getZona().getLuz() == false) {
				System.out.println("Esta muy oscuro para que podais hacer algo");
				System.out.println(" ");
			}
		}
		
		else if (objeto.equals("jordijor")) { 
			if (jugador.getZona() == zona9 && JordiJor.getVivo() == true  && jugador.getZona().getLuz() == true) {
				System.out.println("Creo que no es el mejor momento para hablar con JordiJor...");
				System.out.println();
			}
			
			else if (jugador.getZona().getLuz() == false) {
				System.out.println("Esta muy oscuro para que podais hacer algo");
				System.out.println(" ");
			}
		}
		
	}
	
	// Controlar si puede subir las escaleras o no
	public static void escaleras(String accion, String objeto){
		 if (accion.equals("subir") && objeto.equals("escaleras")) {		
			
			 if (puerta == true) {
				mapa_zonas[4].setAmunt(zona9);
				mapa_zonas[9].setAbaix(zona4);
				
				jugador.setZona(jugador.getZona().getAmunt());	
			}
			else if (jugador.getZona() == zona4 && puerta == false && jugador.getZona().getLuz() == true) {
				
				System.out.println("Hay una puerta pero esta cerrada con llave");
				System.out.println("");
			}	
			
			else if (jugador.getZona() == zona4 && puerta == false && jugador.getZona().getLuz() == false) {
				
				System.out.println("Esta muy oscuro para que podais ver algo");
				System.out.println("");
				
			}
			
			else {
				System.out.println("No hay escaleras para poder subir");
				System.out.println(" ");
			}
		}
		
		else if (accion.equals("bajar") && objeto.equals("escaleras")) {
			if (jugador.getZona().tincAbaix()) {
				 jugador.setZona(jugador.getZona().getAbaix());	
				}
			else {
				
				System.out.println("No hay escaleras para poder bajar");
				System.out.println(" ");
			}
		}
	}
	
	// Metodos para controlar si se enciende o se apaga la antorcha
	public static void apagar_antorcha(String objeto) {
		
		boolean comprovacion = comprovar_items(objetos_jugador, "antorcha");
		
		if (objeto.equals("antorcha") && jugador.getZona().getLuz() == false && comprovacion == true) {
			
			jugador.getZona().setLuz(false);
			
		}
		else if (objeto.equals("antorcha") && jugador.getZona().getLuz() == true) {
			System.out.println("La zona ya se encuentra a oscuras");
			System.out.println("");
		}
		
		else if (comprovacion != true) {
			System.out.println("No posees este objeto");
			System.out.println("");
		}
	}
	
	public static void encender_antorcha(String objeto) {
		boolean comprovacion = comprovar_items(objetos_jugador, "antorcha");
		
		if (objeto.equals("antorcha") && jugador.getZona().getLuz() == false && comprovacion == true) {
			
			jugador.getZona().setLuz(true);
			
		}
		
		else if (objeto.equals("antorcha") && jugador.getZona().getLuz() == true) {
			System.out.println("La zona ya esta iluminada");
			System.out.println("");
		}
		
		else if (comprovacion != true) {
			System.out.println("No posees este objeto");
			System.out.println("");
		}
	}
	
	// Comportamiento del jugador segun la nota que ha leido
	public static void nota() {
		 boolean comprovacion = comprovar_items(objetos_jugador, "nota");
		 
		 if (comprovacion == true) {
			 System.out.println(nota.getDescripcion());
			 String opcion = teclat.next().toLowerCase();
				
				while (!(opcion.equals("si")) && !(opcion.equals("no"))) {
					System.out.println("Orden Incorrecta");
					opcion = teclat.next().toLowerCase();
				}
			
				if (opcion.equals("si")){
					System.out.println("");
					System.out.println("La rabia y ira se apoderan mas de vos despues de leer la nota y estais decidido a matar a JordiJor");
					System.out.println("");
					
				}
				
				else if (opcion.equals("no")) {	
					System.out.print(teclat.nextLine());
					System.out.println("");
					System.out.println("Os quedais mirando la nota un poco mas... Volviendo a leerla por segunda vez... ");
					System.out.print(teclat.nextLine());
					System.out.println("Vuestras ideas empiezan a ser mas claras... puede que la venganza no sea el mejor metodo...");
					System.out.print(teclat.nextLine());
					System.out.println("Despues de recapacitar durante unos minutos, decidis abandonar el castillo y volver al bosque donde os ocultabais");
					System.out.print(teclat.nextLine());
					System.out.println("Teneis la esperanza que dentro de un tiempo, las cosas empezaran a mejorar y el reino cambiara...");
					
					fin_juego();
					
				}
			 
			 
		 }
		 
		 else  {
			 System.out.println("No posees este objeto");
			 System.out.println("");
		 }
	}
	
	// Control de los items del jugador como de la zona	
	public static void control_items (String objeto, cItems objetos) {
		
		boolean comprovacio = comprovar_items(jugador.getZona().getObjetos(), objeto);
		
		
		 if (jugador.getZona().getLuz() == false) {
			System.out.println("Esta muy oscuro para que podais coger algo");
			System.out.println("");
		 }
			
		 else if (comprovacio == true) {
		
			
			 boolean comprovacion2 = comprovar_items(objetos_jugador, objeto);
			 
			 if (comprovacion2 == false) {
				 objetos_jugador.add(objetos);
				 jugador.getZona().getObjetos().remove(objetos);
			 }
			 
			 else {
				 System.out.println("Ya tienes este objeto en el inventario");
				 System.out.println("");
			 }			
		}

		else if (comprovacio != true){
			System.out.println("Este objeto no se encuentra en esta zona");
			System.out.println("");
			
		}	
	}
	
	// Coger un objeto
	public static void coger_objeto(String objeto) {	
		switch (objeto) {
			case "antorcha": 	
				control_items("antorcha", antorcha);	
				break;
					
			case "llave": 
				
				if (llave.getAltura() == true){
					System.out.println("No podeis alcanzar este objeto");
					System.out.println("");
				}
				
				else {
					control_items("llave", llave);
					}
							
				break;
				
			case "nota": 
				control_items("nota", nota);	
				break;
				
			case "escalera": 
				control_items("escalera", escalera);	
				break;
				
			case "cuchillo":
				control_items("cuchillo", cuchillo);	
				break;
		
			case "dinero": 
				control_items("dinero", dinero);	
				break;
				
			default:
				System.out.println("Orden Incorrecta");
				System.out.println("");
		}
	}
	
	// Controlar si ese item esta en la zona
	public static void control_items_dejar(String objeto_comprovar, cItems objetos) {
		
		if (jugador.getZona().getLuz() == false) {
			System.out.println("Esta muy oscuro para que podais dejar algo");
			System.out.println("");
		 }
		
		else if (jugador.getZona() == zona1 && Cocinera.getVivo() == true && jugador.getZona().getLuz() == true) {
			
			boolean bolsa_dinero = comprovar_items(objetos_jugador, "dinero");
			if (bolsa_dinero == true) {
					
				escalera.setOculta(false);
				System.out.println("");
				System.out.println("Cocinera:");
				System.out.println("");
				System.out.println("La escalera se encuentra en los establos");
				System.out.println("Id con cuidado...");
				System.out.println("");
			}
			
			else {
				System.out.println("No posees este objeto");
				System.out.println("");
			}
		}
		
		else if (jugador.getZona() == zona1 && Cocinera.getVivo() == true && jugador.getZona().getLuz() == false) {
			System.out.println("Esta muy oscuro para que podais ver algo");
			System.out.println("");
		}
		
		else {

		 boolean comprovacion = comprovar_items(jugador.getZona().getObjetos(), objeto_comprovar);
		 
		 if (comprovacion == false) {
			 
			 objetos_jugador.remove(objetos);
			 jugador.getZona().getObjetos().add(objetos);		 
		 }	 
		 else {
			 System.out.println("Este objeto ya se encuentra en la zona");
			 System.out.println();
		 }	
		}
	}
	
	// Dejar un objeto
	public static void dejar_objeto(String objeto) {		
		switch(objeto) {
				case "antorcha": 
					control_items_dejar("antorcha", antorcha);
					break;
				case "llave": 
					control_items_dejar("llave", llave);
					break;
				case "nota": 
					control_items_dejar("nota", nota);
					break;
				case "escalera": 
					control_items_dejar("escalera", escalera);
					break;
				case "cuchillo": 
					control_items_dejar("cuchillo", cuchillo);
					break;
				case "dinero": 
					control_items_dejar("dinero", dinero);
					break;	
				default: 
					System.out.println("Orden Incorrecta");
					System.out.println("");
	}
}
	
	// Imprime los objetos del arraylist que se le pasen por parametros
	public static void imprimir_objetos(ArrayList<cItems> objetos) {
		 for (int a = 0; a < objetos.size(); a++ ) {
				System.out.print(" " + objetos.get(a).getNom());
			}
		 System.out.println("");
	}
	
	// Prepara todo el juego antes de que empieze
	public static void preparacionJuego() {
		
		//Borrar los objetos del array para las partidas siguientes
		objetos_jugador.clear();
		
		
		
		
		//Creacion del mapa
		mapa_zonas = elaboracionMapa(mapa_zonas);
		
		// Poner el jugador en una zona aleatoria
		int habitacio_random = (int) (Math.random() *9);
		jugador.setZona(mapa_zonas[habitacio_random]);
		
		
		//Preparar todos los items
		cuchillo.setNom("cuchillo");
		antorcha.setNom("antorcha");
		llave.setNom("llave");
		
		//Si es true, es que el objeto esta elevado y no se puede alcanzar
		llave.setAltura(true);
		escalera.setNom("escalera");
		
		// Si es true, es que el objeto esta oculto, si no, esta visibile
		escalera.setOculta(true);
		dinero.setNom("dinero");
		nota.setNom("nota");
		nota.setDescripcion("  \r\n" + 
				"Es una nota algo arrugada, parece tener mucho tiempo, pero aun se puede leer  \r\n" + 
				"\r\n" + 
				"\r\n" +
				"___________________________________________________________________________________________\r\n" +
				"\r\n" + 
				"	Querido CarloBon  \r\n" + 
				"\r\n" + 
				"	Cuando leas esta carta, seguramente yo ya este muerto... pero no llores por mi. \r\n" + 
				"	Era consciente de que JordiJor queria el reino, pero preferi dartelo a ti \r\n" + 
				"	Porque se que eres un buen hombre, alguien leal a quien le podria entregar el reino.    \r\n" + 
				"\r\n" + 
				"	Seguramente las ansias de poder de mi hijo, le cegaran y intentara eliminar a ti o a mi    \r\n" + 
				"	En cualquier de los casos, porfavor, no tomes venganza contra el...      \r\n" + 
				"	Aun es un chico confuso que no sabe lo que hace y por encima de todo es mi hijo...        \r\n" + 
				"\r\n" + 
				"	Crees que podras hacerlo?  \r\n" + 
				"	Dejo el destino de mi hijo y del reino en tus manos \r\n" + 
				"	Se que haras lo correcto  \r\n" + 
				"\r\n" + 
				"	Atte RafaFer  \r\n" +
				"___________________________________________________________________________________________\r\n" + 
				"\r\n" +
				"Despues de leer la nota, algunas lagrimas corren por vuestras mejillas, pero os las secais rapidamente...\r\n" +
				"\r\n" +
				"Seguireis vuestro destino y matareis a JordiJor? ");
	
		
		//Poner propiedades NPC
		JordiJor.setZonaNPC(zona9);
		JordiJor.setVivo(true);
		
		Cocinera.setZonaNPC(zona1);
		Cocinera.setVivo(true);
		
		
		mapa_zonas[0].vaciar_array();
		mapa_zonas[2].vaciar_array();
		mapa_zonas[6].vaciar_array();
		mapa_zonas[1].vaciar_array();
		mapa_zonas[5].vaciar_array();
		
		//Poner items a cada zona
		mapa_zonas[0].afegir_item(llave);
		mapa_zonas[2].afegir_item(nota);
		mapa_zonas[6].afegir_item(escalera);
		mapa_zonas[1].afegir_item(cuchillo);
		mapa_zonas[5].afegir_item(dinero);
		
		//Poner al inventario los objetos del jugador
		objetos_jugador.add(antorcha);
		
	}
	
	//Utilitzar los objetos
	public static void usar_objeto(String objeto) {
		
		if (jugador.getZona().getLuz() == false) {
			System.out.println("Esta muy oscuro para que podais usar algo");
			System.out.println("");
		 }

		// Uso de la llave
		else if (objeto.equals("llave") && (jugador.getZona() == zona4)) {
			boolean llave = comprovar_items(objetos_jugador, "llave");
			
			if (llave == true) {
				puerta = true;
				System.out.println("Habeis abierto la puerta hacia la habitacion de JordiJor");
				System.out.println("");
			}
			
			else if (llave != true) {
				System.out.println("Aun no posees este objeto");
				System.out.println("");
			}
		}
		
		// Uso del cuchillo con JordiJor
		else if (objeto.equals("cuchillo") && (jugador.getZona() == zona9)) {
			
			boolean cuchillo = comprovar_items(objetos_jugador, "cuchillo");
			
			if (cuchillo == true) {
				
				System.out.println("Estais a punto de matar a JordiJor, tienes el suficiente coraje?");
				
				String matar = teclat.next().toLowerCase();

				while (!(matar.equals("si")) && !(matar.equals("no"))) { 
						matar = teclat.next().toLowerCase();
						System.out.println("Orden Incorrecta");
				}
				
				if (matar.equals("si")){
					System.out.println("");
					System.out.println("Os acercais muy lentamente hacia la cama, con todo el sigilo posible y el cuchillo en la mano");
					System.out.print(teclat.nextLine());
					System.out.println("JordiJor esta dormido, placidamente en la cama rodeado de las sirvientas mas guapas del palacio. ");
					System.out.print(teclat.nextLine());
					System.out.println("Lentamente vas despertando a las mujeres a su lado para que se vayan de la habitacion. Todas os reconocen asi que no os intentan atacar... ");
					System.out.print(teclat.nextLine());
					System.out.println("Agarrais un cojin para tapar la cara de JordiJor, mientras sentis como la rabia se apodera de vos y le clavais varias cuchilladas en el corazon");
					System.out.print(teclat.nextLine());
					System.out.println("Seguis acuchillandolo hasta cansaros y dejar vuestra ropa y las sabanas llenas de sangre");
					System.out.print(teclat.nextLine());
					System.out.println("Durante unos segundos os quedais mirando al cuerpo ya sin vida de JordiJor... lo habeis matado por fin... Habeis vengado a RafaFer...");
					System.out.println("");
					System.out.print(teclat.nextLine());
					System.out.println("Despues de eso, os disponeis a salir del castillo a toda prisa, intentando borrar todo rastro de que estubierais alli");
					System.out.print(teclat.nextLine());
					System.out.println("Pasan apenas unos dias para que se haga publico que el rey ha sido asesinado.");
					System.out.print(teclat.nextLine());
					System.out.println("La guardia real viene en vuestra busqueda para coronaros como nuevo rey, ya que era el deseo principal de RafaFer");
					System.out.print(teclat.nextLine());
					System.out.println("Enhorabuena! Sois el nuevo rey del reino... y nadie nunca sabra vuestro oscuro pasado...");
					
					
					fin_juego();
				}
				
				else if (matar.equals("no")) {	
					System.out.println("");
					System.out.println("Os quedais pensando en lo que vais a hacer y os girais para abandonar la habitacion, pero por mala suerte tropezais y caeis al suelo");
					System.out.print(teclat.nextLine());
					System.out.println("El ruido provocado alerta a JordiJor quien se levanta de golpe, confundido y rapidamente coje una daga que tiene en la mesilla.");
					System.out.print(teclat.nextLine());
					System.out.println("Mientras os recuperais de vuestra patosa caida, JordiJor ya se ha alzado de la cama y se esta acercando hacia vos");
					System.out.print(teclat.nextLine());
					System.out.println("JordiJor:");
					System.out.println("");
					System.out.println("CarloBon!? Deberias estar muerto! Malditos guardias inutiles...");
					System.out.println("");
					System.out.println("Veo que tendre que hacer las cosas por mi mismo!");
					System.out.print(teclat.nextLine());
					System.out.println("JordiJor se abalanza enfurecido hacia vos, mientras que intentais cubriros como podais, pero sus golpes son contundentes");
					System.out.print(teclat.nextLine());
					System.out.println("Sus golpes os hacen retroceder hasta llegar al borde de la escalera y JordiJor os mira con una leve sonrisa");
					System.out.print(teclat.nextLine());
					System.out.println("JordiJor:");
					System.out.println("");
					System.out.println("Este es vuestro final CarloBon!");
					System.out.println("Por fin podre gobernar yo solo!");
					System.out.print(teclat.nextLine());
					System.out.println("");
					System.out.println("JordiJor os golpea con la daga, directamente en el pecho, clavandose profundo y de la fuerza, salis disparado, escaleras abajo");
					System.out.print(teclat.nextLine());
					System.out.println("Caeis mientras gritais de dolor, pero no dura mucho, pues el impacto contra el suelo, es lo suficiente fuerte para dejaros al borde de la muerte");
					System.out.print(teclat.nextLine());
					System.out.println("Los parpados os pesan mucho... y de fondo solamente escuchais la risa macabra de JordiJor... poco a poco el dolor desaparece mientras que vuestro ojos se cierran...");
					System.out.print(teclat.nextLine());
					System.out.println("Habeis muerto...");
					
					
					fin_juego();
				}			
			}
			
			else if (cuchillo != true) {
				System.out.println("Aun no poseeis este objeto");
				System.out.println("");
			}
		}
		
		// Uso de la escalera
		else if (objeto.equals("escalera") && (jugador.getZona() == zona0)) {
			boolean escalera = comprovar_items(objetos_jugador, "escalera");
			
			if (escalera == true) {
				llave.setAltura(false);
				System.out.println("Entre los estantes has podido ver una llave!");
				System.out.println("");
			}
			
			else if (escalera != true) {
				System.out.println("Aun no poseeis este objeto");
				System.out.println("");
			}
		}
		
		// Uso del cuchillo con la cocinera
		else if (objeto.equals("cuchillo") && (jugador.getZona() == zona1) && Cocinera.getVivo() == true) {
			System.out.println("Habeis matado a la cocinera...");
			System.out.print(teclat.nextLine());
			System.out.print(teclat.nextLine());
			System.out.println("Era una mujer honrada y trabajadora...");
			
			if (escalera.getOculta() == true) {
				System.out.print(teclat.nextLine());
				System.out.println("Ahora no sabreis donde se encuentra el objeto que buscais");
				System.out.print(teclat.nextLine());
				System.out.println("Volveis a casa... sin poder haber vengado a RafaFer y con el remordimiento de haber matado a una persona inocente");
				System.out.print(teclat.nextLine());
				
				fin_juego();
			}
			
			else if (escalera.getOculta() == false) {
				System.out.println("Teneis la informacion de donde se encuentra ya la escalera...");
				System.out.print(teclat.nextLine());
				System.out.println("la habeis matado para no dejar testigos de la muerte de JordiJor");
				System.out.print(teclat.nextLine());
				System.out.println("O almenos con eso intentais justificaros a vosotros mismos");
				System.out.print(teclat.nextLine());
				Cocinera.setVivo(false);
			}
		}
	
		else {
			System.out.println("No podeis usar este item aqui");
			System.out.println();
		}
	}
	
	// Control del personaje
	public static void moure_Jugador(String accion, String objeto) {	
		if (accion.equals("mover") && objeto.equals("norte")) {
			if (jugador.getZona().tincNord()) {
				 jugador.setZona(jugador.getZona().getNord());	
				}
			else {	
				System.out.println("No podeis pasar por aqui, un muro os lo impide");
				System.out.println(" ");
			}
		}
		
		else if  (accion.equals("mover") && objeto.equals("sur")) {
			if (jugador.getZona().tincSud()) {
				 jugador.setZona(jugador.getZona().getSud());	
				}	
			else {
				
				System.out.println("No podeis pasar por aqui, un muro os lo impide");
				System.out.println(" ");
			} 
		}
		
		else if (accion.equals("mover") && objeto.equals("este")) {
			if (jugador.getZona().tincDreta()) {
				 jugador.setZona(jugador.getZona().getDreta());	
				}
			else {
				
				System.out.println("No podeis pasar por aqui, un muro os lo impide");
				System.out.println(" ");
			}
		}
		
		else if (accion.equals("mover") && objeto.equals("oeste")) {
			if (jugador.getZona().tincEsquerra()) {
				 jugador.setZona(jugador.getZona().getIzquierda());	
				}
			else {
				
				System.out.println("No podeis pasar por aqui, un muro os lo impide");
				System.out.println(" ");
			}
		}
		
		else {
			System.out.println("Orden Incorrecta");
			System.out.println("");
		}
		
	}
		
	// Dependiendo del array y el objeto que se le pase, comprovara si ese objeto esta en el array o no
	public static boolean comprovar_items(ArrayList<cItems> items, String nom_item) {
		boolean existe = false;
		boolean sortida = false;
		int a = 0;
		
		while (sortida != true && a < items.size()) {
			 if (nom_item.equals(items.get(a).getNom())) {
				existe = true;
				sortida = true;
			}
			 else {
				 existe = false;
			 }
		 a++;
		} 
		 return existe;
	}
	
	// Todo lo necesario para poder crear el mapa
 	public static cZona[] elaboracionMapa(cZona[] mapa_zonas) {
	
		//Poner Zonas al array
		mapa_zonas[0] =  zona0;
		mapa_zonas[1] =  zona1;
		mapa_zonas[2] =  zona2;
		mapa_zonas[3] =  zona3;
		mapa_zonas[4] =  zona4;
		mapa_zonas[5] =  zona5;
		mapa_zonas[6] =  zona6;
		mapa_zonas[7] =  zona7;
		mapa_zonas[8] =  zona8;
		mapa_zonas[9] =  zona9;
		
		//Entreconectar Zonas
		mapa_zonas[0].setDerecha(zona1);
		mapa_zonas[0].setSud(zona3);
		mapa_zonas[1].setIzquierda(zona0);
		mapa_zonas[1].setDerecha(zona2);
		mapa_zonas[2].setIzquierda(zona1);
		mapa_zonas[2].setSud(zona5);	
		mapa_zonas[3].setSud(zona6);
		mapa_zonas[3].setNord(zona0);
		mapa_zonas[3].setDerecha(zona4);	
		mapa_zonas[4].setSud(zona7);
		mapa_zonas[4].setDerecha(zona5);
		mapa_zonas[4].setIzquierda(zona3);	
		mapa_zonas[5].setNord(zona2);
		mapa_zonas[5].setIzquierda(zona4);
		mapa_zonas[5].setSud(zona8);	
		mapa_zonas[6].setNord(zona3);	
		mapa_zonas[7].setNord(zona4);
		mapa_zonas[8].setNord(zona5);
		
		// Si es false, significa que la habitacion esta a oscuras
		mapa_zonas[0].setLuz(false);
		mapa_zonas[1].setLuz(false);
		mapa_zonas[2].setLuz(false);
		mapa_zonas[3].setLuz(false);
		mapa_zonas[4].setLuz(false);
		mapa_zonas[5].setLuz(false);
		mapa_zonas[6].setLuz(false);
		mapa_zonas[7].setLuz(false);
		mapa_zonas[8].setLuz(false);
		
		//Omplir Zones 
		zona0.omplirZona(zona0, "el almacem", "Es un almacen como otro cualquiera: polvoriento, desordenado y lleno de objetos insolitos. \r\n" + " A vuestro alrededor, podeis ver multiples armaduras, espadas, escudos... \r\n" + "La gran mayoria oxidado. Ademas de eso tambien encontrais muchos muebles, apilados y ordenados perfectamente, y varias herramientas.");
		zona1.omplirZona(zona1, "la cocina", "Lugubre, oscura, polvorienta... Son algunas de las palabras que utilizarias para describir aquella cocina. \r\n" + "Gracias a la luz, aunque escasa, que entra por la ventana, lograis distinguir una gran mesa llena de comida. \r\n" + "Aunque el olor que desprendia era delicioso el aspecto no invitaba a incarle el diente. \r\n" + "Con dificultad veis como en una esquina de la cocina una mujer de mediana edad esta fregando los platos sucios y secandolos con un trapo roto. \r\n" + "Respirais aliviado al reconocerla, puesto que es la misma cocinera que trabajaba cuando vos erais parte de la guardia tiempo atras.");
		zona2.omplirZona(zona2, "el comedor", "Hay una gran mesa alargada de madera oscura rodeada por sillas a juego. Una gran lampara cuelga del techo sobre el centro de la mesa.  \r\n" + "A diferencia de otras habitaciones esta impecable: limpia y luminosa. \r\n" + "Esto demuestra como las condiciones de vida en el palacio habian subido desde la ultima ves que estuvisteis ahi.");
		zona3.omplirZona(zona3, "el aseo", "Lo primero en lo que posais vuestra vista es en una gran tina, rodeada de velas aromaticas. \r\n" + "La luz que desprenden las velas mezclado con el aroma de estas provoca un sentimiento calido y acogedor. \r\n" + "Pero no podeis permitiros un remojo relajante en estos momentos... Teneis una mision.");
		zona4.omplirZona(zona4, "la escalera principal", "Frente a vos se encuentra una gran puerta de madera con un el simbolo real en ella. \r\n" + "Deducis que conduce a los aposentos del despiadado JordiJor, vuestro objetivo. Por desgracia la puerta esta cerrada, necesitais una llave para abrirla.");
		zona5.omplirZona(zona5, "el salon de actos", "Quedais asombrado por la amplia estancia en la que os encontrais. \r\n" + "El salon reluce por si solo: un suelo impecable donde os podeis reflejar cual espejo, refinadas figuras de marmol y multiples delicadas lamparas de cristal colgando del techo.");
		zona6.omplirZona(zona6, "los establos", "Grande y espacioso, dignos de la realeza. Los establos son una gran estancia llena de cuadras para los caballos, aun asi no en todos hay caballos. \r\n" + "Vuestro antiguo caballo, el cual teniais en la guardia, ya no estaba en su cuadra habitual.");
		zona7.omplirZona(zona7, "la entrada principal", "Frente a vos un gran porton de madera, cerrado por un gran mecanismo de metal.");
		zona8.omplirZona(zona8, "la recepcion", "Un largo pasillo abierto, luminoso y de techos altos, con vistas al patio interior del palacio.");
		zona9.omplirZona(zona9, "en el dormitorio principal", "Nada mas entrar podeis ver una gran cama, con sabanas limpias, cojines mullidos y larga cortina de terciopelo colgando sobre ella. \r\n" + "Todo perfectamente ordenado y con detalles rojos y dorados. \r\n" + "Sobre la cama, placidamente dormido, se encuentra JordiJor, rodeado de muchas mujeres.");
						
		return mapa_zonas;
	}
	
}