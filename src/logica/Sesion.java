package logica;

public class Sesion {

	private String hora;

	private Sala s;

	public Sesion(String hora) {

		setS(new Sala(hora));

		setHora(hora);

	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Sala getS() {
		return s;
	}

	public void setS(Sala s) {
		this.s = s;
	}

	public Entrada[][] mostrarButacasSesion() {

		return s.mostrarAsientos();
	}

	public void reservarPeliSesion(int fila, int butaca) {
		s.reservarButacas(fila, butaca);
	}

	public void comprarPeliSesion() {
		s.comprarButacas();
		
	}
}
