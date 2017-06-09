package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cartelera {

	private int Nentradas;
	private String nombreCine;
	private float precioEntradaComun;
	private float descuentoJubilado;
	private float descuentoCumple;
	private float suplementoTresd;

	public ArrayList<Pelicula> relacionPeliculas = null;
	public ArrayList<Entrada> entradasSeleccionada = null;

	public Cartelera() {

		entradasSeleccionada = new ArrayList<Entrada>();
		relacionPeliculas = new ArrayList<Pelicula>();
		leerFichero();
		leerPrecios();
	}

	public boolean suplementoTresD(String codPeli) {
		for (Pelicula p : relacionPeliculas) {
			if (p.getFormatoTresD() == 'S') {
				return true;
			}
			
		}
		return false;
	
}

	public Pelicula buscarPeliPorCod(String c) {
		for (Pelicula p : relacionPeliculas) {
			if (p.getCodigoPelicula().equals(c)) {
				return p;
			}
		}

		return null;

	}

	public float getSuplementoTresd() {
		return suplementoTresd;
	}

	public void setSuplementoTresd(float suplementoTresd) {
		this.suplementoTresd = suplementoTresd;
	}

	public float getPrecioEntradaComun() {
		return precioEntradaComun;
	}

	public void setPrecioEntradaComun(float precioEntrada) {
		this.precioEntradaComun = precioEntrada;
	}

	public float getDescuentoJubilado() {
		return descuentoJubilado;
	}

	public void setDescuentoJubilado(float descuentoJubilado) {
		this.descuentoJubilado = descuentoJubilado;
	}

	public float getDescuentoCumple() {
		return descuentoCumple;
	}

	public void setDescuentoCumple(float descuentoCumple) {
		this.descuentoCumple = descuentoCumple;
	}

	public void leerPrecios() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					"files/precios.dat"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(";");
				// CINEMA TONE;8.40;2;2.60;-3

				nombreCine = trozos[0];
				precioEntradaComun = Float.valueOf(trozos[1]);
				suplementoTresd = Float.valueOf(trozos[2]);
				descuentoCumple = Float.valueOf(trozos[3]);
				descuentoJubilado = Float.valueOf(trozos[4]);

			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			// JOptionPane.showMessageDialog(null,
			// "El archivo no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}

	}

	public void leerFichero() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					"files/cartelera.dat"));
			while (fichero.ready()) {
				Pelicula p = null;
				linea = fichero.readLine();

				String[] trozos = linea.split(";");

				String[] trozosDias = trozos[6].split("%");
				String[] trozosHoras = trozos[7].split("%");

				// public Peliculas (String codigoPelicula 0, String titulo
				// 1,String sipnosis 2, String genero 3,
				// int duracion 4,int edadRecomendada 5,String nombreSala 6,
				// char formatoTresD 7){

				// código película 0;título 1;sinopsis 2;género 3;duración
				// 4;edad recomendada 5;fechas
				// proyección 6;horarios 7 ;sala de proyección 8;formato 3D 9
				//

				p = new Pelicula(trozos[0], trozos[1], trozos[2], trozos[3],
						Integer.parseInt(trozos[4]), trozos[5], trozos[8],
						trozos[9].charAt(0));

				for (int i = 0; i < trozosDias.length; i++) {

					Fecha f = new Fecha(trozosDias[i]);
					for (int j = 0; j < trozosHoras.length; j++) {
						Sesion s = new Sesion(trozosHoras[j]);
						f.annadirHoras(s);
					}
					p.annadirSesion(f);
				}
				relacionPeliculas.add(p);
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			// JOptionPane.showMessageDialog(null,"El archivo no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}

	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public int getNentradas() {
		return Nentradas;
	}

	public void setNentradas(int nentradas) {
		Nentradas = nentradas;
	}

	public void anadirEntrada(int fila, int butaca, String tituloPeli) {
		Entrada e = new Entrada(tituloPeli, fila, butaca);
		entradasSeleccionada.add(e);
	}

	public String infoEntrada(String nombreCine, String titulo, String sala,
			String sesion, String fecha) {
		String cadena = "";
		for (int i = 0; i < entradasSeleccionada.size(); i++) {
			cadena += getNombreCine().toUpperCase() + "\n" + titulo + "\n"
					+ sala + "   " + "Sesión: " + sesion + "   " + "Fecha: "
					+ fecha + "\n" + "Fila: "
					+ entradasSeleccionada.get(i).getFila() + "   "
					+ "Columna: " + entradasSeleccionada.get(i).getButaca()
					+ "\n-------------------\n";
		}

		return cadena;
	}

	/*
	 * Método para grabar el fichero String dni, el nombre que quedara de
	 * fichero String cadena, cadena a grabar en fichero
	 */

	public int grabarFichero(String nombreCine, String TituloPeli, String sala,
			String sesion, String fecha, String Dni) {
		String nombreFichero = "files/" + Dni + ".dat";
		String cadena = infoEntrada(getNombreCine(), TituloPeli, sala, sesion,
				fecha);
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(
					nombreFichero, true));
			fichero.write(cadena + "\n");
			fichero.close();
			return (0);
		} catch (FileNotFoundException fnfe) {
			// System.out.println("El archivo no se ha podido grabar");
			return (-1);
		} catch (IOException ioe) {
			new RuntimeException("Error de salida.");
			return (-2);
		}
	}

	public Entrada[][] mostrarButacas(String codigo, String fecha, String sesion) {
		for (Pelicula p : relacionPeliculas) {
			if (p.getCodigoPelicula().equals(codigo)) {
				return p.mostrarButacas(fecha, sesion);

			}
		}

		return null;

	}

	public ArrayList<Fecha> getFechas(String codPeli) {
		for (Pelicula p : relacionPeliculas) {
			if (p.getCodigoPelicula().equals(codPeli)) {
				return p.getDias();
			}
		}
		return null;

	}

	public ArrayList<Sesion> getSesiones(String codigoPeli, String fecha) {
		for (Pelicula p : relacionPeliculas) {
			if (p.getCodigoPelicula().equals(codigoPeli))
				return p.getSesiones(fecha);
		}
		return null;
	}

	public void reservarBucata(String codigo, String fecha, String hora,
			int fila, int butaca) {
		for (Pelicula pe : relacionPeliculas) {
			if (pe.getCodigoPelicula().equals(codigo)) {
				pe.reservar(fecha, hora, fila, butaca);
			}
		}
	}

	public void comprarButaca(String codigo, String fecha, String hora) {
		for (Pelicula pe : relacionPeliculas) {
			if (pe.getCodigoPelicula().equals(codigo)) {
				pe.comprarButaca(fecha, hora);
			}
		}
	}

	public Pelicula buscar(String codigo) {

		for (Pelicula pe : relacionPeliculas) {
			if (pe.getCodigoPelicula().equals(codigo))

				return pe;
		}
		return null;
	}

	public List<Pelicula> getRelacionPeliculas() {
		return relacionPeliculas;
	}

	public void setRelacionPeliculas(ArrayList<Pelicula> relacionPeliculas) {
		this.relacionPeliculas = relacionPeliculas;
	}

}
