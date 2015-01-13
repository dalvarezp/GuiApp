package model;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

//Gestió de la llista de Persones
public class LlistaPersones extends LinkedList<Persona> {
	//Variable que controla la posició on ens trobem al mouren's per
	//l'aplicació
	private int posicio;

	public LlistaPersones() {
		posicio = 0;
	}

	/**
	 * Mètode que afageix una persona
	 * @param p
	 */
	public void afageixPersona(Persona p) {
		this.add(p);
		this.posicio++;
	}

	
	/**
	 * Mètode que elimina una persona de la llista
	 * @param p
	 */
	public void esborra(Persona p) {
		boolean eliminat = remove(p);
		if (eliminat) {
			if (posicio > 0) {
				this.posicio--;
			} else
				posicio = 0;
		}

	}

	public int darrer() {
		this.posicio = this.size() - 1;
		return posicio;
	}

	public int primer() {
		this.posicio = 0;
		return posicio;
	}

	public int anterior() {
		if (posicio > 0) {
			this.posicio--;
		} else
			posicio = 0;
		return posicio;
	}

	public int seguent() {
		if (posicio < this.size() - 1) {
			this.posicio++;
		} else
			posicio = this.size() - 1;
		return posicio;

	}

	/**
	 * Mètode que retorna la posicó actual
	 * 
	 */
	public int posicioActual() {
		return this.posicio;
	}

}
