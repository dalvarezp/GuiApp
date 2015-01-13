package model;
//Classe on guardo les dades de la persona
public class Persona {
	
	private String dni;
	private String nom;
	private String cognom1;
	private String cognom2;
	private int edat;
	
	public Persona(String dni, String nom, String cognom1, String cognom2,
			int edat) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.edat = edat;
	}
	
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the cognom1
	 */
	public String getCognom1() {
		return cognom1;
	}
	/**
	 * @param cognom1 the cognom1 to set
	 */
	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}
	/**
	 * @return the cognom2
	 */
	public String getCognom2() {
		return cognom2;
	}
	/**
	 * @param cognom2 the cognom2 to set
	 */
	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}
	/**
	 * @return the edat
	 */
	public int getEdat() {
		return edat;
	}
	/**
	 * @param edat the edat to set
	 */
	public void setEdat(int edat) {
		this.edat = edat;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return dni + ";" + nom + ";" + cognom1 + ";" + cognom2 + ";" + edat;
	}
	

}
