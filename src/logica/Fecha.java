package logica;

import java.util.ArrayList;

public class Fecha {

	private String fecha;
	private ArrayList<Sesion> horas;

	// public Entrada[][]

	public Fecha(String fecha) {

		horas = new ArrayList<Sesion>();
		setFecha(fecha);
	}

	public void annadirHoras(Sesion h) {
		horas.add(h);
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Sesion> getHoras() {
		return horas;
	}

	public Entrada[][] mostarButacas(String sesion) {
		for (Sesion s : horas) {
			if (s.getHora().equals(sesion)) {
				return s.mostrarButacasSesion();
			}
		}
		return null;
	}

	public void reservarPeli(String hora, int fila, int butaca) {
		for (Sesion s : horas) {
			if (s.getHora().equals(hora)) {
				s.reservarPeliSesion(fila, butaca);
			}

		}

	}
	public void comprarButaca(String hora) {
		for (Sesion s : horas) {
			if (s.getHora().equals(hora)) {
				s.comprarPeliSesion();
			}

		}

	}
}
