package fr.insa.ms.personne.model;

public class Person {
	private int id;
	private String nom;
	private String prenom;
	private int idmission;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getIdmission() {
		return idmission;
	}
	public void setIdmission(int idmission) {
		this.idmission = idmission;
	}
	public Person(int id, String nom, String prenom, int idmission) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.idmission = idmission;
	}

}
	