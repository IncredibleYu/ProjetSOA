package fr.insa.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="GestionPersonne")
public class GestionPers {
	@WebMethod(operationName="addDemandeur")
	public Personne addDemandeur(int id, String nom, String prenom, int age, int sexe) {
		Demandeur n = new Demandeur(id, nom, prenom, age);
		n.setSexe(sexe);
		System.out.println("Nouveau Demandeur Ajout¨¦!!");
		return n;
	}
	@WebMethod(operationName="addBenevole")
	public Personne addBenevole(int id, String nom, String prenom, int age, int sexe) {
		Benevole n = new Benevole(id, nom, prenom, age);
		n.setSexe(sexe);
		System.out.println("Nouveau Benevole Ajout¨¦!!");
		return n;
	}
	@WebMethod(operationName="addValideur")
	public Personne addValideur(int id, String nom, String prenom, int age, int sexe) {
		Valideur n = new Valideur(id, nom, prenom, age);
		n.setSexe(sexe);
		System.out.println("Nouveau Valideur Ajout¨¦!!");
		return n;
	}
}
