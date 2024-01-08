package fr.insa.soap;

public class Demandeur extends Personne{
	public Demandeur(int id, String nom, String prenom, int age) {
		super(id, nom, prenom, age);
	}
	public Demandeur(int id) {
		super(id);
	}
	public String toString() {
		return "Demandeur :" + this.getNom()+" "+this.getPrenom()+" ---- "+this.getAge()+" ans ---- "+this.getSexe();
	}
}