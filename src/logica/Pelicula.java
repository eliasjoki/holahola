package logica;

import java.util.ArrayList;

public class Pelicula {
	private String codigoPelicula;
	private String titulo;
	private String sipnosis;
	private String genero;
	private int duracion;
	private String edadRecomendada;
	private String horarios;
	private String nombreSala;
	private char formatoTresD;

	private ArrayList<Fecha> dias;

	public Pelicula(String codigoPelicula, String titulo, String sipnosis,
			String genero, int duracion, String edadRecomendada,
			String nombreSala, char formatoTresD) {


		dias = new ArrayList<Fecha>();

		this.codigoPelicula = codigoPelicula;
		this.setTitulo(titulo);
		this.setSipnosis(sipnosis);
		this.setGenero(genero);
		this.setDuracion(duracion);
		this.setNombreSala(nombreSala);
		this.setFormatoTresD(formatoTresD);
		this.setEdadRecomendada(edadRecomendada);

	}

	public ArrayList<Sesion> getSesiones(String fecha) {
		for (Fecha f : dias) {
			if (f.getFecha().equals(fecha))
				;
			return f.getHoras();
		}
		return null;
	}

	public void setSesiones(ArrayList<String> sesiones) {
	}

	public void annadirSesion(Fecha a) {
		dias.add(a);
	}

	public String getHorarios() {
		return horarios;
	}

	public ArrayList<Fecha> getDias() {
		return dias;
	}

	public void setDias(ArrayList<Fecha> dias) {
		this.dias = dias;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public String getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public String getCodigoPelicula() {
		return codigoPelicula;
	}

	public void setCodigoPelicula(String codigoPelicula) {
		this.codigoPelicula = codigoPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSipnosis() {
		return sipnosis;
	}

	public void setSipnosis(String sipnosis) {
		this.sipnosis = sipnosis;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String sala) {
		this.nombreSala = sala;
	}

	public char getFormatoTresD() {
		return formatoTresD;
	}

	public void setFormatoTresD(char formatoTresD) {
		this.formatoTresD = formatoTresD;
	}

	public void reservar(String fecha, String hora, int fila, int butaca) {

		for (Fecha day : dias) {
			if (day.getFecha().equals(fecha)) {
				day.reservarPeli(hora, fila, butaca);
			}
		}

	}
	public void comprarButaca(String fecha, String hora) {

		for (Fecha day : dias) {
			if (day.getFecha().equals(fecha)) {
				day.comprarButaca(hora);
			}
		}

	}
	/*
	 * Recorremos el array de fechas, y llamamos al método de sesion -
	 * getFecha() -
	 */
	public Entrada[][] mostrarButacas(String fecha, String sesion) {
		for (Fecha f : dias) {
			if (f.getFecha().equals(fecha)) {

				return f.mostarButacas(sesion);
			}
		}
		return null;
	}
}
