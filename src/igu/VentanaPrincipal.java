package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import logica.Cartelera;
import logica.Entrada;
import logica.Fecha;
import logica.Pelicula;
import logica.Sesion;

import org.jvnet.substance.SubstanceLookAndFeel;

import contrib.ch.randelshofer.quaqua.colorchooser.RGBChooser;

import java.awt.event.InputEvent;

import javax.swing.JSeparator;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JRadioButton;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ModeloNoEditable modeloTabla; // para pasarselo al jlist por
											// parametro
	private Cartelera car;

	private JPanel contentPane;
	private JPanel pnNorte;
	private JPanel pnCentro;
	private JLabel lblTitulo;
	private JTabbedPane tPpaneles;
	private JPanel pnCartelera;
	private JPanel pnSur;
	private JPanel pnAsientos;
	private JScrollPane acPTabla;
	private JTable tablaCartelera;
	private JPanel pnInfoPeli;
	private JScrollPane aPInfo;
	private JTextPane txtPInfoPeli;
	private JPanel pnSesionFoto;
	private JPanel pnFoto;
	private JPanel pnSesionDia;
	private JLabel lblFoto;
	private JComboBox<String> combFecha;
	private JButton btnContinuar;
	private JPanel pnbtones;
	private JButton btnAtras;
	private JLabel lblAsientoSelecc;
	private JPanel pnAsientosNumerados;
	private JButton btnBtfilacinco_0;
	private JButton btnBtfilacinco_1;
	private JButton btnBtfilacinco_2;
	private JButton btnBtfilacinco_3;
	private JButton btnBtfilacinco_4;
	private JButton btnBtfilacinco_5;
	private JButton btnFilaCinco_0;
	private JButton btnFilaCinco_1;
	private JButton btnFilaCinco_2;
	private JButton btnBtnfilaCinco_3;
	private JButton btnBtnfilaCinco_4;
	private JButton btnBtnfilaCinco_5;
	private JButton btnFilacuatro_0;
	private JButton btnFilacuatro_1;
	private JButton btnFilacuatro_2;
	private JButton btnFilacuatro_3;
	private JButton btnFilacuatro_4;
	private JButton btnFilacuatro_5;
	private JButton btnFilatres;
	private JButton btnFilatres_1;
	private JButton btnFilatres_2;
	private JButton btnFilatres_3;
	private JButton btnFilatres_4;
	private JButton btnFilatres_5;
	private JButton btnFilauno;
	private JButton btnFilauno_1;
	private JButton btnFilauno_2;
	private JButton btnFilauno_3;
	private JButton btnFilauno_4;
	private JButton btnFilauno_5;
	private JPanel pnAsientosSelecc;
	private JScrollPane cPAsientosPeli;
	private JTextPane tPPeliSelecc;
	private String[] nombreColumnas = { "Codigo pelicula", "Título", "Género",
			"Duración", "Formato 3D", "Edad recomendada" };
	private JComboBox<String> combSesion;
	private JScrollPane sPSesion;
	private JTextPane tPSesion;
	private JPanel pnTipo;
	private JPanel pnEntradas;
	private JTextField tFNEntradas;
	private JLabel lblNEntradasJunilados;
	private JLabel lblPackCumpleaos;
	private JLabel lblNmeroDeEntras;
	private JMenuBar menuBar;
	private JMenu mnOpciones;
	private JMenuItem mntmNuevaCompra;
	private JMenuItem mntmSalir;
	private JPanel pnCombosFechSes;
	private JScrollPane sPAsientoSelecc;
	private JTextPane tpAsientoSelecc;
	private JPanel pnFiltroGenero;
	private JCheckBox cbAccion;
	private JCheckBox cbAventura;
	private JCheckBox cbBelica;
	private JCheckBox cbComedia;
	private JCheckBox cbTerror;
	private JCheckBox cbDrama;
	private JCheckBox cbTresD;
	private JCheckBox cbOtros;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDe;
	private JMenuItem mntmContenidos;
	private String codPeli;
	private ActionEventoBotones ae;
	private JPanel pnLeyenda;
	private JButton btLeyendaLibre;
	private JButton btLeyendaOcupado;
	private String tituloPeli;
	private JPanel pnPrecio;
	private JPanel pnMostrarPrecio;
	private JLabel lglPrecio;
	private JTextField tfTotalaPagar;
	private int entradasMayores;
	private int entradasCumple;
	private JSeparator sptOpciones;
	private JPanel pnMayores;
	private JPanel pnCumple;
	private JTextField tFMayores;
	private JPanel pnAumentar_Disminuir_Mayor;
	private JButton btnMasMayor;
	private JButton btnMenosMayor;
	private JPanel pnAum_dism_cumpl;
	private JButton btnMasCumpl;
	private JButton btnMenosCumple;
	private JTextField tfCumple;
	private JPanel pnEdad;
	private JRadioButton rdbTodos;
	private JRadioButton rdbMasDieciseis;
	private JRadioButton rdbMasDieciocho;
	private JRadioButton rdbMasDoce;
	private JButton btnOcupado;
	private DefaultComboBoxModel<String> modeloFecha = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modeloSesion = new DefaultComboBoxModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel
							.setSkin("org.jvnet.substance.skin.RavenSkin");
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/img/iconocine.png")));
		car = new Cartelera(); // Cartelera
		ae = new ActionEventoBotones();
		setTitle("CinemaTone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1187, 758);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSur(), BorderLayout.SOUTH);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbTodos);
		group.add(rdbMasDieciseis);
		group.add(rdbMasDieciocho);
		group.add(rdbMasDoce);

		inicializar();
		cargaAyuda();
		asociarBotones();
	}

	private void cargaAyuda() {

		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e) {
			System.out.println("Ayuda no encontrada");
			return;
		}

		HelpBroker hb = hs.createHelpBroker();

		hb.enableHelpKey(getRootPane(), "introduccion", hs); // introduccion
																// definir en
																// map
		hb.enableHelpOnButton(mntmContenidos, "introduccion", hs);
		// hb.enableHelp(componente, "alias html concreto", hs);

	}

	public int getEntradasMayores() {
		return entradasMayores;
	}

	public void setEntradasMayores(int entradasMayores) {
		this.entradasMayores = entradasMayores;
	}

	public int getEntradasCumple() {
		return entradasCumple;
	}

	public void setEntradasCumple(int entradasCumple) {
		this.entradasCumple = entradasCumple;
	}

	protected void mostrarPeliculas() {

		modeloTabla.getDataVector().clear();

		añadirFilas(cbAccion.isSelected(), cbAventura.isSelected(),
				cbBelica.isSelected(), cbComedia.isSelected(),
				cbTerror.isSelected(), cbDrama.isSelected(),
				cbTresD.isSelected(), cbOtros.isSelected(),
				rdbTodos.isSelected(), rdbMasDieciseis.isSelected(),
				rdbMasDieciocho.isSelected(), rdbMasDoce.isSelected());
		// necesrio para repintar la tabla
		// (especialmete cuando se quede vacía)
		modeloTabla.fireTableDataChanged();// para que se repinte cuando este
											// vacia del todo

	}

	private void modificarTabla(JTable table) {
		DefaultTableCellRenderer alinearTexto = new DefaultTableCellRenderer();
		alinearTexto.setHorizontalAlignment(SwingConstants.CENTER);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);

		TableColumn columna = tablaCartelera.getColumn(nombreColumnas[0]);
		columna.setMinWidth(0);
		columna.setMaxWidth(0);

		TableColumn columna1 = tablaCartelera.getColumn(nombreColumnas[1]);
		columna1.setMinWidth(300);
		columna1.setMaxWidth(325);

		table.getTableHeader().setPreferredSize(new Dimension(32, 32));
		TableColumn columna5 = tablaCartelera.getColumn(nombreColumnas[5]);

		columna5.setMinWidth(200);
		columna5.setMaxWidth(225);
		columna5.setCellRenderer(alinearTexto);

		table.setShowGrid(true);
		table.setRowHeight(32);

	}

	private void mostrarSinFiltros() {

		// adaptarImagen(lblFoto, "/img/carrete.jpg");
		/*
		 * lblFoto.setIcon(new ImageIcon(VentanaPrincipal.class
		 * .getResource("/img/carrete.jpg")));
		 */

		modeloTabla.getDataVector().clear();
		modeloTabla.fireTableDataChanged();// para que se repinte cuando este

		Object[] nuevaFila = new Object[6];
		java.util.List<Pelicula> relacionPelis = car.getRelacionPeliculas();
		for (Pelicula m : relacionPelis) {

			nuevaFila[0] = m.getCodigoPelicula();
			nuevaFila[1] = m.getTitulo();
			nuevaFila[2] = m.getGenero();
			nuevaFila[3] = m.getDuracion();
			nuevaFila[4] = m.getFormatoTresD();
			nuevaFila[5] = m.getEdadRecomendada();

			modeloTabla.addRow(nuevaFila);
		}
	}

	private void añadirFilas(boolean cbAccion, boolean cbAventura,
			boolean cbBelica, boolean cbComedia, boolean cbTerror,
			boolean cbDrama, boolean cbTresD, boolean cbOtros,
			boolean rdbTodos, boolean rdbDseis, boolean rdbOcho, boolean rdbDoce) {

		Object[] nuevaFila = new Object[6];
		java.util.List<Pelicula> relacionPelis = car.getRelacionPeliculas();

		for (Pelicula m : relacionPelis) {
			System.out.println(m.getEdadRecomendada());
			if (((cbAccion && m.getGenero().contains("Acción"))
					|| (cbAventura && m.getGenero().contains("Aventura"))
					|| (cbBelica && m.getGenero().contains("Bélica"))
					|| (cbComedia && m.getGenero().contains("Comedia"))
					|| (cbDrama && m.getGenero().contains("Drama"))
					|| (cbTerror && m.getGenero().contains("Terror")) || (cbOtros && m
					.getGenero().contains("Otros")))
					&& ((cbTresD && m.getFormatoTresD() == 'S') || (!cbTresD && m
							.getFormatoTresD() == 'N'))
					&& ((rdbTodos && String.valueOf(m.getEdadRecomendada())
							.equals("Todos los públicos"))
							|| (rdbDseis && String.valueOf(
									m.getEdadRecomendada()).equals("+16"))
							|| (rdbOcho && String.valueOf(
									m.getEdadRecomendada()).equals("+18")) || rdbDoce
							&& String.valueOf(m.getEdadRecomendada()).equals(
									"+12"))) {

				nuevaFila[0] = m.getCodigoPelicula();
				nuevaFila[1] = m.getTitulo();
				nuevaFila[2] = m.getGenero();
				nuevaFila[3] = m.getDuracion();
				nuevaFila[4] = m.getFormatoTresD();
				nuevaFila[5] = m.getEdadRecomendada();

				modeloTabla.addRow(nuevaFila);
			}
		}

	}

	private void asociarBotones() {

		int cont = 0;

		Component botones[] = pnAsientosNumerados.getComponents();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				JButton uno = (JButton) botones[cont];
				uno.setActionCommand(i + "-" + j);
				uno.addActionListener(ae);
				cont++;

			}
		}

	}

	// TODO: ACTIONEVENTBONOTES
	class ActionEventoBotones implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton but = (JButton) e.getSource();
			String cadema = but.getActionCommand();
			String trozos[] = cadema.split("-");
			int fila = Integer.parseInt(trozos[0]);
			int butaca = Integer.parseInt(trozos[1]);
			car.reservarBucata(codPeli, (String) combFecha.getSelectedItem(),
					(String) combSesion.getSelectedItem(), fila, butaca);
			mostrarEstadoAsientos();
			System.out.println("fila :" + fila + " butaca :" + butaca);
			car.anadirEntrada(fila, butaca, tituloPeli);
		}
	}

	// TODO: adaptarImagen

	private void adaptarImagen(JLabel label, String rutaImagen) {
		Image imgOriginal = null;

		// setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/iconocine.png")));
		try {
			imgOriginal = new ImageIcon(getClass().getResource(rutaImagen))
					.getImage();
		} catch (Exception e) {
			imgOriginal = new ImageIcon(getClass().getResource(rutaImagen))
					.getImage();
		}
		Image imgEscalada = imgOriginal.getScaledInstance(
				(int) (label.getWidth()), (int) (label.getHeight()),
				Image.SCALE_FAST);

		label.setIcon(new ImageIcon(imgEscalada));

		label.setDisabledIcon(new ImageIcon(imgEscalada));
	}

	// TODO: inicializar
	private void inicializar() {
		lblFoto.setIcon(new ImageIcon(VentanaPrincipal.class
				.getResource("/img/cinema.jpg")));
		mostrarSinFiltros();
		txtPInfoPeli.setText("");
		tpAsientoSelecc.setText("");
		tPPeliSelecc.setText("");
		tPSesion.setText("");
		desBloquearFiltros();
		combFecha.setEnabled(false);
		combSesion.setEnabled(false);
		tfTotalaPagar.setText("");
		tFNEntradas.setText(String.valueOf(0));
		tfCumple.setText(String.valueOf(0));

		lblTitulo.setText(car.getNombreCine());
		lblTitulo.setToolTipText(car.getNombreCine());

		tPpaneles.setSelectedIndex(0);
		tPpaneles.setEnabledAt(0, true);

		modificarTabla(tablaCartelera);

		mostrarSinFiltros();

		mostrarFecha("");

		mostrarSesion("");

		setLocationRelativeTo(contentPane);

	}

	// TODO: mostrarFecha
	private void mostrarFecha(String cod) {

		ArrayList<Fecha> fechas = car.getFechas(cod);
		modeloFecha.removeAllElements();
		modeloFecha.addElement("ELEGIR FECHA");
		if (fechas != null) {
			for (Fecha f : fechas) {
				modeloFecha.addElement(f.getFecha());

			}
		}
		combFecha.setModel(modeloFecha);

	}

	public void mostrarSesion(String diaSelecc) {
		ArrayList<Sesion> horas = car.getSesiones(codPeli, diaSelecc);
		modeloSesion.removeAllElements();
		modeloSesion.addElement("SELECCIONE SESIÓN");
		if (horas != null) {
			for (Sesion d : horas) {
				modeloSesion.addElement(d.getHora());

			}
		}
		combSesion.setModel(modeloSesion);
	}

	/*
	 * 
	 */// TODO mostrarEstadoAsientos

	public void mostrarEstadoAsientos() {
		int contadorSi = 0;
		int con = 0;

		Entrada[][] asientos = car.mostrarButacas(codPeli,
				(String) combFecha.getSelectedItem(),
				(String) combSesion.getSelectedItem());
		Component bt[] = pnAsientosNumerados.getComponents();
		if (asientos != null) {
			for (int i = 0; i < asientos.length; i++) {
				for (int j = 0; j < asientos[0].length; j++) {
					Entrada entrada = asientos[i][j];
					JButton but = (JButton) bt[con];

					if (entrada.isEstado() == true) {// reservada
						but.setBackground(Color.BLACK);
						contadorSi++;

						if (entrada.isComprada() == true) {

							but.setBackground(Color.RED);
							but.setEnabled(false);
							contadorSi--;
						}
					}

					else {

						but.setBackground(Color.lightGray);
						but.setEnabled(true);

					}

					car.setNentradas(contadorSi);

					con++;
					tFNEntradas.setText(String.valueOf(contadorSi));

					if (contadorSi >= 1) {
						btnContinuar.setEnabled(true); // para llegar al panel
														// de entradas

					} else
						btnContinuar.setEnabled(false);

					System.out.println("i: " + i + " J: " + j + " "
							+ entrada.isEstado());
					System.out.println("Nº but totales :" + con + "----"
							+ "Nº butacas ocupadas:" + contadorSi);
				}
			}
		}
	}

	private void mostrarEntradaReservada() {
		int control = tablaCartelera.getSelectedRow();
		if (control != -1) {
			codPeli = (String) tablaCartelera.getValueAt(control, 0);

			tPSesion.setText(car.buscar(codPeli).getTitulo() + "\n"
					+ combFecha.getSelectedItem() + "\t"
					+ combSesion.getSelectedItem());
			tPPeliSelecc.setText(car.buscar(codPeli).getTitulo() + "\t"
					+ combFecha.getSelectedItem() + "\t"
					+ combSesion.getSelectedItem());
			if (!(combSesion.getSelectedItem() == null)) {
				btnContinuar.setEnabled(true); // para llegar al panel asientos
			}
		}
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setLayout(new BorderLayout(0, 0));
			pnNorte.add(getLblTitulo());
			pnNorte.add(getPnFiltroGenero(), BorderLayout.WEST);
		}
		return pnNorte;
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(new BorderLayout(0, 0));
			pnCentro.add(getTPpaneles());
		}
		return pnCentro;
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("");
			lblTitulo.setPreferredSize(new Dimension(40, 14));
			lblTitulo.setFont(new Font("Castellar", Font.BOLD, 21));
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTitulo;
	}

	private JTabbedPane getTPpaneles() {
		if (tPpaneles == null) {
			tPpaneles = new JTabbedPane(JTabbedPane.TOP);
			tPpaneles.setEnabled(false);
			tPpaneles.addTab("Cartelera", null, getPnCartelera(), null);
			tPpaneles.addTab("Asientos", null, getPnAsientos(),
					"Seleccione su asiento");
			tPpaneles.addTab("Tipo entrada", null, getPnTipo(), null);
			tPpaneles.setEnabledAt(2, true);
			tPpaneles.addTab("Total a pagar", null, getPnPrecio(), null);
		}
		return tPpaneles;
	}

	private JPanel getPnCartelera() {
		if (pnCartelera == null) {
			pnCartelera = new JPanel();
			pnCartelera.setFont(new Font("Comic Sans MS", Font.PLAIN, 27));
			pnCartelera.setToolTipText("Seleccione una pel\u00EDcula");
			pnCartelera.setLayout(new BorderLayout(0, 0));
			pnCartelera.add(getAcPTabla(), BorderLayout.CENTER);
			pnCartelera.add(getPnInfoPeli(), BorderLayout.SOUTH);
			pnCartelera.add(getPnSesionFoto(), BorderLayout.EAST);
		}
		return pnCartelera;
	}

	private JPanel getPnSur() {
		if (pnSur == null) {
			pnSur = new JPanel();
			pnSur.setPreferredSize(new Dimension(250, 50));
			pnSur.setLayout(new BorderLayout(0, 0));
			pnSur.add(getPnbtones(), BorderLayout.EAST);
		}
		return pnSur;
	}

	private JPanel getPnAsientos() {
		if (pnAsientos == null) {
			pnAsientos = new JPanel();
			pnAsientos.setLayout(new BorderLayout(0, 0));
			pnAsientos.add(getLblAsientoSelecc(), BorderLayout.NORTH);
			pnAsientos.add(getPanel_1(), BorderLayout.CENTER);
			pnAsientos.add(getPnAsientosSelecc(), BorderLayout.SOUTH);
		}
		return pnAsientos;
	}

	private JScrollPane getAcPTabla() {
		if (acPTabla == null) {
			acPTabla = new JScrollPane();

			acPTabla.setFont(new Font("Times New Roman", Font.BOLD, 20));
			acPTabla.setViewportView(getTablaCartelera());
		}
		return acPTabla;
	}

	// TODO TABLA

	private JTable getTablaCartelera() {
		if (tablaCartelera == null) {
			modeloTabla = new ModeloNoEditable(nombreColumnas, 1);

			tablaCartelera = new JTable(modeloTabla);
			tablaCartelera.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			centrar_datos(2);
			centrar_datos(3);
			centrar_datos(4);
			izq_datos(1);

			tablaCartelera.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					codPeli = (String) tablaCartelera.getValueAt(
							tablaCartelera.getSelectedRow(), 0);
					tituloPeli = (String) tablaCartelera.getValueAt(
							tablaCartelera.getSelectedRow(), 1);

					if (arg0.getClickCount() == 1) {
						adaptarImagen(lblFoto, "/img/" + codPeli + ".jpg");
						txtPInfoPeli.setText(car.buscar(codPeli).getSipnosis());

						mostrarFecha(codPeli);
						mostrarEntradaReservada();

					}
					btnContinuar.setEnabled(false);
					combFecha.setEnabled(true);
					btnAtras.setEnabled(false);

				}
			});
			tablaCartelera.setToolTipText("¡Seleccione una película!");

			tablaCartelera.setFont(new Font("Times New Roman", Font.BOLD, 20));

		}
		return tablaCartelera;
	}

	/*
	 * Nota: Alinear los datos de la tabla
	 */

	// Centrado
	public void centrar_datos(int col) {
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
		tablaCartelera.getColumnModel().getColumn(col)
				.setCellRenderer(modelocentrar);
	}

	// Izquierda
	public void izq_datos(int col) {
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.LEFT);
		tablaCartelera.getColumnModel().getColumn(col)
				.setCellRenderer(modelocentrar);
	}

	// Derecha
	public void der_datos(int col) {
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT);
		tablaCartelera.getColumnModel().getColumn(col)
				.setCellRenderer(modelocentrar);
	} // Fin: Alinear los datos de la tabla

	// TODO CONTINUAR

	public void continuar() {

		if (tPpaneles.getSelectedIndex() == 0) {
			tPpaneles.setEnabledAt(1, true);
			tPpaneles.setEnabledAt(2, false);
			tPpaneles.setEnabledAt(3, false);
			tPpaneles.setSelectedIndex(1);
			tPpaneles.setEnabledAt(0, false);

			btnAtras.setEnabled(false);
			// btnContinuar.setEnabled(true);
			bloquearFiltros();

		} else if (tPpaneles.getSelectedIndex() == 1) {
			tPpaneles.setEnabledAt(2, true);
			tPpaneles.setEnabledAt(1, false);
			tPpaneles.setEnabledAt(3, false);
			tPpaneles.setSelectedIndex(2);
			tPpaneles.setEnabledAt(0, false);

			btnContinuar.setEnabled(true);
			btnAtras.setEnabled(true);
			setEntradasCumple(0);
			setEntradasMayores(0);
			tfCumple.setText("0");
			tFMayores.setText("0");
			bloquearFiltros();

		} else if (tPpaneles.getSelectedIndex() == 2) {
			tPpaneles.setEnabledAt(0, false);

			tPpaneles.setEnabledAt(1, false);
			tPpaneles.setEnabledAt(3, false);
			tPpaneles.setSelectedIndex(3);
			calcularPrecioEntrada(Integer.valueOf(tFNEntradas.getText()));
			tPpaneles.setEnabledAt(3, true);

		} else if (tPpaneles.getSelectedIndex() == 3) {
			tPpaneles.setEnabledAt(3, true);
			tPpaneles.setEnabledAt(1, false);
			tPpaneles.setEnabledAt(3, false);
			tPpaneles.setSelectedIndex(3);
			tPpaneles.setEnabledAt(0, false);
			btnAtras.setEnabled(true);
			finalizar();

		}

	}

	/*
	 * Para acabar: pedimos DNI grabamos fichero probamos el fallo de tarjeta o
	 * no. inicializamos la aplicación para la siguiente compra.
	 */
	private void calcularPrecioEntrada(int entradasTotales) {
		DecimalFormat f = new DecimalFormat("#.00");
		float precioTotal = 0;

		int jubilados = Integer.parseInt(tFMayores.getText());
		int cumple = Integer.parseInt(tfCumple.getText());

		if (car.suplementoTresD(codPeli) == true) {
			precioTotal = (entradasTotales * car.getPrecioEntradaComun() + entradasTotales
					* car.getSuplementoTresd())
					+ (car.getDescuentoJubilado() * jubilados)
					+ (car.getDescuentoCumple() * cumple);
		} else {
			precioTotal = (entradasTotales * car.getPrecioEntradaComun())
					+ (car.getDescuentoJubilado() * jubilados)
					+ (car.getDescuentoCumple() * cumple);
		}

		String result = f.format(precioTotal);

		tfTotalaPagar.setText(result);
		btnContinuar.setEnabled(true);
		System.out.println("Jubis : " + jubilados + "cumple :" + cumple
				+ "Nº entradas " + entradasTotales + "Precio total :"
				+ precioTotal);
	}

	private void finalizar() {
		JOptionPane.showMessageDialog(null, "Inserte tarjeta y pulse aceptar");

		if (fallarTarjetaAleatorio() == false) {

			String dni = JOptionPane
					.showInputDialog("Introduzca su DNI para finalizar" + "\n"
							+ "Disfrute de la película");
			if (dni != null) {

				car.grabarFichero(car.getNombreCine(), tituloPeli, car
						.buscarPeliPorCod(codPeli).getNombreSala(),
						(String) combSesion.getSelectedItem(),
						(String) combFecha.getSelectedItem(), dni);

			}
		}
		car.comprarButaca(codPeli, (String) combFecha.getSelectedItem(),
				(String) combSesion.getSelectedItem());

		inicializar();
	}

	private boolean fallarTarjetaAleatorio() {

		Random rd = new Random();
		boolean fallo = false;
		int numeroAleatorio = rd.nextInt(35);

		if (numeroAleatorio == 1) {
			fallo = true;
			JOptionPane.showMessageDialog(null,
					"Error de tarjeta, pruebe otra vez");

		}

		return fallo;

	}

	protected void retroceder() {

		if (tPpaneles.getSelectedIndex() == 3) {
			tPpaneles.setEnabledAt(2, true);
			tPpaneles.setEnabledAt(1, false);
			tPpaneles.setSelectedIndex(2);
			tPpaneles.setEnabledAt(0, false);

			btnAtras.setEnabled(true);

			bloquearFiltros();

		} else if (tPpaneles.getSelectedIndex() == 2) {
			tPpaneles.setEnabledAt(1, true);
			tPpaneles.setEnabledAt(2, false);
			tPpaneles.setSelectedIndex(1);
			tPpaneles.setEnabledAt(0, false);

			btnAtras.setEnabled(true);

			bloquearFiltros();

		} else if (tPpaneles.getSelectedIndex() == 1) {
			tPpaneles.setEnabledAt(0, true);
			tPpaneles.setEnabledAt(1, false);
			tPpaneles.setSelectedIndex(0);
			tPpaneles.setEnabledAt(2, false);

			btnAtras.setEnabled(true);

			desBloquearFiltros();

		} else if (tPpaneles.getSelectedIndex() == 0) {
			tPpaneles.setEnabledAt(0, true);
			tPpaneles.setEnabledAt(1, false);
			tPpaneles.setSelectedIndex(0);
			tPpaneles.setEnabledAt(2, false);
			btnAtras.setEnabled(false);
			desBloquearFiltros();

		}

	}

	private void bloquearFiltros() {
		cbAccion.setEnabled(false);
		cbAventura.setEnabled(false);
		cbBelica.setEnabled(false);
		cbComedia.setEnabled(false);
		cbDrama.setEnabled(false);
		cbOtros.setEnabled(false);
		cbTerror.setEnabled(false);
		cbTresD.setEnabled(false);

	}

	private void desBloquearFiltros() {
		cbAccion.setEnabled(true);
		cbAventura.setEnabled(true);
		cbBelica.setEnabled(true);
		cbComedia.setEnabled(true);
		cbDrama.setEnabled(true);
		cbOtros.setEnabled(true);
		cbTerror.setEnabled(true);
		cbTresD.setEnabled(true);

	}

	private JPanel getPnInfoPeli() {
		if (pnInfoPeli == null) {
			pnInfoPeli = new JPanel();
			pnInfoPeli.setLayout(new BorderLayout(0, 0));
			pnInfoPeli.add(getAPInfo(), BorderLayout.CENTER);
		}
		return pnInfoPeli;
	}

	private JScrollPane getAPInfo() {
		if (aPInfo == null) {
			aPInfo = new JScrollPane();
			aPInfo.setPreferredSize(new Dimension(80, 80));
			aPInfo.setMinimumSize(new Dimension(30, 30));
			aPInfo.setMaximumSize(new Dimension(400, 400));
			aPInfo.setColumnHeaderView(getTxtPInfoPeli());
		}
		return aPInfo;
	}

	private JTextPane getTxtPInfoPeli() {
		if (txtPInfoPeli == null) {
			txtPInfoPeli = new JTextPane();
			txtPInfoPeli.setBorder(new TitledBorder(null, "Sinopsis",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(47,
							79, 79)));
			txtPInfoPeli.setToolTipText("Sinopsis de la pel\u00EDcula");
			txtPInfoPeli.setOpaque(false);
			txtPInfoPeli
					.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtPInfoPeli.setFont(new Font("Times New Roman", Font.BOLD, 18));
			txtPInfoPeli.setEditable(false);
		}
		return txtPInfoPeli;
	}

	private JPanel getPnSesionFoto() {
		if (pnSesionFoto == null) {
			pnSesionFoto = new JPanel();
			pnSesionFoto.setMaximumSize(new Dimension(1000, 700));
			pnSesionFoto.setPreferredSize(new Dimension(300, 500));
			pnSesionFoto.setFont(new Font("Sylfaen", Font.PLAIN, 36));
			pnSesionFoto.setLayout(new BorderLayout(0, 0));
			pnSesionFoto.add(getPnFoto(), BorderLayout.CENTER);
			pnSesionFoto.add(getPnSesionDia(), BorderLayout.SOUTH);
		}
		return pnSesionFoto;
	}

	private JPanel getPnFoto() {
		if (pnFoto == null) {
			pnFoto = new JPanel();
			pnFoto.setPreferredSize(new Dimension(400, 400));
			pnFoto.setLayout(new BorderLayout(0, 0));
			pnFoto.add(getLblFoto(), BorderLayout.CENTER);
		}
		return pnFoto;
	}

	private JPanel getPnSesionDia() {
		if (pnSesionDia == null) {
			pnSesionDia = new JPanel();
			pnSesionDia.setPreferredSize(new Dimension(150, 150));
			pnSesionDia.setLayout(new BorderLayout(0, 0));
			pnSesionDia.add(getPnCombosFechSes(), BorderLayout.CENTER);
			pnSesionDia.add(getSPSesion(), BorderLayout.SOUTH);
		}
		return pnSesionDia;
	}

	private JLabel getLblFoto() {
		if (lblFoto == null) {
			lblFoto = new JLabel("");
			lblFoto.setToolTipText("Car\u00E1tula de la pel\u00EDcula");
			lblFoto.setPreferredSize(new Dimension(500, 800));
			lblFoto.setFont(new Font("Sylfaen", Font.PLAIN, 36));
		}
		return lblFoto;
	}

	private JComboBox<String> getCombFecha() {
		if (combFecha == null) {
			combFecha = new JComboBox<String>();
			combFecha.setToolTipText("Seleccione una fecha");
			combFecha.setName("");
			combFecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (combFecha.getSelectedIndex() != 0) {
						String fecha = (String) combFecha.getSelectedItem();
						combSesion.setEnabled(true);
						mostrarSesion(fecha);

					} else {
						btnContinuar.setEnabled(false);
						combSesion.setEnabled(false);
						combSesion.setSelectedIndex(0);
						tPSesion.setText("");

					}

				}
			});
			combFecha.setSize(new Dimension(15, 16));
			combFecha.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			combFecha.setBorder(new LineBorder(new Color(47, 79, 79), 1, true));
			combFecha.setMinimumSize(new Dimension(150, 150));
			combFecha.setMaximumSize(new Dimension(200, 200));
			combFecha.setPreferredSize(new Dimension(15, 15));
		}
		return combFecha;
	}

	private JComboBox<String> getCombSesion() {
		if (combSesion == null) {
			combSesion = new JComboBox<String>();
			combSesion.setToolTipText("Seleccione una sesi\u00F3n");

			combSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (combSesion.getSelectedIndex() != 0) {
						mostrarEntradaReservada();
						btnContinuar.setEnabled(true);
					} else {
						btnContinuar.setEnabled(false);
					}
				}
			});
			combSesion.setPreferredSize(new Dimension(15, 15));
			combSesion.setSize(new Dimension(15, 15));
			combSesion.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			combSesion
					.setBorder(new LineBorder(new Color(47, 79, 79), 1, true));
		}
		return combSesion;
	}

	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("");
			btnContinuar.setEnabled(false);
			btnContinuar.setToolTipText("Clic para continuar");
			btnContinuar.setPreferredSize(new Dimension(70, 50));
			btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					continuar();
					mostrarEstadoAsientos();
					btnAtras.setEnabled(true);
				}
			});
			btnContinuar.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/cont.jpg")));
		}
		return btnContinuar;
	}

	private JPanel getPnbtones() {
		if (pnbtones == null) {
			pnbtones = new JPanel();
			pnbtones.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 2));
			pnbtones.add(getBtnAtras());
			pnbtones.add(getBtnContinuar());
		}
		return pnbtones;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("");
			btnAtras.setEnabled(false);
			btnAtras.setToolTipText("Clic para retroceder");
			btnAtras.setPreferredSize(new Dimension(70, 50));
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					retroceder();
				}
			});
			btnAtras.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/retro.jpg")));
		}
		return btnAtras;
	}

	private JLabel getLblAsientoSelecc() {
		if (lblAsientoSelecc == null) {
			lblAsientoSelecc = new JLabel("Seleccione su asiento");
			lblAsientoSelecc.setPreferredSize(new Dimension(102, 19));
			lblAsientoSelecc.setHorizontalAlignment(SwingConstants.CENTER);
			lblAsientoSelecc.setForeground(new Color(47, 79, 79));
			lblAsientoSelecc.setFont(new Font("Castellar", Font.BOLD, 18));
		}
		return lblAsientoSelecc;
	}

	private JPanel getPanel_1() {
		if (pnAsientosNumerados == null) {
			pnAsientosNumerados = new JPanel();
			pnAsientosNumerados.setPreferredSize(new Dimension(102, 100));
			pnAsientosNumerados.setSize(new Dimension(10, 10));
			pnAsientosNumerados.setMaximumSize(new Dimension(10, 10));
			pnAsientosNumerados.setLayout(new GridLayout(5, 6, 0, 0));
			pnAsientosNumerados.add(getButton_6_1());
			pnAsientosNumerados.add(getBtnFilaCinco_1());
			pnAsientosNumerados.add(getBtnFilaCinco_2());
			pnAsientosNumerados.add(getBtnBtnfilaCinco_3());
			pnAsientosNumerados.add(getBtnBtnfilaCinco_4());
			pnAsientosNumerados.add(getBtnBtnfilaCinco_5());
			pnAsientosNumerados.add(getBtnFilacuatro_0());
			pnAsientosNumerados.add(getBtnFilacuatro_1());
			pnAsientosNumerados.add(getBtnFilacuatro_2());
			pnAsientosNumerados.add(getBtnFilacuatro_3());
			pnAsientosNumerados.add(getBtnFilacuatro_4());
			pnAsientosNumerados.add(getBtnFilacuatro_5());
			pnAsientosNumerados.add(getBtnFilatres());
			pnAsientosNumerados.add(getBtnFilatres_1());
			pnAsientosNumerados.add(getBtnFilatres_2());
			pnAsientosNumerados.add(getBtnFilatres_3());
			pnAsientosNumerados.add(getBtnFilatres_4());
			pnAsientosNumerados.add(getBtnFilatres_5());
			pnAsientosNumerados.add(getBtnBtfilacinco_0());
			pnAsientosNumerados.add(getBtnBtfilacinco_1());
			pnAsientosNumerados.add(getBtnBtfilacinco_2());
			pnAsientosNumerados.add(getBtnBtfilacinco_3());
			pnAsientosNumerados.add(getBtnBtfilacinco_4());
			pnAsientosNumerados.add(getBtnBtfilacinco_5());
			pnAsientosNumerados.add(getBtnFilauno());
			pnAsientosNumerados.add(getBtnFilauno_1());
			pnAsientosNumerados.add(getBtnFilauno_2());
			pnAsientosNumerados.add(getBtnFilauno_3());
			pnAsientosNumerados.add(getBtnFilauno_4());
			pnAsientosNumerados.add(getBtnFilauno_5());
		}
		return pnAsientosNumerados;
	}

	private JButton getBtnBtfilacinco_0() {
		if (btnBtfilacinco_0 == null) {
			btnBtfilacinco_0 = new JButton("");
			btnBtfilacinco_0.setBackground(SystemColor.activeCaption);
		}
		return btnBtfilacinco_0;
	}

	private JButton getBtnBtfilacinco_1() {
		if (btnBtfilacinco_1 == null) {
			btnBtfilacinco_1 = new JButton("");
			btnBtfilacinco_1.setBackground(SystemColor.activeCaption);
		}
		return btnBtfilacinco_1;
	}

	private JButton getBtnBtfilacinco_2() {
		if (btnBtfilacinco_2 == null) {
			btnBtfilacinco_2 = new JButton("");
			btnBtfilacinco_2.setBackground(SystemColor.activeCaption);
		}
		return btnBtfilacinco_2;
	}

	private JButton getBtnBtfilacinco_3() {
		if (btnBtfilacinco_3 == null) {
			btnBtfilacinco_3 = new JButton("");
			btnBtfilacinco_3.setBackground(SystemColor.activeCaption);
		}
		return btnBtfilacinco_3;
	}

	private JButton getBtnBtfilacinco_4() {
		if (btnBtfilacinco_4 == null) {
			btnBtfilacinco_4 = new JButton("");
			btnBtfilacinco_4.setBackground(SystemColor.activeCaption);
		}
		return btnBtfilacinco_4;
	}

	private JButton getBtnBtfilacinco_5() {
		if (btnBtfilacinco_5 == null) {
			btnBtfilacinco_5 = new JButton("");
			btnBtfilacinco_5.setBackground(SystemColor.activeCaption);
		}
		return btnBtfilacinco_5;
	}

	private JButton getButton_6_1() {
		if (btnFilaCinco_0 == null) {
			btnFilaCinco_0 = new JButton("");
			btnFilaCinco_0.setBackground(SystemColor.activeCaption);
		}
		return btnFilaCinco_0;
	}

	private JButton getBtnFilaCinco_1() {
		if (btnFilaCinco_1 == null) {
			btnFilaCinco_1 = new JButton("");
			btnFilaCinco_1.setBackground(SystemColor.activeCaption);
		}
		return btnFilaCinco_1;
	}

	private JButton getBtnFilaCinco_2() {
		if (btnFilaCinco_2 == null) {
			btnFilaCinco_2 = new JButton("");
			btnFilaCinco_2.setBackground(SystemColor.activeCaption);
		}
		return btnFilaCinco_2;
	}

	private JButton getBtnBtnfilaCinco_3() {
		if (btnBtnfilaCinco_3 == null) {
			btnBtnfilaCinco_3 = new JButton("");
			btnBtnfilaCinco_3.setBackground(SystemColor.activeCaption);
		}
		return btnBtnfilaCinco_3;
	}

	private JButton getBtnBtnfilaCinco_4() {
		if (btnBtnfilaCinco_4 == null) {
			btnBtnfilaCinco_4 = new JButton("");
			btnBtnfilaCinco_4.setBackground(SystemColor.activeCaption);
		}
		return btnBtnfilaCinco_4;
	}

	private JButton getBtnBtnfilaCinco_5() {
		if (btnBtnfilaCinco_5 == null) {
			btnBtnfilaCinco_5 = new JButton("");
			btnBtnfilaCinco_5.setBackground(SystemColor.activeCaption);
		}
		return btnBtnfilaCinco_5;
	}

	private JButton getBtnFilacuatro_0() {
		if (btnFilacuatro_0 == null) {
			btnFilacuatro_0 = new JButton("");
			btnFilacuatro_0.setBackground(SystemColor.activeCaption);
		}
		return btnFilacuatro_0;
	}

	private JButton getBtnFilacuatro_1() {
		if (btnFilacuatro_1 == null) {
			btnFilacuatro_1 = new JButton("");
			btnFilacuatro_1.setBackground(SystemColor.activeCaption);
		}
		return btnFilacuatro_1;
	}

	private JButton getBtnFilacuatro_2() {
		if (btnFilacuatro_2 == null) {
			btnFilacuatro_2 = new JButton("");
			btnFilacuatro_2.setBackground(SystemColor.activeCaption);
		}
		return btnFilacuatro_2;
	}

	private JButton getBtnFilacuatro_3() {
		if (btnFilacuatro_3 == null) {
			btnFilacuatro_3 = new JButton("");
			btnFilacuatro_3.setBackground(SystemColor.activeCaption);
		}
		return btnFilacuatro_3;
	}

	private JButton getBtnFilacuatro_4() {
		if (btnFilacuatro_4 == null) {
			btnFilacuatro_4 = new JButton("");
			btnFilacuatro_4.setBackground(SystemColor.activeCaption);
		}
		return btnFilacuatro_4;
	}

	private JButton getBtnFilacuatro_5() {
		if (btnFilacuatro_5 == null) {
			btnFilacuatro_5 = new JButton("");
			btnFilacuatro_5.setBackground(SystemColor.activeCaption);
		}
		return btnFilacuatro_5;
	}

	private JButton getBtnFilatres() {
		if (btnFilatres == null) {
			btnFilatres = new JButton("");
			btnFilatres.setBackground(SystemColor.activeCaption);
		}
		return btnFilatres;
	}

	private JButton getBtnFilatres_1() {
		if (btnFilatres_1 == null) {
			btnFilatres_1 = new JButton("");
			btnFilatres_1.setBackground(SystemColor.activeCaption);
		}
		return btnFilatres_1;
	}

	private JButton getBtnFilatres_2() {
		if (btnFilatres_2 == null) {
			btnFilatres_2 = new JButton("");
			btnFilatres_2.setBackground(SystemColor.activeCaption);
		}
		return btnFilatres_2;
	}

	private JButton getBtnFilatres_3() {
		if (btnFilatres_3 == null) {
			btnFilatres_3 = new JButton("");
			btnFilatres_3.setBackground(SystemColor.activeCaption);
		}
		return btnFilatres_3;
	}

	private JButton getBtnFilatres_4() {
		if (btnFilatres_4 == null) {
			btnFilatres_4 = new JButton("");
			btnFilatres_4.setBackground(SystemColor.activeCaption);
		}
		return btnFilatres_4;
	}

	private JButton getBtnFilatres_5() {
		if (btnFilatres_5 == null) {
			btnFilatres_5 = new JButton("");
			btnFilatres_5.setBackground(SystemColor.activeCaption);
		}
		return btnFilatres_5;
	}

	private JButton getBtnFilauno() {
		if (btnFilauno == null) {
			btnFilauno = new JButton("");
			btnFilauno.setBackground(SystemColor.activeCaption);
		}
		return btnFilauno;
	}

	private JButton getBtnFilauno_1() {
		if (btnFilauno_1 == null) {
			btnFilauno_1 = new JButton("");
			btnFilauno_1.setBackground(SystemColor.activeCaption);
		}
		return btnFilauno_1;
	}

	private JButton getBtnFilauno_2() {
		if (btnFilauno_2 == null) {
			btnFilauno_2 = new JButton("");
			btnFilauno_2.setBackground(SystemColor.activeCaption);
		}
		return btnFilauno_2;
	}

	private JButton getBtnFilauno_3() {
		if (btnFilauno_3 == null) {
			btnFilauno_3 = new JButton("");
			btnFilauno_3.setBackground(SystemColor.activeCaption);
		}
		return btnFilauno_3;
	}

	private JButton getBtnFilauno_4() {
		if (btnFilauno_4 == null) {
			btnFilauno_4 = new JButton("");
			btnFilauno_4.setBackground(SystemColor.activeCaption);
		}
		return btnFilauno_4;
	}

	private JButton getBtnFilauno_5() {
		if (btnFilauno_5 == null) {
			btnFilauno_5 = new JButton("");
			btnFilauno_5.setBackground(SystemColor.activeCaption);
		}
		return btnFilauno_5;
	}

	private JPanel getPnAsientosSelecc() {
		if (pnAsientosSelecc == null) {
			pnAsientosSelecc = new JPanel();
			pnAsientosSelecc.setMinimumSize(new Dimension(20, 20));
			pnAsientosSelecc.setSize(new Dimension(20, 20));
			pnAsientosSelecc.setPreferredSize(new Dimension(102, 60));
			pnAsientosSelecc.setLayout(new GridLayout(1, 3, 0, 0));
			pnAsientosSelecc.add(getCPAsientosPeli());
			pnAsientosSelecc.add(getSPAsientoSelecc());
			pnAsientosSelecc.add(getPnLeyenda());
		}
		return pnAsientosSelecc;
	}

	private JScrollPane getCPAsientosPeli() {
		if (cPAsientosPeli == null) {
			cPAsientosPeli = new JScrollPane();
			cPAsientosPeli.setViewportView(getTPPeliSelecc());
		}
		return cPAsientosPeli;
	}

	private JTextPane getTPPeliSelecc() {
		if (tPPeliSelecc == null) {
			tPPeliSelecc = new JTextPane();
			tPPeliSelecc.setBackground(new Color(47, 79, 79));
			tPPeliSelecc.setOpaque(false);
			tPPeliSelecc.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tPPeliSelecc.setEditable(false);
		}
		return tPPeliSelecc;
	}

	private JScrollPane getSPSesion() {
		if (sPSesion == null) {
			sPSesion = new JScrollPane();
			sPSesion.setPreferredSize(new Dimension(250, 90));
			sPSesion.setMinimumSize(new Dimension(30, 30));
			sPSesion.setMaximumSize(new Dimension(400, 400));
			sPSesion.setViewportView(getTPSesion());
		}
		return sPSesion;
	}

	private JTextPane getTPSesion() {
		if (tPSesion == null) {
			tPSesion = new JTextPane();
			tPSesion.setOpaque(false);
			tPSesion.setSize(new Dimension(100, 100));
			tPSesion.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tPSesion.setEditable(false);
		}
		return tPSesion;
	}

	private JPanel getPnTipo() {
		if (pnTipo == null) {
			pnTipo = new JPanel();
			pnTipo.setLayout(new BorderLayout(0, 0));
			pnTipo.add(getPnEntradas());
		}
		return pnTipo;
	}

	private JPanel getPnEntradas() {
		if (pnEntradas == null) {
			pnEntradas = new JPanel();
			pnEntradas.setLayout(new GridLayout(3, 2, 0, 0));
			pnEntradas.add(getLblNmeroDeEntras());
			pnEntradas.add(getTFNEntradas());
			pnEntradas.add(getLblNEntradasJunilados());
			pnEntradas.add(getPnMayores());
			pnEntradas.add(getLblPackCumpleaos());
			pnEntradas.add(getPanel_1_1());
		}
		return pnEntradas;
	}

	private JTextField getTFNEntradas() {
		if (tFNEntradas == null) {
			tFNEntradas = new JTextField();
			tFNEntradas.setHorizontalAlignment(SwingConstants.CENTER);
			tFNEntradas.setToolTipText("N\u00FAmero de entradas");
			tFNEntradas.setFont(new Font("Times New Roman", Font.BOLD, 26));
			tFNEntradas.setEditable(false);
			tFNEntradas.setColumns(10);
		}
		return tFNEntradas;
	}

	private JLabel getLblNEntradasJunilados() {
		if (lblNEntradasJunilados == null) {
			lblNEntradasJunilados = new JLabel("Mayores de 65 a\u00F1os");
			lblNEntradasJunilados.setFont(new Font("Times New Roman",
					Font.BOLD, 26));
			lblNEntradasJunilados.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNEntradasJunilados;
	}

	private JLabel getLblPackCumpleaos() {
		if (lblPackCumpleaos == null) {
			lblPackCumpleaos = new JLabel("Pack cumplea\u00F1os");
			lblPackCumpleaos
					.setFont(new Font("Times New Roman", Font.BOLD, 26));
			lblPackCumpleaos.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPackCumpleaos;
	}

	private JLabel getLblNmeroDeEntras() {
		if (lblNmeroDeEntras == null) {
			lblNmeroDeEntras = new JLabel("Entrada/s");
			lblNmeroDeEntras
					.setFont(new Font("Times New Roman", Font.BOLD, 26));
			lblNmeroDeEntras.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNmeroDeEntras;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnOpciones());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}

	private JMenu getMnOpciones() {
		if (mnOpciones == null) {
			mnOpciones = new JMenu("Opciones");
			mnOpciones.setMnemonic('O');
			mnOpciones.add(getMntmNuevaCompra());
			mnOpciones.add(getSptOpciones());
			mnOpciones.add(getMntmSalir());
		}
		return mnOpciones;
	}

	private JMenuItem getMntmNuevaCompra() {
		if (mntmNuevaCompra == null) {
			mntmNuevaCompra = new JMenuItem(" Nueva compra");
			mntmNuevaCompra.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_N, InputEvent.CTRL_MASK));
			mntmNuevaCompra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			mntmNuevaCompra.setMnemonic('N');
		}
		return mntmNuevaCompra;
	}

	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setMnemonic('S');
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,
					0));
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmSalir;
	}

	private JPanel getPnCombosFechSes() {
		if (pnCombosFechSes == null) {
			pnCombosFechSes = new JPanel();
			pnCombosFechSes.setPreferredSize(new Dimension(450, 100));
			pnCombosFechSes.setSize(new Dimension(10, 10));
			pnCombosFechSes.setLayout(new GridLayout(2, 1, 0, 0));
			pnCombosFechSes.add(getCombFecha());
			pnCombosFechSes.add(getCombSesion());
		}
		return pnCombosFechSes;
	}

	private JScrollPane getSPAsientoSelecc() {
		if (sPAsientoSelecc == null) {
			sPAsientoSelecc = new JScrollPane();
			sPAsientoSelecc.setViewportView(getTpAsientoSelecc());
		}
		return sPAsientoSelecc;
	}

	private JTextPane getTpAsientoSelecc() {
		if (tpAsientoSelecc == null) {
			tpAsientoSelecc = new JTextPane();
			tpAsientoSelecc.setBackground(new Color(47, 79, 79));
			tpAsientoSelecc.setOpaque(false);
			tpAsientoSelecc.setFont(new Font("Times New Roman", Font.BOLD, 18));
			tpAsientoSelecc.setEditable(false);
		}
		return tpAsientoSelecc;
	}

	private JPanel getPnFiltroGenero() {
		if (pnFiltroGenero == null) {
			pnFiltroGenero = new JPanel();
			pnFiltroGenero.setToolTipText("Seleccione un filtro");
			pnFiltroGenero.setOpaque(false);
			pnFiltroGenero.setBorder(new TitledBorder(null, "Filtros",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(47,
							79, 79)));
			pnFiltroGenero.add(getCbAccion());
			pnFiltroGenero.add(getCbAventura());
			pnFiltroGenero.add(getCbBelica());
			pnFiltroGenero.add(getCbComedia());
			pnFiltroGenero.add(getCbDrama());
			pnFiltroGenero.add(getCbTerror());
			pnFiltroGenero.add(getCbOtros());
			pnFiltroGenero.add(getCbTresD());
			pnFiltroGenero.add(getPnEdad());
		}
		return pnFiltroGenero;
	}

	private JCheckBox getCbAccion() {
		if (cbAccion == null) {
			cbAccion = new JCheckBox("Acci\u00F3n");
			cbAccion.setToolTipText("Ver pel\u00EDculas de Acci\u00F3n");
			cbAccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPeliculas();
				}
			});
			cbAccion.setSelected(true);
			cbAccion.setForeground(new Color(47, 79, 79));
			cbAccion.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return cbAccion;
	}

	private JCheckBox getCbAventura() {
		if (cbAventura == null) {
			cbAventura = new JCheckBox("Aventura");
			cbAventura.setToolTipText("Ver pel\u00EDculas de Aventura");
			cbAventura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPeliculas();
				}
			});
			cbAventura.setSelected(true);
			cbAventura.setForeground(new Color(47, 79, 79));
			cbAventura.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return cbAventura;
	}

	private JCheckBox getCbBelica() {
		if (cbBelica == null) {
			cbBelica = new JCheckBox("B\u00E9lica");
			cbBelica.setToolTipText("Ver pel\u00EDculas de B\u00E9lica");
			cbBelica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPeliculas();
				}
			});
			cbBelica.setSelected(true);
			cbBelica.setForeground(new Color(47, 79, 79));
			cbBelica.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return cbBelica;
	}

	private JCheckBox getCbComedia() {
		if (cbComedia == null) {
			cbComedia = new JCheckBox("Comedia");
			cbComedia.setToolTipText("Ver pel\u00EDculas de Comedia");
			cbComedia.setSelected(true);
			cbComedia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPeliculas();
				}
			});
			cbComedia.setForeground(new Color(47, 79, 79));
			cbComedia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return cbComedia;
	}

	private JCheckBox getCbTerror() {
		if (cbTerror == null) {
			cbTerror = new JCheckBox("Terror");
			cbTerror.setToolTipText("Ver pel\u00EDculas de Terror");
			cbTerror.setSelected(true);
			cbTerror.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPeliculas();
				}
			});
			cbTerror.setForeground(new Color(47, 79, 79));
			cbTerror.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return cbTerror;
	}

	private JCheckBox getCbDrama() {
		if (cbDrama == null) {
			cbDrama = new JCheckBox("Drama");
			cbDrama.setToolTipText("Ver pel\u00EDculas de Drama");
			cbDrama.setSelected(true);
			cbDrama.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPeliculas();
				}
			});
			cbDrama.setForeground(new Color(47, 79, 79));
			cbDrama.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return cbDrama;
	}

	private JCheckBox getCbTresD() {
		if (cbTresD == null) {
			cbTresD = new JCheckBox("3D");
			cbTresD.setToolTipText("Ver pel\u00EDculas con formato 3D");
			cbTresD.setSelected(true);
			cbTresD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPeliculas();
				}
			});
			cbTresD.setForeground(new Color(47, 79, 79));
			cbTresD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return cbTresD;
	}

	private JCheckBox getCbOtros() {
		if (cbOtros == null) {
			cbOtros = new JCheckBox("Otros");
			cbOtros.setToolTipText("Ver pel\u00EDculas de Otros g\u00E9neros");
			cbOtros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPeliculas();
				}
			});
			cbOtros.setSelected(true);
			cbOtros.setForeground(new Color(47, 79, 79));
			cbOtros.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return cbOtros;
	}

	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.add(getMntmAcercaDe());
			mnAyuda.add(getMntmContenidos());
		}
		return mnAyuda;
	}

	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de");
			mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
					InputEvent.CTRL_MASK));
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane
							.showMessageDialog(null,
									"Aplicación desarrollada por: \n Elías Mendes Dos Santos \n 71744620F ");

				}
			});
		}
		return mntmAcercaDe;
	}

	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("Contenidos");
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
					InputEvent.CTRL_MASK));
		}
		return mntmContenidos;
	}

	private JPanel getPnLeyenda() {
		if (pnLeyenda == null) {
			pnLeyenda = new JPanel();
			pnLeyenda.setBorder(new TitledBorder(null, "Leyenda",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(47,
							79, 79)));
			pnLeyenda.setLayout(new GridLayout(1, 2, 0, 0));
			pnLeyenda.add(getBtLeyendaLibre());
			pnLeyenda.add(getBtLeyendaOcupado());
			pnLeyenda.add(getBtnOcupado());
		}
		return pnLeyenda;
	}

	private JButton getBtLeyendaLibre() {
		if (btLeyendaLibre == null) {
			btLeyendaLibre = new JButton("Libre");
			btLeyendaLibre.setToolTipText("Butaca libre");
			btLeyendaLibre.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btLeyendaLibre.setEnabled(false);
			btLeyendaLibre.setForeground(Color.WHITE);
			btLeyendaLibre.setBackground(Color.LIGHT_GRAY);
		}
		return btLeyendaLibre;
	}

	private JButton getBtLeyendaOcupado() {
		if (btLeyendaOcupado == null) {
			btLeyendaOcupado = new JButton("Seleccionado");
			btLeyendaOcupado.setToolTipText("Butaca seleccionada");
			btLeyendaOcupado
					.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btLeyendaOcupado.setEnabled(false);
			btLeyendaOcupado.setForeground(Color.WHITE);
			btLeyendaOcupado.setBackground(Color.BLACK);
		}
		return btLeyendaOcupado;
	}

	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			pnPrecio.setName("Total a pagar");
			pnPrecio.setLayout(new BorderLayout(0, 0));
			pnPrecio.add(getPnMostrarPrecio());
		}
		return pnPrecio;
	}

	private JPanel getPnMostrarPrecio() {
		if (pnMostrarPrecio == null) {
			pnMostrarPrecio = new JPanel();
			pnMostrarPrecio.setLayout(new GridLayout(0, 2, 0, 0));
			pnMostrarPrecio.add(getLglPrecio());
			pnMostrarPrecio.add(getTfTotalaPagar());
		}
		return pnMostrarPrecio;
	}

	private JLabel getLglPrecio() {
		if (lglPrecio == null) {
			lglPrecio = new JLabel("Total a pagar:");
			lglPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			lglPrecio.setFont(new Font("Times New Roman", Font.BOLD, 24));
		}
		return lglPrecio;
	}

	private JTextField getTfTotalaPagar() {
		if (tfTotalaPagar == null) {
			tfTotalaPagar = new JTextField();
			tfTotalaPagar.setToolTipText("Total a pagar");
			tfTotalaPagar.setHorizontalAlignment(SwingConstants.CENTER);
			tfTotalaPagar.setFont(new Font("Times New Roman", Font.BOLD, 24));
			tfTotalaPagar.setEditable(false);
			tfTotalaPagar.setColumns(10);
		}
		return tfTotalaPagar;
	}

	private JSeparator getSptOpciones() {
		if (sptOpciones == null) {
			sptOpciones = new JSeparator();
		}
		return sptOpciones;
	}

	private JPanel getPnMayores() {
		if (pnMayores == null) {
			pnMayores = new JPanel();
			pnMayores.setLayout(new BorderLayout(0, 0));
			pnMayores.add(getTFMayores(), BorderLayout.CENTER);
			pnMayores.add(getPnAumentar_Disminuir_Mayor(), BorderLayout.EAST);
		}
		return pnMayores;
	}

	private JPanel getPanel_1_1() {
		if (pnCumple == null) {
			pnCumple = new JPanel();
			pnCumple.setLayout(new BorderLayout(0, 0));
			pnCumple.add(getPnAum_dism_cumpl(), BorderLayout.EAST);
			pnCumple.add(getTfCumple(), BorderLayout.CENTER);
		}
		return pnCumple;
	}

	private JTextField getTFMayores() {
		if (tFMayores == null) {
			tFMayores = new JTextField();
			tFMayores.setText("0");
			tFMayores.setToolTipText("N\u00FAmero de entradas");
			tFMayores.setHorizontalAlignment(SwingConstants.CENTER);
			tFMayores.setFont(new Font("Times New Roman", Font.BOLD, 26));
			tFMayores.setEditable(false);
			tFMayores.setColumns(10);
		}
		return tFMayores;
	}

	private JPanel getPnAumentar_Disminuir_Mayor() {
		if (pnAumentar_Disminuir_Mayor == null) {
			pnAumentar_Disminuir_Mayor = new JPanel();
			GridBagLayout gbl_pnAumentar_Disminuir_Mayor = new GridBagLayout();
			gbl_pnAumentar_Disminuir_Mayor.columnWidths = new int[] { 1 };
			gbl_pnAumentar_Disminuir_Mayor.rowHeights = new int[] { 4 };
			gbl_pnAumentar_Disminuir_Mayor.columnWeights = new double[] { 0.0 };
			gbl_pnAumentar_Disminuir_Mayor.rowWeights = new double[] { 0.0,
					0.0, 0.0, 0.0 };
			pnAumentar_Disminuir_Mayor
					.setLayout(gbl_pnAumentar_Disminuir_Mayor);
			GridBagConstraints gbc_btnMasMayor = new GridBagConstraints();
			gbc_btnMasMayor.gridheight = 2;
			gbc_btnMasMayor.fill = GridBagConstraints.BOTH;
			gbc_btnMasMayor.insets = new Insets(0, 0, 5, 0);
			gbc_btnMasMayor.gridx = 0;
			gbc_btnMasMayor.gridy = 0;
			pnAumentar_Disminuir_Mayor.add(getBtnMasMayor(), gbc_btnMasMayor);
			GridBagConstraints gbc_btnMenosMayor = new GridBagConstraints();
			gbc_btnMenosMayor.gridheight = 2;
			gbc_btnMenosMayor.insets = new Insets(0, 0, 5, 0);
			gbc_btnMenosMayor.fill = GridBagConstraints.BOTH;
			gbc_btnMenosMayor.gridx = 0;
			gbc_btnMenosMayor.gridy = 2;
			pnAumentar_Disminuir_Mayor.add(getBtnMenosMayor(),
					gbc_btnMenosMayor);
		}
		return pnAumentar_Disminuir_Mayor;
	}

	private JButton getBtnMasMayor() {
		if (btnMasMayor == null) {
			btnMasMayor = new JButton("+");
			btnMasMayor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int entM = getEntradasMayores();
					int entC = getEntradasCumple();
					int eSuma = entM + entC;

					int nentradas = Integer.parseInt(tFNEntradas.getText());

					if (nentradas > eSuma) {
						entM++;

						btnContinuar.setEnabled(true);
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"La cantidad de entradas con descuento debe ser menor a la de entradas en total");
						// btnContinuar.setEnabled(false);

					}

					setEntradasMayores(entM);
					tFMayores.setText(String.valueOf(entM));
					System.out.println("es+m :" + entM);
					System.out.println("ES en este momento: "
							+ getEntradasMayores());

				}
			});
		}
		return btnMasMayor;
	}

	private JButton getBtnMenosMayor() {
		if (btnMenosMayor == null) {
			btnMenosMayor = new JButton("-");
			btnMenosMayor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int entM = getEntradasMayores();

					int nentradas = Integer.parseInt(tFNEntradas.getText());

					if (entM > 0 && entM <= nentradas) {
						entM--;

						btnContinuar.setEnabled(true);
					}

					setEntradasMayores(entM);
					tFMayores.setText(String.valueOf(entM));
					System.out.println("es+m :" + entM);
					System.out.println("ES en este momento: "
							+ getEntradasMayores());

				}
			});
		}
		return btnMenosMayor;
	}

	private JPanel getPnAum_dism_cumpl() {
		if (pnAum_dism_cumpl == null) {
			pnAum_dism_cumpl = new JPanel();
			GridBagLayout gbl_pnAum_dism_cumpl = new GridBagLayout();
			gbl_pnAum_dism_cumpl.columnWidths = new int[] { 1 };
			gbl_pnAum_dism_cumpl.rowHeights = new int[] { 4 };
			gbl_pnAum_dism_cumpl.columnWeights = new double[] { 0.0 };
			gbl_pnAum_dism_cumpl.rowWeights = new double[] { 0.0, 0.0, 0.0,
					0.0, 0.0 };
			pnAum_dism_cumpl.setLayout(gbl_pnAum_dism_cumpl);
			GridBagConstraints gbc_btnMasCumpl = new GridBagConstraints();
			gbc_btnMasCumpl.gridheight = 2;
			gbc_btnMasCumpl.fill = GridBagConstraints.BOTH;
			gbc_btnMasCumpl.insets = new Insets(0, 0, 5, 0);
			gbc_btnMasCumpl.gridx = 0;
			gbc_btnMasCumpl.gridy = 1;
			pnAum_dism_cumpl.add(getBtnMasCumpl(), gbc_btnMasCumpl);
			GridBagConstraints gbc_btnMenosCumple = new GridBagConstraints();
			gbc_btnMenosCumple.insets = new Insets(0, 0, 5, 0);
			gbc_btnMenosCumple.gridheight = 2;
			gbc_btnMenosCumple.fill = GridBagConstraints.BOTH;
			gbc_btnMenosCumple.gridx = 0;
			gbc_btnMenosCumple.gridy = 3;
			pnAum_dism_cumpl.add(getBtnMenosCumple(), gbc_btnMenosCumple);
		}
		return pnAum_dism_cumpl;
	}

	private JTextField getTfCumple() {
		if (tfCumple == null) {
			tfCumple = new JTextField();
			tfCumple.setText("0");
			tfCumple.setToolTipText("N\u00FAmero de entradas");
			tfCumple.setHorizontalAlignment(SwingConstants.CENTER);
			tfCumple.setFont(new Font("Times New Roman", Font.BOLD, 26));
			tfCumple.setEditable(false);
			tfCumple.setColumns(10);
		}
		return tfCumple;
	}

	private JButton getBtnMasCumpl() {
		if (btnMasCumpl == null) {
			btnMasCumpl = new JButton("+");
			btnMasCumpl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int entM = getEntradasMayores();
					int entC = getEntradasCumple();
					int eSuma = entM + entC;

					int nentradas = Integer.parseInt(tFNEntradas.getText());

					if (nentradas > eSuma) {
						entC++;

						btnContinuar.setEnabled(true);
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"La cantidad de entradas con descuento debe ser menor a la de entradas en total");

					}

					setEntradasCumple(entC);

					tfCumple.setText(String.valueOf(entC));
					System.out.println("es+m :" + entC);
					System.out.println("ES en este momento: "
							+ getEntradasCumple());

				}
			});
		}
		return btnMasCumpl;
	}

	private JButton getBtnMenosCumple() {
		if (btnMenosCumple == null) {
			btnMenosCumple = new JButton("-");
			btnMenosCumple.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int entC = getEntradasCumple();

					int nentradas = Integer.parseInt(tFNEntradas.getText());

					if (entC > 0 && entC <= nentradas) {
						entC--;

						btnContinuar.setEnabled(true);
					}

					setEntradasCumple(entC);
					tfCumple.setText(String.valueOf(entC));
					System.out.println("es+m :" + entC);
					System.out.println("ES en este momento: "
							+ getEntradasCumple());

				}
			});
		}
		return btnMenosCumple;

	}

	private JPanel getPnEdad() {
		if (pnEdad == null) {
			pnEdad = new JPanel();
			pnEdad.setBorder(new TitledBorder(null, "Edad",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnEdad.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnEdad.add(getRdbTodos());
			pnEdad.add(getRdbMasDoce());
			pnEdad.add(getRdbMasDieciseis());
			pnEdad.add(getRdbMasDieciocho());
		}
		return pnEdad;
	}

	private JRadioButton getRdbTodos() {
		if (rdbTodos == null) {
			rdbTodos = new JRadioButton("Todos los p\u00FAblicos");
			rdbTodos.setToolTipText("Filtrar por edad");
			rdbTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPeliculas();
				}
			});
			rdbTodos.setForeground(new Color(47, 79, 79));
			rdbTodos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return rdbTodos;
	}

	private JRadioButton getRdbMasDieciseis() {
		if (rdbMasDieciseis == null) {
			rdbMasDieciseis = new JRadioButton("+16");
			rdbMasDieciseis.setToolTipText("Filtrar por edad");
			rdbMasDieciseis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPeliculas();

				}
			});

			rdbMasDieciseis.setForeground(new Color(47, 79, 79));
			rdbMasDieciseis
					.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return rdbMasDieciseis;
	}

	private JRadioButton getRdbMasDieciocho() {
		if (rdbMasDieciocho == null) {
			rdbMasDieciocho = new JRadioButton("+18");
			rdbMasDieciocho.setToolTipText("Filtrar por edad");
			rdbMasDieciocho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPeliculas();

				}
			});

			rdbMasDieciocho.setForeground(new Color(47, 79, 79));
			rdbMasDieciocho
					.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return rdbMasDieciocho;
	}

	private JRadioButton getRdbMasDoce() {
		if (rdbMasDoce == null) {
			rdbMasDoce = new JRadioButton("+12");
			rdbMasDoce.setToolTipText("Filtrar por edad");
			rdbMasDoce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPeliculas();

				}
			});
			rdbMasDoce.setForeground(new Color(47, 79, 79));
			rdbMasDoce.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		}
		return rdbMasDoce;
	}

	private JButton getBtnOcupado() {
		if (btnOcupado == null) {
			btnOcupado = new JButton("Ocupado");
			btnOcupado.setToolTipText("Butaca ocupada");
			btnOcupado.setForeground(Color.WHITE);
			btnOcupado.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btnOcupado.setEnabled(false);
			btnOcupado.setBackground(Color.RED);
		}
		return btnOcupado;
	}
}
