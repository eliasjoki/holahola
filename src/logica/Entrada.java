package logica;

public class Entrada {

	private boolean estado;
	// falso si está libre, true caso contrario
	private boolean comprada;
	// true si comprada, else caso contrario
	private int fila;
	private int butaca;
	private String tituloPeli;
	
	public Entrada(int fila, int butaca) {
		super();
		this.comprada = false;
		this.estado = false;
		this.fila = fila;
		this.butaca = butaca;
	}
	public Entrada(String tituloPeli,int fila, int butaca){
		this.fila = fila;
		this.butaca = butaca;
		this.tituloPeli = tituloPeli;
		
	}
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getButaca() {
		return butaca;
	}

	public void setButaca(int butaca) {
		this.butaca = butaca;
	}
	public String getTituloPeli() {
		return tituloPeli;
	}
	public void setTituloPeli(String tituloPeli) {
		this.tituloPeli = tituloPeli;
	}
	public boolean isComprada() {
		return comprada;
	}
	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}

}
