package logica;

public class Sala {
	private String nombreSala;
	private Entrada butacas[][];
	public static final int FILAS = 5;
	public static final int NBUTACAS = 6;

	public Sala(String nombreSala) {

		this.setNombreSala(nombreSala);
	}

	public Entrada[][] mostrarAsientos() {
		if (butacas == null) {
			butacas = new Entrada[FILAS][NBUTACAS];
			crearButacas();
		}
		return butacas;
	}

	private void crearButacas() {
		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[0].length; j++) {
				butacas[i][j] = new Entrada(j, j);

			}

		}
	}

	public void reservarButacas(int fila, int butaca) {
		if (butacas[fila][butaca].isEstado()) {
			butacas[fila][butaca].setEstado(false); // Ahora tiene de estado
													// libre (true) y pasa a
													// ocupado (FAlse)
		} else {
			butacas[fila][butaca].setEstado(true); // Ahora tiene de estado
			// ocupado (False) y pasa a libre true
		}
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public Entrada[][] getButacas() {
		return butacas;
	}

	public void setButacas(Entrada[][] butacas) {
		this.butacas = butacas;
	}

	/*
	 * 'estado' == true; butaca ocupada 'estado' == false; butaca ocupada
	 * estado == false => butaca libre
	 * 
	 * pasara a estar comprada por lo que el
	 * siguiente usuario no podrá comprar la misma entrada que el anterior.
	 * 
	 * 'comprada' == true;=> butaca comprada => 'estado' == false; butaca
	 * ocupada 'comprada' == false;=> butaca no comprada=> 'estado' == true;
	 * butaca libre
	 */
	public void comprarButacas() {
		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[0].length; j++) {

				if (butacas[i][j].isEstado() == true) {
					butacas[i][j].setComprada(true);

				}
			}

		}
	}
}
