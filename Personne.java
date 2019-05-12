package sys;

import java.util.Date;

/**
 * Classe Article
 * @author Yuxiao - Zili
 */

public class Personne {
	
	/** 
	 * Nom de la personne
	 */
	private String nom;

	/** 
	 * Prénom de la personne
	 */
	private String prenom;		

	/** 
	 * date de naissance
	 */
	private Date dateDeNaissance;		
	/** 
	 * la fonction de la personne
	 */
	private String fonction;		
	/** 
	 * id de la personne
	 */
	private int idPersonne;
	/** 
	 * id du badge
	 */
	private int numeroBadge;
	
	/**
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param date
	 * @param fonction
	 * @param idPerson
	 */
	public Personne (String nom,String prenom,Date date,String fonction,int idPersonne) {
		this.nom=nom;
		this.prenom=prenom;
		this.dateDeNaissance=date;
		this.fonction=fonction;
		this.idPersonne=idPersonne;
	}
		

	/**
	 *  getter du nom
	 */
	public String getNom() {
		return nom;		
	}
	
	/**
	 *  getter du prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 *  getter de la date de naissance
	 */
	public Date getDateDeNaissance() {
		return  dateDeNaissance;		
	}
	
	/**
	 *  getter de la fonction
	 */
	public String getFonction() {
		return fonction;		
	}
	
	/**
	 *  getter de l'id de la personne
	 */
	public int getIdPersonne() {
		return idPersonne;
	}
	/**
	 *  getter de numero de badge de la personne
	 */
	public int getNumeroBadge() {
		return numeroBadge;
	}
	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom=nom;
	}
	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	/**
	 * 
	 * @param dateDeNaissance
	 */
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	/**
	 * 
	 * @param fonction
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	/**
	 * 
	 * @param idPersonne
	 */
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	/**
	 * 
	 * @param numeroBadge
	 */
	public void setNumeroBadge(int numeroBadge) {
		this.numeroBadge = numeroBadge;
	}
	
	public String toString() {
		return nom+" "+prenom+" "+dateDeNaissance+" "+fonction+" "+idPersonne+" "+numeroBadge;
	}






}

