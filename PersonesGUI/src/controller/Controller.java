package controller;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.LlistaPersones;
import model.Persona;
import view.JFramePersona;

public class Controller {

	private LlistaPersones llistaPersones;
	private JFramePersona jframePersona;
	private File arxiu;
	private String nomFitxer = "dades.csv";
	private boolean estat = false;//varible per controlar editar o afegir persona

	public Controller(LlistaPersones llistaPersones, JFramePersona jframePersona) {
		this.llistaPersones = llistaPersones;
		this.jframePersona = jframePersona;
	}

	/**
	 * Mètode on hi ha tots els listeners dels botons fets amb Lambda expressions
	 * fan les crudes als subprogrames que pertoquin
	 */
	public void control() {
		carregarFitxer();

		jframePersona.getButtonNou().addActionListener(event -> linkBtnNou());
		jframePersona.getButtonEsborrar().addActionListener(
				event -> linkBtnEsborrar());
		jframePersona.getButtonEdita().addActionListener(
				event -> linkBtnEditar());
		jframePersona.getButtonPrimer().addActionListener(
				event -> linkBtnPrimer());
		jframePersona.getButtonDarrer().addActionListener(
				event -> linkBtnDarrer());
		jframePersona.getButtonAnterior().addActionListener(
				event -> linkBtnAnterior());
		jframePersona.getButtonSeguent().addActionListener(
				event -> linkBtnSeguent());
		jframePersona.getButtonDesa().addActionListener(event -> linkBtnDesa());
		jframePersona.getButtonCancela().addActionListener(
				event -> linkBtnCancela());
		// Mètode per quan tanquem l'aplicació
		jframePersona.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				guardarLlistaAFitxer();
			}
		});
	}

	public void linkBtnNou() {
		jframePersona.setlblRegistre("Nou Registre.");
		jframePersona.campsModif();//canvio el color del fons dels camps de text
		netejaCamps();
		deshabilitarBotons();
	}

	/**
	 * Mètode que elimina una persona
	 */
	public void linkBtnEsborrar() {
		//primer demano si realment vol eliminar amb un panel de diàleg
		int op = jframePersona.dialegEsborrar();
		if (op == 0) {
			int pos = llistaPersones.posicioActual();
			int tamany = llistaPersones.size();
			if (tamany >= 1) {
				llistaPersones.esborra(llistaPersones.get(pos));
				jframePersona.setlblRegistre("Registre " + (pos) + " de "
						+ llistaPersones.size());
				if (llistaPersones.posicioActual() == 0)
					inicialitzarPanell();
			} else {
				inicialitzarPanell();
			}
		}
	}

	public void linkBtnEditar() {
		estat=true;
		jframePersona.campsModif();
		deshabilitarBotons();
		comprovarEntrades();
	}
	

	public void linkBtnPrimer() {
		// El mètode hauria d'anar a la vista i el controlador li passa les
		// dades per ser més correcte
		//Obting les dades de la persona de la primera posició i les mostro
		Persona p = llistaPersones.get(llistaPersones.primer());
		jframePersona.setTextDni(p.getDni());
		jframePersona.setTextNom(p.getNom());
		jframePersona.setTextCognom1(p.getCognom1());
		jframePersona.setTextCognom2(p.getCognom2());
		jframePersona.setTextEdat(p.getEdat() + "");
		jframePersona.setlblRegistre("Registre "
				+ (llistaPersones.posicioActual() + 1) + " de "
				+ llistaPersones.size());
	}

	/**
	 * Mètode que obté les dades de la persona que ocupa la
	 * darrera posició i les mostra 
	 */
	public void linkBtnDarrer() {
		Persona p = llistaPersones.get(llistaPersones.darrer());
		jframePersona.setTextDni(p.getDni());
		jframePersona.setTextNom(p.getNom());
		jframePersona.setTextCognom1(p.getCognom1());
		jframePersona.setTextCognom2(p.getCognom2());
		jframePersona.setTextEdat(p.getEdat() + "");
		jframePersona.setlblRegistre("Registre "
				+ (llistaPersones.posicioActual() + 1) + " de "
				+ llistaPersones.size());
	}

	/**
	 * Mètode que mostra la persona de la posició anterior respecte a l'actual
	 */
	public void linkBtnAnterior() {
		Persona p = llistaPersones.get(llistaPersones.anterior());
		jframePersona.setTextDni(p.getDni());
		jframePersona.setTextNom(p.getNom());
		jframePersona.setTextCognom1(p.getCognom1());
		jframePersona.setTextCognom2(p.getCognom2());
		jframePersona.setTextEdat(p.getEdat() + "");
		jframePersona.setlblRegistre("Registre "
				+ (llistaPersones.posicioActual() + 1) + " de "
				+ llistaPersones.size());

	}

	/**
	 * Mètode que mostra la persona de la posició següent a l'actual
	 */
	public void linkBtnSeguent() {
		Persona p = llistaPersones.get(llistaPersones.seguent());
		jframePersona.setTextDni(p.getDni());
		jframePersona.setTextNom(p.getNom());
		jframePersona.setTextCognom1(p.getCognom1());
		jframePersona.setTextCognom2(p.getCognom2());
		jframePersona.setTextEdat(p.getEdat() + "");
		jframePersona.setlblRegistre("Registre "
				+ (llistaPersones.posicioActual() + 1) + " de "
				+ llistaPersones.size());

	}

	public void linkBtnDesa() {
		jframePersona.campsInicials();
		if (comprovarEntrades()) {
			jframePersona.getButtonNou().setEnabled(true);
			jframePersona.getButtonEsborrar().setEnabled(true);
			jframePersona.getButtonEdita().setEnabled(true);
			jframePersona.getButtonPrimer().setEnabled(true);
			jframePersona.getButtonDarrer().setEnabled(true);
			jframePersona.getButtonAnterior().setEnabled(true);
			jframePersona.getButtonSeguent().setEnabled(true);
			jframePersona.getButtonDesa().setEnabled(false);
			jframePersona.getButtonCancela().setEnabled(false);						
		} else
			deshabilitarBotons();
	}

	/**
	 * Mètode cancelar. Borra els camps i activa botons
	 */
	public void linkBtnCancela() {
		netejaCamps();
		jframePersona.campsInicials();
		jframePersona.getButtonNou().setEnabled(true);
		jframePersona.getButtonEsborrar().setEnabled(true);
		jframePersona.getButtonEdita().setEnabled(true);
		jframePersona.getButtonPrimer().setEnabled(true);
		jframePersona.getButtonDarrer().setEnabled(true);
		jframePersona.getButtonAnterior().setEnabled(true);
		jframePersona.getButtonSeguent().setEnabled(true);
		jframePersona.getButtonDesa().setEnabled(false);
		jframePersona.getButtonCancela().setEnabled(false);
		inicialitzarPanell();
	}

	/**
	 * Mètode on carrego el contingut del fitxer a la llista
	 */
	public void carregarFitxer() {
		arxiu = new File(nomFitxer);
		try {

			if (arxiu.exists()) {
				Scanner lectorF = new Scanner(arxiu);
				while (lectorF.hasNextLine()) {
					String[] linia = lectorF.nextLine().split(";");
					llistaPersones.add(new Persona(linia[0], linia[1],
							linia[2], linia[3], Integer.parseInt(linia[4])));
				}
				lectorF.close();
			} else {
				arxiu.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		inicialitzarPanell();
	}

	/**
	 * Mètode on inicio del panell
	 * Si hi ha persones carrego la primera, sinó n'hi ha
	 * Mostro que no hi ha registres i només habilito el botó per
	 * afegir persones
	 */
	public void inicialitzarPanell() {
		if (llistaPersones.size() > 0) {
			jframePersona.setlblRegistre("Registre 1 de "
					+ llistaPersones.size());
			jframePersona.setTextDni(llistaPersones.get(0).getDni());
			jframePersona.setTextNom(llistaPersones.get(0).getNom());
			jframePersona.setTextCognom1(llistaPersones.get(0).getCognom1());
			jframePersona.setTextCognom2(llistaPersones.get(0).getCognom2());
			jframePersona.setTextEdat(llistaPersones.get(0).getEdat() + "");

		} else {
			jframePersona.setlblRegistre("0 Registres ");
			netejaCamps();
			jframePersona.getButtonNou().setEnabled(true);
			jframePersona.getButtonEsborrar().setEnabled(false);
			jframePersona.getButtonEdita().setEnabled(false);
			jframePersona.getButtonPrimer().setEnabled(false);
			jframePersona.getButtonDarrer().setEnabled(false);
			jframePersona.getButtonAnterior().setEnabled(false);
			jframePersona.getButtonSeguent().setEnabled(false);
			jframePersona.getButtonDesa().setEnabled(false);
			jframePersona.getButtonCancela().setEnabled(false);
		}
	}

	/**Mètode on guardo el contingut de la llista al fitxer
	 * al tancar l'aplicació
	 */
	public void guardarLlistaAFitxer() {
		try {
			FileWriter fr = new FileWriter(arxiu);
			for (Persona person : llistaPersones) {
				fr.write(person + "\r\n");
			}
			fr.close();
		} catch (IOException e) {
			System.out.println("Error! " + e);
		}
	}

	/**Mètode que comprova si els textos entrats són correctes
	 * si ho són retorna cert.
	 * @return
	 * 
	 * Segons si primer hem premut editar, edito o afageixo persona
	 */
	public boolean comprovarEntrades() {
		boolean correcte = true;

		boolean dni = jframePersona.getTextDni().matches(
				"(\\d{8})([-]?)([A-Z]{1})");
		boolean nom = jframePersona.getTextNom().matches(
				"[a-zàèéíòóúA-ZÀÈÉÍÒÓÚ]{2,50}");
		boolean cognom1 = jframePersona.getTextCognom1().matches(
				"[a-zàèéíòóúA-ZÀÈÉÍÒÓÚ]{2,50}");
		boolean cognom2 = jframePersona.getTextCognom2().matches(
				"[a-zàèéíòóúA-ZÀÈÉÍÒÓÚ]{2,50}");
		try {
			boolean edat = Integer.toString(jframePersona.getEdat()).matches(
					"^(([1-9][0-9][0-9])|([0-9][0-9])|([0-9]))$");

			String[] nCamps = { "  DNI", "  Nom", "  Primer Cognom",
					"  Segon Cognom", " Edat" };
			boolean[] vCamps = { dni, nom, cognom1, cognom2, edat };

			if (dni && nom && cognom1 && cognom2 && edat) {
				if(estat){
					editarPersona();
				}else{					
					afegirPersona();
					estat=false;
				}
						
				return correcte;
			} else {
				String missatgeError = "Has de rectificar els camps: ";
				for (int i = 0; i < vCamps.length; i++) {
					if (!vCamps[i]) {
						missatgeError += nCamps[i];
					}
				}
				jframePersona.errorEntrada(missatgeError);
				return false;
			}
		} catch (NumberFormatException e) {
			String missatgeError = "A l'Edat no hi has entrat un nombre.";
			jframePersona.errorEntrada(missatgeError);
			return false;
		}
	}

	/**
	 * Mètode que deixa sense texte els camps de text
	 */
	public void netejaCamps() {
		jframePersona.setTextDni("");
		jframePersona.setTextNom("");
		jframePersona.setTextCognom1("");
		jframePersona.setTextCognom2("");
		jframePersona.setTextEdat("");
	}

	/**Mètode on només es deixen habilitats els botons Desar i cancel.lar
	 * 
	 */
	public void deshabilitarBotons() {
		jframePersona.getButtonNou().setEnabled(false);
		jframePersona.getButtonEsborrar().setEnabled(false);
		jframePersona.getButtonEdita().setEnabled(false);
		jframePersona.getButtonPrimer().setEnabled(false);
		jframePersona.getButtonDarrer().setEnabled(false);
		jframePersona.getButtonAnterior().setEnabled(false);
		jframePersona.getButtonSeguent().setEnabled(false);
		jframePersona.getButtonDesa().setEnabled(true);
		jframePersona.getButtonCancela().setEnabled(true);
	}

	/**
	 * Mètode que afageix una persona a la llista
	 */
	public void afegirPersona() {
		Persona p = new Persona(jframePersona.getTextDni(),
				jframePersona.getTextNom(), jframePersona.getTextCognom1(),
				jframePersona.getTextCognom2(), jframePersona.getEdat());
		llistaPersones.afageixPersona(p);
		jframePersona.setlblRegistre("Registre " + llistaPersones.size()
				+ " de " + llistaPersones.size());
	}
	
	
	/**
	 * Mètode que permet editar una persona
	 */
	public void editarPersona() {
		llistaPersones.get(llistaPersones.posicioActual()).setDni(jframePersona.getTextDni());
		llistaPersones.get(llistaPersones.posicioActual()).setNom(jframePersona.getTextNom());
		llistaPersones.get(llistaPersones.posicioActual()).setCognom1(jframePersona.getTextCognom1());
		llistaPersones.get(llistaPersones.posicioActual()).setCognom2(jframePersona.getTextCognom2());
		llistaPersones.get(llistaPersones.posicioActual()).setEdat(jframePersona.getEdat());
		//proves de lambda expressions, no és de la pràctica
		llistaPersones.forEach(p -> System.out.println(p));
		System.out.println();
		llistaPersones.stream().filter(p -> p.getEdat()>25).forEach(p -> System.out.println(p));
		System.out.println();
		System.out.println("Mitjana dels majors de 25: " + llistaPersones.stream().filter(p -> p.getEdat()>25).mapToDouble(p -> p.getEdat()).average().getAsDouble());
	}
	

}
