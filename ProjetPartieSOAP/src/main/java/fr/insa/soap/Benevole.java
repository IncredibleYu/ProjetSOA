package fr.insa.soap;

public class Benevole extends Personne{
	public Benevole(int id, String nom, String prenom, int age) {
		super(id, nom, prenom, age);
	}
	public Benevole(int id) {
		super(id);
	}
	public String toString() {
		return "Benevole :" + this.getNom()+" "+this.getPrenom()+" ---- "+this.getAge()+" ans ---- "+this.getSexe();
	}
}