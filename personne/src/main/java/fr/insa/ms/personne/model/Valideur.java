package fr.insa.ms.personne.model;

public class Valideur extends Personne {
	public Valideur(int id, String nom, String prenom, int age, String sexe) {
		super(id, nom, prenom, age, sexe);
	}

	@Override
	public String toString() {
		return "Valideur [getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getAge()=" + getAge() + ", getSexe()=" + getSexe() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
