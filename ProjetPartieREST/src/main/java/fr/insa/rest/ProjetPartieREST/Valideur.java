package fr.insa.rest.ProjetPartieREST;


public class Valideur extends Personne{
	public Valideur(int id, String nom, String prenom, int age) {
		super(id, nom, prenom, age);
	}
	public Valideur(int id) {
		super(id);
	}
	public String toString() {
		return "Valideur :" + this.getNom()+" "+this.getPrenom()+" ---- "+this.getAge()+" ans ---- "+this.getSexe();
	}
}