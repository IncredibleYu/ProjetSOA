package fr.insa.ms.personne.model;

public class Benevole extends Personne {
	public Benevole(int id, String nom, String prenom, int age, String sexe) {
		super(id, nom, prenom, age, sexe);
	}

	@Override
	public String toString() {
		return "Benevole [getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getAge()=" + getAge() + ", getSexe()=" + getSexe() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
