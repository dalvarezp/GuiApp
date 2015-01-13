package view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

//Classe que conté la vista

public class JFramePersona extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldNom;
	private JTextField textFieldCognom1;
	private JTextField textFieldCognom2;
	private JTextField textFieldEdat;

	private JButton btnNou, btnEsborra, btnEdita, btnPrimer, btnDarrer,
			btnAnterior, btnSeguent, btnDesa, btnCancela;
	private JLabel lblRegistre;


	/**
	 * Create the frame.
	 */
	public JFramePersona() {
		setResizable(false);
		setTitle("GESTI\u00D3 DE PERSONES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();

		//Creació dels botons
		btnNou = new JButton("Nou");
		toolBar.add(btnNou);

		btnEsborra = new JButton("Esborra");
		toolBar.add(btnEsborra);

		btnEdita = new JButton("Edita");
		toolBar.add(btnEdita);

		btnPrimer = new JButton("Primer");
		toolBar.add(btnPrimer);

		btnDarrer = new JButton("Darrer");
		toolBar.add(btnDarrer);

		btnAnterior = new JButton("Anterior");
		toolBar.add(btnAnterior);

		btnSeguent = new JButton("Seg\u00FCent");
		toolBar.add(btnSeguent);

		btnDesa = new JButton("Desa");
		btnDesa.setEnabled(false);
		toolBar.add(btnDesa);

		btnCancela = new JButton("Cancel.la");
		btnCancela.setEnabled(false);
		toolBar.add(btnCancela);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(10)
										.addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 404,
												Short.MAX_VALUE)
										.addContainerGap())
						.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 424,
								Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 200,
								Short.MAX_VALUE).addContainerGap()));

		//Creació dels camps de text fixes
		JLabel label_1 = new JLabel("    ");
		toolBar.add(label_1);

		lblRegistre = new JLabel("Registre 1 de 1");
		toolBar.add(lblRegistre);

		JLabel label = new JLabel("");

		JLabel lblDni = new JLabel("DNI:");

		JLabel lblNom = new JLabel("Nom:");

		JLabel lblPrimerCognom = new JLabel("Primer Cognom:");

		JLabel lblSegonCognom = new JLabel("Segon Cognom:");

		JLabel lblEdat = new JLabel("Edat:");

		textFieldDni = new JTextField();
		//textFieldDni.setBackground(Color.WHITE);
		textFieldDni.setColumns(10);

		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);

		textFieldCognom1 = new JTextField();
		textFieldCognom1.setColumns(10);

		textFieldCognom2 = new JTextField();
		textFieldCognom2.setColumns(10);

		textFieldEdat = new JTextField();
		textFieldEdat.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(label)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblDni)
																				.addComponent(
																						lblNom)
																				.addComponent(
																						lblPrimerCognom)
																				.addComponent(
																						lblSegonCognom)
																				.addComponent(
																						lblEdat))
																.addGap(26)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						textFieldNom,
																						GroupLayout.DEFAULT_SIZE,
																						326,
																						Short.MAX_VALUE)
																				.addComponent(
																						textFieldDni,
																						GroupLayout.DEFAULT_SIZE,
																						326,
																						Short.MAX_VALUE)
																				.addComponent(
																						textFieldCognom1,
																						GroupLayout.DEFAULT_SIZE,
																						326,
																						Short.MAX_VALUE)
																				.addComponent(
																						textFieldCognom2,
																						GroupLayout.DEFAULT_SIZE,
																						326,
																						Short.MAX_VALUE)
																				.addComponent(
																						textFieldEdat,
																						GroupLayout.DEFAULT_SIZE,
																						326,
																						Short.MAX_VALUE))))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(label)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						lblDni)
																				.addComponent(
																						textFieldDni,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNom)
												.addComponent(
														textFieldNom,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblPrimerCognom)
												.addComponent(
														textFieldCognom1,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblSegonCognom)
												.addComponent(
														textFieldCognom2,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblEdat)
												.addComponent(
														textFieldEdat,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(47, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	//Mètodes associats als botons i als camps de text
	public JButton getButtonNou() {
		return btnNou;
	}

	public JButton getButtonEsborrar() {
		return btnEsborra;
	}

	public JButton getButtonEdita() {
		return btnEdita;
	}

	public JButton getButtonPrimer() {
		return btnPrimer;
	}

	public JButton getButtonDarrer() {
		return btnDarrer;
	}

	public JButton getButtonAnterior() {
		return btnAnterior;
	}

	public JButton getButtonSeguent() {
		return btnSeguent;
	}

	public JButton getButtonDesa() {
		return btnDesa;
	}

	public JButton getButtonCancela() {
		return btnCancela;
	}

	public void setTextDni(String dni) {
		textFieldDni.setText(dni);
	}

	public String getTextDni() {
		return textFieldDni.getText();
	}
	
//	public JTextField getTextDni() {
//		return textFieldDni;
//	}

	public void setTextNom(String nom) {
		textFieldNom.setText(nom);
	}

	public String getTextNom() {
		return textFieldNom.getText();
	}

	public void setTextCognom1(String cognom1) {
		textFieldCognom1.setText(cognom1);
	}

	public String getTextCognom1() {
		return textFieldCognom1.getText();
	}

	public void setTextCognom2(String cognom2) {
		textFieldCognom2.setText(cognom2);
	}

	public String getTextCognom2() {
		return textFieldCognom2.getText();
	}

	public void setTextEdat(String edat) {
		textFieldEdat.setText(edat);
	}

	public int getEdat() {
		return Integer.parseInt(textFieldEdat.getText());
	}

	public void setlblRegistre(String text) {
		lblRegistre.setText(text);
	}


	/**
	 * Mètode que mostra una caixa de text amb el missatge
	 * segur d'eliminar
	 * @return
	 */
	public int dialegEsborrar() {
		return JOptionPane.showConfirmDialog(null, 
                "Estàs segur que vols esborrar el registre?", 
                "Esborrar", 
                JOptionPane.YES_NO_OPTION); 
	}
	
	/**
	 * Mètode que rep un missatge per parametre
	 * mostrarà els camps que no passen les expressions regulars
	 * @param missatge
	 */
	public void errorEntrada(String missatge){
	JOptionPane.showMessageDialog(new JFrame(),missatge, "Error d'entrada",JOptionPane.HEIGHT);
	
	}
	
	/**
	 * Mètode que canvia el color del fons dels camps de text editables a gris
	 */
	public void campsModif(){
		textFieldDni.setBackground(Color.LIGHT_GRAY);
		textFieldNom.setBackground(Color.LIGHT_GRAY);
		textFieldCognom1.setBackground(Color.LIGHT_GRAY);
		textFieldCognom2.setBackground(Color.LIGHT_GRAY);
		textFieldEdat.setBackground(Color.LIGHT_GRAY);
	}
	
	/**
	 *  Mètode que canvia el color del fons dels camps de text editables a blanc
	 */
	public void campsInicials(){
		textFieldDni.setBackground(Color.WHITE);
		textFieldNom.setBackground(Color.WHITE);
		textFieldCognom1.setBackground(Color.WHITE);
		textFieldCognom2.setBackground(Color.WHITE);
		textFieldEdat.setBackground(Color.WHITE);
	}	
}
