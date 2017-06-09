package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class VentanaPago extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnNorte;
	private JPanel pnSur;
	private JPanel pnEste;
	private JPanel pnCentro;
	private JPanel pnOeste;
	private JTextField txtIndiqueElTipo;
	private JSpinner spEntradaJubilados;
	private JPanel pnEsteCentro;
	private JPanel panelJubilados;
	private JLabel lblJubilados;
	private JPanel panel;
	private JLabel lblPackCumpleaos;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPago frame = new VentanaPago();
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
	public VentanaPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnSur(), BorderLayout.SOUTH);
		contentPane.add(getPnEste(), BorderLayout.EAST);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnOeste(), BorderLayout.WEST);
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setLayout(new BorderLayout(0, 0));
			pnNorte.add(getTxtIndiqueElTipo(), BorderLayout.NORTH);
		}
		return pnNorte;
	}
	private JPanel getPnSur() {
		if (pnSur == null) {
			pnSur = new JPanel();
		}
		return pnSur;
	}
	private JPanel getPnEste() {
		if (pnEste == null) {
			pnEste = new JPanel();
		}
		return pnEste;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
		}
		return pnCentro;
	}
	private JPanel getPnOeste() {
		if (pnOeste == null) {
			pnOeste = new JPanel();
			pnOeste.setLayout(new BorderLayout(0, 0));
			pnOeste.add(getPnEsteCentro(), BorderLayout.CENTER);
		}
		return pnOeste;
	}
	private JTextField getTxtIndiqueElTipo() {
		if (txtIndiqueElTipo == null) {
			txtIndiqueElTipo = new JTextField();
			txtIndiqueElTipo.setHorizontalAlignment(SwingConstants.CENTER);
			txtIndiqueElTipo.setFont(new Font("Times New Roman", Font.BOLD, 26));
			txtIndiqueElTipo.setText("Indique el tipo de entrada o descuento.");
			txtIndiqueElTipo.setColumns(10);
		}
		return txtIndiqueElTipo;
	}
	private JSpinner getSpEntradaJubilados() {
		if (spEntradaJubilados == null) {
			spEntradaJubilados = new JSpinner();
		}
		return spEntradaJubilados;
	}
	private JPanel getPnEsteCentro() {
		if (pnEsteCentro == null) {
			pnEsteCentro = new JPanel();
			pnEsteCentro.setLayout(new GridLayout(5, 1, 0, 0));
			pnEsteCentro.add(getPanelJubilados());
			pnEsteCentro.add(getPanel());
		}
		return pnEsteCentro;
	}
	private JPanel getPanelJubilados() {
		if (panelJubilados == null) {
			panelJubilados = new JPanel();
			panelJubilados.add(getLblJubilados());
			panelJubilados.add(getSpEntradaJubilados());
		}
		return panelJubilados;
	}
	private JLabel getLblJubilados() {
		if (lblJubilados == null) {
			lblJubilados = new JLabel(" +65 a\u00F1os");
		}
		return lblJubilados;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblPackCumpleaos());
			panel.add(getSpinner());
		}
		return panel;
	}
	private JLabel getLblPackCumpleaos() {
		if (lblPackCumpleaos == null) {
			lblPackCumpleaos = new JLabel("pack cumplea\u00F1os");
		}
		return lblPackCumpleaos;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
		}
		return spinner;
	}
}
