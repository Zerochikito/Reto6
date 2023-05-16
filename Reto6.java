package reto6;

import java.util.Scanner;

/**
 * Esta clase implementa un sistema de menú para obtener información sobre Paraguay.
 */
public class Reto6 {
	
	/**
	 * Imprime el menú inicial del programa.
	 */	
	public static void imprimirMenuIni() {
		System.out.println("Menú Paraguay:");
		System.out.println("1. Historia");
		System.out.println("2. Información general");
		System.out.println("3. Reseñas");
		System.out.println("4. Juegos");
		System.out.println("5. Salir");
	}
	
	/**
	 * Recoge y valida la opción ingresada por el usuario en el menú inicial.
	 *
	 * @return La opción seleccionada.
	 */	
	public static int recogerYValidarOpcionIni() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.print("Ingrese una opción numérica: ");
			
			while (!sc.hasNextInt()) {
				System.out.println("Opción inválida. Intentalo denuevo.");
				System.out.print("Ingrese una opción numérica: ");
				sc.next(); 
			}
			
			opcion = sc.nextInt();

			if (opcion < 1 || opcion > 5) {
				System.out.println("Opción inválida. Intentalo denuevo.");
			}
			
		} while (opcion < 1 || opcion > 5);
		
		return opcion;
	}
	
	/**
	 * Realiza la acción correspondiente a la opción elegida en el menú inicial.
	 *
	 * @param opcion La opción seleccionada.
	 */
	public static void opcionElegidaIni(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("Has seleccionado Historia\n");
			menuHistoria();
			break;
		case 2:
			System.out.println("Has seleccionado Información general\n");
			menuInfoGen();
			break;
		case 3:
			System.out.println("Has seleccionado Reseñas\n");
			resenas();
			break;
		case 4:
			System.out.println("Has seleccionado Juegos\n");
			juegoPreguntas();
			break;
		case 5:
			System.out.println("\nSaliendo...\nGracias por utilizar el programa");
			System.exit(0);
		default:
			System.out.println("Opción inválida. Por favor, intente de nuevo.\n");
			break;
		}
	}
	
	/**
	 * Muestra el menú inicial y espera a que el usuario seleccione una opción.
	 * Luego, realiza la acción correspondiente a la opción elegida.
	 */
	public static void menuInicial() {
		int opcion;

		while (true) {
			imprimirMenuIni();
			opcion = recogerYValidarOpcionIni();
			opcionElegidaIni(opcion);
			
		}
	}
	
	/**
	 * En un array bidimensional creado se guardan las preguntas y las 
	 * posibles respuestas junto la correcta. Al final el array es devuelto
	 * @return
	 */
	public static String[][] arrayPreguntas() {

		String[][] preguntas = {
				{"¿Cuál es la capital de Paraguay?", "A) Asunción", "B) Ciudad del Este", "C) Encarnación", "A"},
				{"¿Qué río forma la frontera entre Paraguay y Argentina?", "A) Paraná", "B) Amazonas", "C) Orinoco", "A"},
				{"¿Qué moneda se utiliza en Paraguay?", "A) Peso", "B) Dólar", "C) Guaraní", "C"},
				{"¿Cuál es el deporte nacional de Paraguay?", "A) Béisbol", "B) Baloncesto", "C) Fútbol", "C"},
				{"¿Qué comida típica de Paraguay está hecha de almidón de mandioca?", "A) Sopa paraguaya", "B) Chipa", "C) Mbejú", "B"},
		};

		return preguntas;
	}

	/**
	 * Deveras responder a las preguntas que estan almacenadas 
	 * en un array y te dira si es correcto o no, si lo es se 
	 * sumara un punto en la puntuacion y al final devolver esta
	 * @param preguntas es el array que contiene las preguntas/respuestas
	 * @return
	 */
	public static int preguntaRespuesta(String[][] preguntas) {
		Scanner sc = new Scanner(System.in);
		int puntuacion = 0;

		for (int i = 0; i < preguntas.length; i++) {
			System.out.println(preguntas[i][0]);
			System.out.println(preguntas[i][1]);
			System.out.println(preguntas[i][2]);
			System.out.println(preguntas[i][3]);
			String respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase(preguntas[i][4])) {
				System.out.println("¡Correcto!");
				puntuacion++;
			} else {
				System.out.println("Incorrecto. La respuesta correcta es: " + preguntas[i][4]);
			}
		}

		return puntuacion;
	}
	/**
	 * Imprime la frase final diciendote la puntuacion
	 * @param puntuacion es la puntuacion final que has logrado
	 * @param preguntas es el array que contiene las preguntas/respuestas
	 */
	public static void imprimirPuntuacion(int puntuacion, String[][] preguntas) {
		System.out.println("Tu puntaje final es: " + puntuacion + "/" + preguntas.length);
	}
	
	/**
	 * Esta clase es una serie de preguntas sobre paraguay en formato quiz
	 */
	public static void juegoPreguntas() {
		String[][] preguntas;
		int puntuacion;

		preguntas = arrayPreguntas();
		puntuacion = preguntaRespuesta(preguntas);
		imprimirPuntuacion(puntuacion,preguntas);
	}
	
	/**
	 * Imprime el menú de opciones para las reseñas.
	 */
	public static void imprimirMenuResenas() {
		System.out.println("1. Cultura y patrimonio.");
		System.out.println("2. Paisajes naturales.");
		System.out.println("3. Infraestructuras y servicios.");
		System.out.println("4. Seguridad y estabilidad.");
		System.out.println("5. Economia y oportunidades.");
		System.out.println("6. Educacion y desarrolo humano.");
		System.out.println("7. Hospitalidad y amabilidad.");
		System.out.println("8. Accesibilidad y transporte.");
	}
	
	/**
	 * Este método permite escribir reseñas sobre diferentes temas.
	 */
	public static void resenas() {
		String[] resenas;
		
		
		resenas = RellenarResenas();
		//imprimirReseñas(reseñas);
	}
	
	/**
	 * Este método solicita al usuario que elija un apartado y escriba una reseña sobre el mismo.
	 * @return Un arreglo de Strings que contiene las reseñas ingresadas por el usuario.
	 */
	public static String[] RellenarResenas(){
		Scanner sc = new Scanner(System.in);
		String[] resena = new String[10];
		int num;
		int cont=0;
		char resp;
		boolean[] esta = new boolean[8];

		
		do {
			
			imprimirMenuResenas();
			
			System.out.println("- Eliga el apartado de la reseña que quiere escribir(introducir el numero):");
			num = sc.nextInt();
			sc.nextLine();
			System.out.println("");

			switch (num) {
			case 1:
				if (esta[0] == false) {
					System.out.println("   Ha seleccionado Cultura y patrimonio.");
					System.out.println("Introduzca la reseña sobre el tema seleccinado:");
					resena[cont] = sc.nextLine();
					cont++;
					esta[0] = true;
				}else {
					System.out.println("No puede escribir mas de una reseña del mismo apartado.");
				}		
				break;
			case 2:
				if (esta[1] == false) {
					System.out.println("  Ha seleccionado Paisajes naturales.");
					System.out.println("Introduzca la reseña sobre el tema seleccinado:");
					resena[cont] = sc.nextLine();
					cont++;
					esta[1] = true;
				}else {
					System.out.println("No puede escribir mas de una reseña del mismo apartado.");
				}
				break;
			case 3:
				if (esta[2] == false) {
					System.out.println("   Ha seleccionado Infraestructuras y servicios.");
					System.out.println("Introduzca la reseña sobre el tema seleccinado:");
					resena[cont] = sc.nextLine();
					cont++;
					esta[2] = true;
				}else {
					System.out.println("No puede escribir mas de una reseña del mismo apartado.");
				}
				break;
			case 4:
				if (esta[3] == false) {
					System.out.println("   Ha seleccionado Seguridad y estabilidad.");
					System.out.println("Introduzca la reseña sobre el tema seleccinado:");
					resena[cont] = sc.nextLine();
					cont++;
					esta[3] = true;
				}else {
					System.out.println("No puede escribir mas de una reseña del mismo apartado.");
				}
				break;
			case 5:
				if (esta[4] == false) {
					System.out.println("   Ha seleccionado Economia y oportunidades.");
					System.out.println("Introduzca la reseña sobre el tema seleccinado:");
					resena[cont] = sc.nextLine();
					cont++;
					esta[4] = true;
				}else {
					System.out.println("No puede escribir mas de una reseña del mismo apartado.");
				}
				break;
			case 6:
				if (esta[5] == false) {
					System.out.println("   Ha seleccionado Educacion y desarrolo humano.");
					System.out.println("Introduzca la reseña sobre el tema seleccinado:");
					resena[cont] = sc.nextLine();
					cont++;
					esta[5] = true;
				}else {
					System.out.println("No puede escribir mas de una reseña del mismo apartado.");
				}
				break;
			case 7:
				if (esta[6] == false) {
					System.out.println("   Ha seleccionado Hospitalidad y amabilidad.");
					System.out.println("Introduzca la reseña sobre el tema seleccinado:");
					resena[cont] = sc.nextLine();
					cont++;
					esta[6] = true;
				}else {
					System.out.println("No puede escribir mas de una reseña del mismo apartado.");
				}
				break;
			case 8:
				if (esta[7] == false) {
					System.out.println("   Ha seleccionado Accesibilidad y transporte.");
					System.out.println("Introduzca la reseña sobre el tema seleccinado:");
					resena[cont] = sc.nextLine();
					cont++;
					esta[7] = true;
				}else {
					System.out.println("No puede escribir mas de una reseña del mismo apartado.");
				}
				break;
			default:
				System.out.println("Opción inválida. Por favor, intente de nuevo.");
				break;
			}

			System.out.println("");
			if(cont < 8) {
				System.out.println("Quiere escribir otra reseña sobre el pais(max 1 por cada apartado)? (Si(s) | No(n)");
				resp = sc.nextLine().charAt(0);
			}else {
				System.out.println("Ya no puedes escribir mas reseñas. Pulsa 'f'(finalizar).");
				resp = sc.nextLine().charAt(0);
			}
		}while(resp == 's' && cont < 8);
		
		return resena;
	}
	
	/**
	 * Imprime las reseñas proporcionadas en la consola.
	 *
	 * @param resenas un arreglo de cadenas que representa las reseñas a imprimir
	 */
	public static void imprimirResenas(String[] resenas) {
		System.out.println("");
		System.out.println("");
		System.out.println("   RESEÑAS INTRODUCIDAS:");
		System.out.println("");
		
		for(int i=0; i<resenas.length; i++) {
			if(resenas[i] != null) {
				System.out.println(" Reseña "+(i+1)+": "+resenas[i]);
			}
		}
	}
	
	/**
	 * Imprime el menú de opciones para la sección de Historia.
	 */
	public static void imprimirMenuHis() {
		System.out.println("---- Historia ----");
		System.out.println("1. Historia");
		System.out.println("2. Simbolos");
		System.out.println("3. Volver al Menú Principal");
	}
	
	/**
	 * Lee y valida la opción numérica ingresada por el usuario para la sección de Historia.
	 *
	 * @return la opción numérica válida ingresada por el usuario
	 */
	public static int recogerYValidarOpcionHis() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.print("Ingrese una opción numérica: ");
			
			while (!sc.hasNextInt()) {
				System.out.println("Opción inválida. Intentalo denuevo.");
				System.out.print("Ingrese una opción numérica: ");
				sc.next(); 
			}
			
			opcion = sc.nextInt();

			if (opcion < 1 || opcion > 5) {
				System.out.println("Opción inválida. Intentalo denuevo.");
			}
			
		} while (opcion < 1 || opcion > 5);
		
		return opcion;
	}
	
	/**
	 * Realiza una acción en base a la opción elegida para la sección de Historia.
	 *
	 * @param opcion la opción numérica seleccionada por el usuario
	 */
	public static void opcionElegidaHis(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("Ha seleccionado Historia\n");
			historia();
			break;
		case 2:
			System.out.println("Ha seleccionado Simbolos\n");
			menuSimbolos();
			break;
		case 3:
			System.out.println("Volviendo al Menú Principal...\n");
			menuInicial();
		default:
			System.out.println("Opción inválida. Por favor, intente de nuevo.");
			break;
		}
	}
	
	/**
	 * Imprime información sobre la historia de Paraguay en la consola.
	 * Después de imprimir la información, muestra el menú de opciones de historia.
	 */
	public static void historia() {
		System.out.println("Se sabe de asentamientos humanos en el Paraguay desde el Neolítico. Sin embargo,\n"
				+ "al momento de la llegada de los conquistadores europeos en el siglo XV, la tribu\npredominante "
				+ "en la región eran los avá (guaraníes), cuyo primer encuentro con los\ninvasores fue con el "
				+ "expedicionario portugués Alejo García, quien colaboraba con los\nespañoles, en 1524."
				+ "La colonia española en Paraguay inició en 1537, cuando\nsobrevivientes de la primera fallida "
				+ "fundación de Buenos Aires buscaron refugio\nen la región, fundando lo que sería luego Asunción "
				+ "del Paraguay. La colonia española\nen Paraguay inició en 1537, cuando sobrevivientes de la primera fallida fundación "
				+ "de\n Buenos Aires buscaron refugio en la región, fundando lo que sería luego Asunción\n"
				+ "del Paraguay. Su salida al mar mediante el río homónimo era muy valiosa en el éxodo\n"
				+ "de recursos provenientes del Virreinato del Perú, pero fue luego perdido cuando se\n"
				+ "dividió la provincia en dos gobernaciones, dejando a la de Buenos Aires el control del\n"
				+ "Río de la Plata. Posteriormente el Paraguay formó parte del Virreinato del Río de\n"
				+ "la Plata, el más joven y efímero de todos. La etapa colonial paraguaya duró desde\n"
				+ "entonces hasta 1811, fecha en que se proclamó la independencia, como parte del\n"
				+ "movimiento insurgente suramericano de la época. La insurrección paraguaya fue\n"
				+ "pacífica, a través de la convocatoria a un Congreso. Inicialmente se intentó sumar\n"
				+ "al Paraguay a las Provincias Unidas del Río de la Plata, pero la rivalidad de las\n"
				+ "élites porteñas y asuncenas no lo permitió. Paraguay inició su gobierno independiente\n"
				+ "en 1814 bajo el mando de José Gaspar Rodríguez de Francia.\n");
		menuHistoria();
	}
	
	/**
	 * Imprime el menú de opciones para la sección de Símbolos.
	 */
	public static void imprimirMenuSim() {
		System.out.println("---- Simbolos ----");
		System.out.println("1. Bandera de Paraguay");
		System.out.println("2. Himno Nacional Paraguay");
		System.out.println("3. Escudos de Paraguay");
		System.out.println("4. Volver al Menú Principal");
	}
	
	/**
	 * Lee y valida la opción numérica ingresada por el usuario para la sección de Símbolos.
	 *
	 * @return la opción numérica válida ingresada por el usuario
	 */
	public static int recogerYValidarOpcionSim() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.print("Ingrese una opción numérica: ");
			while (!sc.hasNextInt()) {
				System.out.println("Opción inválida. Intentalo denuevo.");
				System.out.print("Ingrese una opción numérica: ");
				sc.next(); 
			}
			opcion = sc.nextInt();

			if (opcion < 1 || opcion > 5) {
				System.out.println("Opción inválida. Intente nuevamente.");
			}
		} while (opcion < 1 || opcion > 5);

		return opcion;
	}
	
	/**
	 * Realiza una acción en base a la opción elegida para la sección de Símbolos.
	 *
	 * @param opcion la opción numérica seleccionada por el usuario
	 */
	public static void opcionElegidaSim(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("Has seleccionado Bandera de Paraguay\n");
			bandera();
			break;
		case 2:
			System.out.println("Ha seleccionado Himno Nacional de Paraguay\n");
			himno();
			break;
		case 3:
			System.out.println("Ha seleccionado Escudos de Paraguay\n");
			escudos();
			break;
		case 4:
			System.out.println("Volviendo al Menú Principal...\n");
			menuInicial();
			break;
		default:
			System.out.println("Opción inválida. Inténtelo denuevo.");
			break;
		}
	}
	
	/**
	 * Imprime información sobre la bandera del Paraguay.
	 */
	public static void bandera() {
		System.out.println("La bandera del Paraguay. Adoptada en 1842, presenta tras franjas de colores rojo,\n"
				+ "blanco y azul (de arriba hacia abajo) y un escudo en la franja intermedia: dos ramas\n"
				+ "de palma y olivo en forma de corona, alrededor de una estrella amarilla. En el reverso,\n"
				+ "sin embargo, tiene otro escudo diferente, que muestra a un león acompañado de un gorro\n"
				+ "frigio y la inscripción Paz y Justicia.\n");
	}
	
	/**
	 * Imprime información sobre el himno nacional del Paraguay.
	 */
	public static void himno() {
		System.out.println("El himno nacional del Paraguay. Fue escrito por el uruguayo Francisco Acuña de\n"
				+ "Figueroa y compuesto por un autor incierto, posteriormente recompuesto por el paraguayo\n"
				+ "Remberto Giménez en 1933. Aunque su título oficial es Himno Nacional Paraguayo, tiene\n"
				+ "también un nombre en guaraní: Tetã Paraguái Momorãhéi.\n");
	}
	
	/**
	 * Imprime información sobre los escudos del Paraguay.
	 */
	public static void escudos() {
		System.out.println("Escudos del Paraguay. Representados en la bandera paraguaya, estos dos escudos\n"
				+ "fueron creados en 1842 por el Congreso General Extraordinario de la nación.");
	}
	
	/**
	 * Muestra el menú de opciones para la sección de Símbolos y gestiona la selección del usuario.
	 */
	public static void menuSimbolos(){
		int opcion;

		while (true) {
			imprimirMenuSim();
			opcion = recogerYValidarOpcionSim();
			opcionElegidaSim(opcion);
			
		}
	}
	
	/**
	 * Muestra el menú de opciones para la sección de Historia y gestiona la selección del usuario.
	 */
	public static void menuHistoria() {
		int opcion;

		while (true) {
			imprimirMenuHis();
			opcion = recogerYValidarOpcionHis();
			opcionElegidaHis(opcion);
		}
	}
	
	/**
	 * Imprime el menú de opciones para la sección de Información General.
	 */
	public static void imprimirMenuInfo() {
		System.out.println("---- Información General ----");
		System.out.println("1. Qué es Paraguay");
		System.out.println("2. Capital de Paraguay");
		System.out.println("3. Población de Paraguay");
		System.out.println("4. Cultura paraguaya");
		System.out.println("5. Idiomas de Paraguay");
		System.out.println("6. Economía de Paraguay");
		System.out.println("7. Moneda paraguaya");
		System.out.println("8. Turismo en Paraguay");
		System.out.println("9. Geografía de Paraguay");
		System.out.println("10. Volver al Menú Principal");
	}
	
	/**
	 * Lee y valida la opción numérica ingresada por el usuario para la sección de Información General.
	 *
	 * @return la opción numérica válida ingresada por el usuario
	 */
	public static int recogerYValidarOpcionInfo() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.print("Ingrese una opción numérica: ");
			while (!sc.hasNextInt()) {
				System.out.println("Opción inválida. Inténtelo denuevo.");
				System.out.print("Ingrese una opción numérica: ");
				sc.next(); 
			}
			opcion = sc.nextInt();

			if (opcion < 1 || opcion > 10) {
				System.out.println("Opción inválida. Inténtelo denuevo.");
			}
		} while (opcion < 1 || opcion > 10);
		
		return opcion;
	}
	
	/**
	 * Gestiona la opción seleccionada por el usuario en la sección de Información General.
	 *
	 * @param opcion la opción seleccionada por el usuario
	 */
	public static void opcionElegidaInfo(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("Has seleccionado Qué es Paraguay\n");
			queEs();
			break;
		case 2:
			System.out.println("Has seleccionado Capital de Paraguay\n");
			capital();
			break;
		case 3:
			System.out.println("Has seleccionado Población de Paraguay\n");
			poblacion();
			break;
		case 4:
			System.out.println("Has seleccionado Cultura paraguaya\n");
			cultura();
			break;
		case 5:
			System.out.println("Has seleccionado Idiomas de Paraguay\n");
			idiomas();
			break;
		case 6:
			System.out.println("Has seleccionado Economía de Paraguay\n");
			economia();
			break;
		case 7:
			System.out.println("Has seleccionado Moneda paraguaya\n");
			moneda();
			break;
		case 8:
			System.out.println("Has seleccionado Turismo en Paraguay\n");
			turismo();
			break;
		case 9:
			System.out.println("Has seleccionado Geografía de Paraguay\n");
			geografia();
			break;
		case 10:
			System.out.println("Volviendo al Menú Principal...\n");
			menuInicial();
			break;
		default:System.out.println("");
		System.out.println("Opción inválida. Inténtelo denuevo.");
			break;
		}
	}
	
	/**
	 * Imprime información sobre la geografía de Paraguay.
	 */
	public static void geografia() {
		System.out.println("El Paraguay se divide en dos grandes regiones geográficas y topográficas, a partir\n"
				+ "del río que lo surca, el Paraguay: la región oriental o paraneña (39% del territorio\n"
				+ "nacional) presenta un paisaje ondulante de colinas, con abundante lluvia (hasta\n"
				+ "1700mm/año) y la región occidental o Chaco (61% del territorio nacional) en cambio\n"
				+ "es una planicie aluvial de suelos neutros, semiárida a subhúmeda, con sedimentos\n"
				+ "provenientes de los Andes.\n"
				+ "Esta última región está formada por el lecho marino levantado geológicamente durante\n"
				+ "la era Cuaternaria y se divide en el Chaco húmedo o bajo Chaco, una planicie inundable\n"
				+ "irrigada por los ríos Paraguay y Pilcomayo, y el Chaco seco o Chaco boreal, con menores\n"
				+ "registros de precipitación y mayor aridez.\n");
	}
	
	/**
	 * Imprime información sobre el turismo en Paraguay.
	 */
	public static void turismo() {
		System.out.println("Paraguay es el país menos visitado de América del Sur, por debajo incluso de Guyana\n"
				+ "y Surinam, con apenas 610.000 turistas internacionales en 2013-2014.\n"
				+ "Esto no se debe a que carezca de atractivos turísticos: solamente el paseo en crucero\n"
				+ "por el río Paraguay, la visita a los pantanales del Chaco, o las compras en Ciudad\n"
				+ "del Este, constituyen un pequeño foco en crecimiento.\n"
				+ "Igualmente, el carnaval encarnaceno, la mayor fiesta realizada en la ciudad de\n"
				+ "Encarnación y el carnaval más importante del país, atrae anualmente a un aproximado\n"
				+ "de 50.000 turistas.\n"
				+ "En la misma ciudad, las costas del Paraná ofrecen un atractivo turístico que empieza\n"
				+ "a aprovecharse con malecones y construcciones semejantes.\n");
	}
	
	/**
	 * Imprime información sobre la moneda de Paraguay.
	 */
	public static void moneda() {
		System.out.println("La moneda de Paraguay es el guaraní (G), vigente desde 1943, cuyo código ISO es PYG.\n"
				+ "Considerando la inflación anual (2017) de 4,5%, el guaraní se cambia por monedas más\n"
				+ "fuertes como el dólar (USD) o el euro (EUR) a una tasa de 1 x 5650 o 1 x 6750\n"
				+ "respectivamente.\n");
	}
	
	/**
	 * Imprime información sobre la economía de Paraguay.
	 */
	public static void economia() {
		System.out.println("Medianamente diversificada, la economía paraguaya ha sido una de las grandes\n"
				+ "promesas continentales de las últimas décadas, en especial en 2010 cuando demostró\n"
				+ "un sorprendente crecimiento del 14.5% del PIB.\n"
				+ "Esto no ha solucionado los severos problemas sociales de la nación, aquejada por un\n"
				+ "35,1% de pobreza y poseedora del PIB más pequeño de la región.\n"
				+ "En medio de un verdadero boom de la construcción, Paraguay es el mayor exportador de\n"
				+ "energía eléctrica del continente, además del cuarto exportador de soja y quinto de carne\n"
				+ "bovina en el mundo y una enorme flota de barcazas a lo largo del río Paraguay.\n"
				+ "También es un importante productor de maíz, trigo, sésamo, aceite de girasol, azúcar y\n"
				+ "stevia. La ganadería en El Chaco es importante.\n"
				+ "El resto de la riqueza la generan los sectores financiero y comercial, a quienes se les\n"
				+ "atribuye el 28% de participación económica aproximada.\n");
	}
	
	/**
	 * Imprime información sobre los idiomas de Paraguay.
	 */
	public static void idiomas() {
		System.out.println("Paraguay es una nación multicultural y bilingüe, posee dos idiomas oficiales:\n"
				+ "el español, impuesto por la colonia española durante siglos y hablado en común\n"
				+ "con el resto del subcontinente (excepto Brasil); y el guaraní, lengua aborigen\n"
				+ "hablada y escrita por el 87% de los habitantes del Paraguay, que cuenta incluso\n"
				+ "de una Academia de la Lengua Guaraní.\n"
				+ "El guaraní es una lengua de la familia tupí-guaraní, hablada actualmente por 12\n"
				+ "millones de personas en la región sur de Suramérica. Esto incluye al Paraguay,\n"
				+ "a Bolivia y también a las provincias argentinas del noreste, como Corrientes,\n"
				+ "Formosa, Misiones, regiones del Chaco y de Entre Ríos.\n");
	}
	
	/**
	 * Imprime información sobre la cultura de Paraguay.
	 */
	public static void cultura() {
		System.out.println("La cultura paraguaya es mestiza y relativamente homogénea, aunque no existen\n"
				+ "referencias en la nación a los conceptos de mestizaje o de hibridación, de vital\n"
				+ "importancia en otros países latinoamericanos.\n"
				+ "Hay reminiscencias de la cultura europea traída por los jesuitas, como la religión\n"
				+ "católica (seguida por 90% de la población) y cristiana (6,2%) o evangélica (1,1%),\n"
				+ "que conviven con religiones indígenas.\n"
				+ "En la música paraguaya predominan la guitarra, el arpa, sobre todo en el folklore,\n"
				+ "cuyas dos principales vertientes son la canción paraguaya (polca) y la guarania.\n"
				+ "La gastronomía también presenta abundancia de elementos autóctonos, como la única\n"
				+ "sopa sólida (sopa paraguaya), el tereré o mate frío como bebida nacional, la chipá\n"
				+ "(hecha de almidón) y otros platos en los que abunda la mandioca (yuca) cocida.\n"
				+ "La carne, el puchero, la milanesa, también son comunes.\n"
				+ "Las artes en Paraguay florecieron durante del siglo XX, especialmente el cine,\n"
				+ "gracias a numerosas coproducciones con Argentina y Brasil, hasta cobrar un cierto\n"
				+ "realce a principios del siglo XXI, con una oleada de nuevos y jóvenes directores\n"
				+ "como Gustavo Delgado, Juan Carlos Meneglia y Tana Schémbori.\n");
	}
	
	/**
	 * Imprime información sobre la población de Paraguay.
	 */
	public static void poblacion() {
		System.out.println("El Paraguay es un país relativamente despoblado, con apenas 7.052.983 habitantes\n"
				+ "en totalidad, con una densidad media de 17,3 hab/km2, menor que en la mayoría de\n"
				+ "los países latinoamericanos.\n"
				+ "La población paraguaya se distribuye muy irregularmente a lo largo de su territorio,\n"
				+ "concentrada casi toda en la región oriental, en ciudades como Asunción o Ciudad del\n"
				+ "Este.\n"
				+ "La región occidental, en cambio, tiene menos del 5% de la población en casi 61% del\n"
				+ "territorio nacional.\n");
	}
	
	/**
	 * Imprime información sobre la capital de Paraguay.
	 */
	public static void capital() {
		System.out.println("La capital del Paraguay es la ciudad de Asunción, ubicada en el centro oeste de la\n"
				+ "región oriental del país, en un municipio autónomo llamado Distrito Capital.\n"
				+ "Su área metropolitana abarca un conjunto de pequeñas ciudades en una superficie urbana\n"
				+ "total de 1029 km2 (117 km2 de capital propiamente dicha) y alberga una población de\n"
				+ "2.128.258 habitantes aproximadamente.\n");
	}
	
	/**
	 * Imprime información sobre qué es Paraguay.
	 */
	public static void queEs() {
		System.out.println("Paraguay es una nación sudamericana cuyo nombre oficial es República del Paraguay y\n"
				+ "que se sitúa en la zona central del subcontinente, limitando con Argentina al sur,\n"
				+ "Bolivia al norte y Brasil al este. Se trata del quinto país más pequeño y el cuarto\n"
				+ "menos poblado de América del Sur. El Paraguay es un estado democrático, soberano y\n"
				+ "multicultural. Es una antigua colonia del Imperio Español, como casi todo el resto\n"
				+ "del continente, y estuvo entre los primeros países latinoamericanos en alcanzar su\n"
				+ "independencia en el siglo XIX. En la actualidad la nación se rige por un sistema\n"
				+ "republicano presidencialista y es miembro fundador de Mercosur, junto con Argentina,\n"
				+ "Brasil y Uruguay, además de miembro de Unasur. No se ha llegado a un consenso respecto\n"
				+ "al origen etimológico del nombre de Paraguay, si bien se sabe que proviene de la lengua\n"
				+ "guaraní: paraguái, topónimo que a menudo se traduce como río que origina un mar,\n"
				+ "agua de los paraguaes, río coronado e incluso el nombre de un supuesto cacique\n"
				+ "de la región: paraguaio.\n");
	}
	
	/**
	 * Imprime el menú de información general.
	 */
	public static void menuInfoGen() {
		int opcion;

		while (true) {
			imprimirMenuInfo();
			opcion = recogerYValidarOpcionInfo();
			opcionElegidaInfo(opcion);
		}
	}
	
	/**
	 * Punto de entrada principal del programa.
	 *
	 * @param args Los argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
		
		menuInicial();
		
	}
}
